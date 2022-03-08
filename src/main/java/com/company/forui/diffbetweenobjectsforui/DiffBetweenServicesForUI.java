package com.company.forui.diffbetweenobjectsforui;

import com.company.differentbetweenobjects.DiffBetweenServices;
import com.company.forui.diffbetweenobjectsforui.uiforservices.ServiceFieldsForUI;
import com.company.forui.diffbetweenobjectsforui.uiforservices.ServiceFieldsWithColorsForUI;
import com.company.model.services.Service;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class DiffBetweenServicesForUI {

    List<ServiceFieldsWithColorsForUI> entriesDifferingOnLeft;
    List<ServiceFieldsWithColorsForUI> entriesDifferingOnRight;

    List<ServiceFieldsForUI> entriesInCommon;
    List<ServiceFieldsForUI> entriesOnlyOnLeft;
    List<ServiceFieldsForUI> entriesOnlyOnRight;

    {
        entriesDifferingOnLeft = new ArrayList<>();
        entriesDifferingOnRight = new ArrayList<>();
        entriesInCommon = new ArrayList<>();
        entriesOnlyOnLeft = new ArrayList<>();
        entriesOnlyOnRight = new ArrayList<>();
    }

    public DiffBetweenServicesForUI(DiffBetweenServices diffBetweenServices) {
        for(Service service: diffBetweenServices.getEntriesInCommon())
            entriesInCommon.add(new ServiceFieldsForUI(service));
        for(Service service: diffBetweenServices.getEntriesOnlyOnLeft())
            entriesOnlyOnLeft.add(new ServiceFieldsForUI(service));
        for (Service service: diffBetweenServices.getEntriesOnlyOnRight())
            entriesOnlyOnRight.add(new ServiceFieldsForUI(service));

        int size = diffBetweenServices.getEntriesDifferingOnLeft().size();
        for(int i = 0; i < size; i++) {
            Service serviceLeft = diffBetweenServices.getEntriesDifferingOnLeft().get(i);
            Service serviceRight = diffBetweenServices.getEntriesDifferingOnRight().get(i);
            entriesDifferingOnLeft.add(new ServiceFieldsWithColorsForUI(serviceLeft, serviceRight, true));
            entriesDifferingOnRight.add(new ServiceFieldsWithColorsForUI(serviceLeft, serviceRight, false));
        }
    }
}
