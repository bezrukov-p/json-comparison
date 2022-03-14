package com.company.difference.btwobjects;

import lombok.Data;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

@Data
public class DiffBetweenParametersCommon {

    private Map<String, String> entriesInCommon;
    private Map<String, String> entriesOnlyOnLeft;
    private Map<String, String> entriesOnlyOnRight;
    private Map<String, String> entriesDifferingOnLeft;
    private Map<String, String> entriesDifferingOnRight;

    {
        entriesDifferingOnLeft = new LinkedHashMap<>();
        entriesDifferingOnRight = new LinkedHashMap<>();
        entriesInCommon = new LinkedHashMap<>();
        entriesOnlyOnLeft = new LinkedHashMap<>();
        entriesOnlyOnRight = new LinkedHashMap<>();
    }


    public DiffBetweenParametersCommon(Map<String, String> left, Map<String, String> right) {
        if (left == null)
            left = new LinkedHashMap<>();
        if (right == null)
            right = new LinkedHashMap<>();

        Map<String, String> l = new LinkedHashMap<>(left);
        Map<String, String> r = new LinkedHashMap<>(right);

        Iterator<String> itr = l.keySet().iterator();
        while(itr.hasNext()) {
            String key = itr.next();
            if (r.containsKey(key) && !l.get(key).equals(r.get(key))) {
                entriesDifferingOnLeft.put(key, l.get(key));
                entriesDifferingOnRight.put(key, r.get(key));
                itr.remove();
                r.remove(key);
            }
        }

        itr = l.keySet().iterator();
        while(itr.hasNext()) {
            String key = itr.next();
            if (r.containsKey(key) && l.get(key).equals(r.get(key))) {
                entriesInCommon.put(key, l.get(key));
                itr.remove();
                r.remove(key);
            }
        }

        entriesOnlyOnLeft.putAll(l);
        entriesOnlyOnRight.putAll(r);
    }
}
