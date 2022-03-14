package com.company.difference.btwobjects;

import com.company.model.services.Service;
import lombok.Data;

import java.util.*;

@Data
public class DiffBetweenServices {
    private List<Service> entriesDifferingOnLeft;
    private List<Service> entriesDifferingOnRight;
    private List<Service> entriesInCommon;
    private List<Service> entriesOnlyOnLeft;
    private List<Service> entriesOnlyOnRight;

    {
        entriesDifferingOnLeft = new ArrayList<>();
        entriesDifferingOnRight = new ArrayList<>();
        entriesInCommon = new ArrayList<>();
        entriesOnlyOnLeft = new ArrayList<>();
        entriesOnlyOnRight = new ArrayList<>();
    }

    public DiffBetweenServices(List<Service> services1, List<Service> services2) {

        //копия сервисов
        List<Service> servicesCopy1 = new LinkedList<>(services1);
        List<Service> servicesCopy2 = new LinkedList<>(services2);

        //сохраняем и удаляем полностью равные элементы
        Iterator<Service> itr = servicesCopy1.iterator();
        while(itr.hasNext()) {
            Service service = itr.next();
            if (servicesCopy2.contains(service)) {
                entriesInCommon.add(service);
                itr.remove();
                servicesCopy2.remove(service);
            }
        }

        //добавляем равные по мандаторным
        Iterator<Service> itr1 = servicesCopy1.iterator();
        while(itr1.hasNext()) {
            Service service1 = itr1.next();
            Iterator<Service> itr2 = servicesCopy2.iterator();
            while(itr2.hasNext()) {
                Service service2 = itr2.next();
                if (service1.comparisonByMandateFields(service2)) {
                    entriesDifferingOnLeft.add(service1);
                    entriesDifferingOnRight.add(service2);
                    itr1.remove();
                    itr2.remove();
                    break;
                }
            }
        }

        //оставшиеся только в левом или в правом
        entriesOnlyOnLeft.addAll(servicesCopy1);
        entriesOnlyOnRight.addAll(servicesCopy2);
    }
}
