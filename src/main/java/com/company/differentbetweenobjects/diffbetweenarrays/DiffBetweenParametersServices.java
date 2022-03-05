package com.company.differentbetweenobjects.diffbetweenarrays;

import com.company.model.script.Script;
import lombok.Data;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

@Data
public class DiffBetweenParametersServices {
    private Map<String, Map<String, String>> entriesInCommon;
    private Map<String, Map<String, String>> entriesOnlyOnLeft;
    private Map<String, Map<String, String>> entriesOnlyOnRight;
    private Map<String, Map<String, String>> entriesDifferingOnLeft;
    private Map<String, Map<String, String>> entriesDifferingOnRight;

    {
        entriesDifferingOnLeft = new LinkedHashMap<>();
        entriesDifferingOnRight = new LinkedHashMap<>();
        entriesInCommon = new LinkedHashMap<>();
        entriesOnlyOnLeft = new LinkedHashMap<>();
        entriesOnlyOnRight = new LinkedHashMap<>();
    }
}
