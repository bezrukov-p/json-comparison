package com.company.forui.diffbetweenobjectsforui;

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

    public DiffBetweenParametersCommonForUI(Map<String, String> left, Map<String, String> right) {
        Map<String, String> l = new LinkedHashMap<>(left);
        Map<String, String> r = new LinkedHashMap<>(right);

        Iterator<String> itr = l.keySet().iterator();
        while(itr.hasNext()) {
            String key = itr.next();
            if (r.containsKey(key) && !l.get(key).equals(r.get(key))) {
                paramsLeft.put("\"key\": \"" + l.get(key) + "\"", "orange");
                paramsRight.put("\"key\": \"" + r.get(key) + "\"", "orange");
                itr.remove();
                r.remove(key);
            }
        }

        itr = l.keySet().iterator();
        while(itr.hasNext()) {
            String key = itr.next();
            if (r.containsKey(key) && l.get(key).equals(r.get(key))) {
                paramsLeft.put("\"key\": \"" + l.get(key) + "\"", "white");
                paramsRight.put("\"key\": \"" + r.get(key) + "\"", "white");
                itr.remove();
                r.remove(key);
            }
        }

        itr = l.keySet().iterator();
        while(itr.hasNext()) {
            String key = itr.next();
            paramsLeft.put("\"key\": \"" + l.get(key) + "\"", "red");
        }

        itr = r.keySet().iterator();
        while(itr.hasNext()) {
            String key = itr.next();
            paramsRight.put("\"key\": \"" + r.get(key) + "\"", "green");
        }
    }
}
