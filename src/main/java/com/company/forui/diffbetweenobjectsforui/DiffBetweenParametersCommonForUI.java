package com.company.forui.diffbetweenobjectsforui;

import lombok.Data;

import java.util.LinkedHashMap;
import java.util.Map;

@Data
public class DiffBetweenParametersCommonForUI {
    private Map<String, String> paramsLeft;
    private Map<String, String> paramsRight;

    {
        paramsLeft = new LinkedHashMap<>();
        paramsRight = new LinkedHashMap<>();
    }

    public DiffBetweenParametersCommonForUI(Map<String, String> left, Map<String, String> right) {
        for (String key : left.keySet()) {
            String color = "white";
            if (right.containsKey(key)) {
                if (!left.get(key).equals(right.get(key)))
                    color = "orange";
            }
            else
                color = "red";
            paramsLeft.put("\"" + key + "\": \"" + left.get(key) + "\"", color);
        }

        for (String key : right.keySet()) {
            String color = "white";
            if (left.containsKey(key)) {
                if (!left.get(key).equals(right.get(key)))
                    color = "orange";
            }
            else
                color = "green";
            paramsRight.put("\"" + key + "\": \"" + right.get(key) + "\"", color);
        }
    }
}
