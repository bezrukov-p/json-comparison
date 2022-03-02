package com.company.differentbetweenobjects.diffbetweenarrays;

import com.company.model.services.Service;
import lombok.Data;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

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

    public void AddToEntriesDifferingOnLeft(Service service) {
        entriesDifferingOnLeft.add(service);
    }
    public void AddToEntriesDifferingOnRight(Service service) {
        entriesDifferingOnLeft.add(service);
    }
    public void AddToEntriesInCommon(Service service) {
        entriesInCommon.add(service);
    }
    public void AddToEntriesOnlyOnLeft(Collection<Service> services) {
        entriesDifferingOnLeft.addAll(services);
    }
    public void AddToEntriesOnlyOnRight(Collection<Service> services) {
        entriesOnlyOnRight.addAll(services);
    }
}
