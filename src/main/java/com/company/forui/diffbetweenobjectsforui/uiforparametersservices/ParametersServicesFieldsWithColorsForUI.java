package com.company.forui.diffbetweenobjectsforui.uiforparametersservices;

import lombok.Data;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

@Data
public class ParametersServicesFieldsWithColorsForUI {
    // строка - цвет
    Map<String, String> fields;

    {
        fields = new LinkedHashMap<>();
    }

    public ParametersServicesFieldsWithColorsForUI(Map<String, String> left, Map<String, String> right, Boolean isForLeft) {
        Map<String, String> params = (isForLeft) ? left : right;

        Map<String, String> leftCopy = new LinkedHashMap<>(left);
        Map<String, String> rightCopy = new LinkedHashMap<>(right);

        Iterator<String> itr = leftCopy.keySet().iterator();
        while(itr.hasNext()) {
            String key = itr.next();
            if (rightCopy.containsKey(key) && !leftCopy.get(key).equals(rightCopy.get(key))) {
                fields.put("\"" + key + "\": \"" + params.get(key) + "\"", "dark-orange");
                itr.remove();
                rightCopy.remove(key);
            }
        }

        itr = leftCopy.keySet().iterator();
        while(itr.hasNext()) {
            String key = itr.next();
            if (rightCopy.containsKey(key) && leftCopy.get(key).equals(rightCopy.get(key))) {
                fields.put("\"" + key + "\": \"" + params.get(key) + "\"", "white");
                itr.remove();
                rightCopy.remove(key);
            }
        }

        itr = (isForLeft) ? leftCopy.keySet().iterator() : rightCopy.keySet().iterator();
        String color = (isForLeft) ? "red" : "green";
        while(itr.hasNext()) {
            String key = itr.next();
            fields.put("\"" + key + "\": \"" + params.get(key) + "\"", color);
        }
    }
}
