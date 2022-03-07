package com.company.differentbetweenobjects;

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
        this.differenceBetweenListsOfServices(services1, services2);
    }

    private void differenceBetweenListsOfServices(List<Service> services1, List<Service> services2) {
        Set<Service> servicesSet1 = new LinkedHashSet<>(services1);
        Set<Service> servicesSet2 = new LinkedHashSet<>(services2);

        Iterator<Service> itr = servicesSet1.iterator();
        while(itr.hasNext()) {
            Service service = itr.next();
            if (servicesSet2.contains(service)) {
                entriesInCommon.add(service);
                itr.remove();
                servicesSet2.remove(service);
            }
        }

        Iterator<Service> itr1 = servicesSet1.iterator();
        while(itr1.hasNext()) {
            Service service1 = itr1.next();
            Iterator<Service> itr2 = servicesSet2.iterator();
            while(itr2.hasNext()) {
                Service service2 = itr2.next();
                if (service1.ComparisonByMandateFields(service2)) {
                    entriesDifferingOnLeft.add(service1);
                    entriesDifferingOnRight.add(service2);
                    itr1.remove();
                    itr2.remove();
                    break;
                }
            }
        }

        entriesOnlyOnLeft.addAll(servicesSet1);
        entriesOnlyOnRight.addAll(servicesSet2);
    }
}
