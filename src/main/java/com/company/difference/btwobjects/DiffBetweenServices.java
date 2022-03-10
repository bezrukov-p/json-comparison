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
        Set<Service> servicesSet1 = new LinkedHashSet<>(services1);
        Set<Service> servicesSet2 = new LinkedHashSet<>(services2);

        //добавляем и удаляем полностью равные элементы
        Iterator<Service> itr = servicesSet1.iterator();
        while(itr.hasNext()) {
            Service service = itr.next();
            if (servicesSet2.contains(service)) {
                entriesInCommon.add(service);
                itr.remove();
                servicesSet2.remove(service);
            }
        }

        //добавляем равные по мандаторным
        Iterator<Service> itr1 = servicesSet1.iterator();
        while(itr1.hasNext()) {
            Service service1 = itr1.next();
            Iterator<Service> itr2 = servicesSet2.iterator();
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
        entriesOnlyOnLeft.addAll(servicesSet1);
        entriesOnlyOnRight.addAll(servicesSet2);
    }
}
