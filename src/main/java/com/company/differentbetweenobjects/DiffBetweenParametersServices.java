package com.company.differentbetweenobjects;

import lombok.Data;

import java.util.Iterator;
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

    public DiffBetweenParametersServices(Map<String, Map<String, String>> services1,
                                         Map<String, Map<String, String>> services2) {
        Map<String, Map<String, String>> s1 = new LinkedHashMap<>(services1);
        Map<String, Map<String, String>> s2 = new LinkedHashMap<>(services2);

        Iterator<String> itr1 = s1.keySet().iterator();
        while(itr1.hasNext()) {
            String key = itr1.next();
            if (s2.containsKey(key)) {
                if (s1.get(key).equals(s2.get(key)))
                    entriesInCommon.put(key, s1.get(key));
                else {
                    entriesDifferingOnLeft.put(key, s1.get(key));
                    entriesDifferingOnRight.put(key, s2.get(key));
                }
                itr1.remove();
                s2.remove(key);
            }
        }
        entriesOnlyOnLeft.putAll(s1);
        entriesOnlyOnRight.putAll(s2);
    }
}
