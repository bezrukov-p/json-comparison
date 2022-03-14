package com.company.difference.forui.parameters.common;

import com.company.difference.btwobjects.DiffBetweenParametersCommon;
import lombok.Data;

import java.util.Iterator;
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

    public DiffBetweenParametersCommonForUI(DiffBetweenParametersCommon diffBetweenParametersCommon) {
        Map<String, String> diffLeft = diffBetweenParametersCommon.getEntriesDifferingOnLeft();
        for (String key : diffLeft.keySet()) {
            paramsLeft.put("\"" + key + "\": \"" + diffLeft.get(key) + "\"", "orange");
        }

        Map<String, String> diffRight = diffBetweenParametersCommon.getEntriesDifferingOnRight();
        for (String key : diffRight.keySet()) {
            paramsRight.put("\"" + key + "\": \"" + diffRight.get(key) + "\"", "orange");
        }

        Map<String, String> common = diffBetweenParametersCommon.getEntriesInCommon();
        for (String key : common.keySet()) {
            paramsLeft.put("\"" + key + "\": \"" + common.get(key) + "\"", "white");
            paramsRight.put("\"" + key + "\": \"" + common.get(key) + "\"", "white");
        }

        Map<String, String> onlyLeft = diffBetweenParametersCommon.getEntriesOnlyOnLeft();
        for (String key : onlyLeft.keySet()) {
            paramsLeft.put("\"" + key + "\": \"" + onlyLeft.get(key) + "\"", "red");
        }

        Map<String, String> onlyRight = diffBetweenParametersCommon.getEntriesOnlyOnRight();
        for (String key : onlyRight.keySet()) {
            paramsRight.put("\"" + key + "\": \"" + onlyRight.get(key) + "\"", "green");
        }
    }
}
