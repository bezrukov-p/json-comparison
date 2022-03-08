package com.company.forui.diffbetweenobjectsforui;

import com.company.differentbetweenobjects.DiffBetweenParametersServices;
import com.company.forui.diffbetweenobjectsforui.uiforparametersservices.ParametersServicesFieldsWithColorsForUI;
import lombok.Data;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

@Data
public class DiffBetweenParametersServicesForUI {

    private Map<String, Map<String, String>> entriesInCommon;
    private Map<String, Map<String, String>> entriesOnlyOnLeft;
    private Map<String, Map<String, String>> entriesOnlyOnRight;

    // ключ - строка, поле - цвет
    private Map<String, ParametersServicesFieldsWithColorsForUI> entriesDifferingOnLeft;
    private Map<String, ParametersServicesFieldsWithColorsForUI> entriesDifferingOnRight;

    {
        entriesDifferingOnLeft = new LinkedHashMap<>();
        entriesDifferingOnRight = new LinkedHashMap<>();
    }


    public DiffBetweenParametersServicesForUI(DiffBetweenParametersServices diffBetweenParametersServices) {
        entriesInCommon = diffBetweenParametersServices.getEntriesInCommon();
        entriesOnlyOnLeft = diffBetweenParametersServices.getEntriesOnlyOnLeft();
        entriesOnlyOnRight = diffBetweenParametersServices.getEntriesOnlyOnRight();

        Map<String, Map<String, String>> diffLeft = diffBetweenParametersServices.getEntriesDifferingOnLeft();
        Map<String, Map<String, String>> diffRight = diffBetweenParametersServices.getEntriesDifferingOnRight();

        Iterator<String> itr = diffLeft.keySet().iterator();
        while(itr.hasNext()) {
            String key = itr.next();
            entriesDifferingOnLeft.put(
                    key, new ParametersServicesFieldsWithColorsForUI(diffLeft.get(key), diffRight.get(key), true));
            entriesDifferingOnRight.put(
                    key, new ParametersServicesFieldsWithColorsForUI(diffLeft.get(key), diffRight.get(key), false));
        }
    }


}
