package com.company.differentbetweenobjects;

import com.company.model.script.Script;
import lombok.Data;

import java.util.*;

@Data
public class DiffBetweenScripts {
    private List<Script> entriesDifferingOnLeft;
    private List<Script> entriesDifferingOnRight;
    private List<Script> entriesInCommon;
    private List<Script> entriesOnlyOnLeft;
    private List<Script> entriesOnlyOnRight;

    {
        entriesDifferingOnLeft = new ArrayList<>();
        entriesDifferingOnRight = new ArrayList<>();
        entriesInCommon = new ArrayList<>();
        entriesOnlyOnLeft = new ArrayList<>();
        entriesOnlyOnRight = new ArrayList<>();
    }

    public DiffBetweenScripts(List<Script> scripts1, List<Script> scripts2) {
        Set<Script> scriptsSet1 = new LinkedHashSet<>(scripts1);
        Set<Script> scriptsSet2 = new LinkedHashSet<>(scripts2);

        Iterator<Script> itr = scriptsSet1.iterator();
        while (itr.hasNext()) {
            Script script = itr.next();
            if(scriptsSet2.contains(script)) {
                entriesInCommon.add(script);
                itr.remove();
                scriptsSet2.remove(script);
            }
        }

        Iterator<Script> itr1 = scriptsSet1.iterator();

        while(itr1.hasNext()) {
            Script script1 = itr1.next();
            Iterator<Script> itr2 = scriptsSet2.iterator();
            while(itr2.hasNext()) {
                Script script2 = itr2.next();
                if (script1.ComparisonByMandateFields(script2)) {
                    entriesDifferingOnLeft.add(script1);
                    entriesDifferingOnRight.add(script2);
                    itr1.remove();
                    itr2.remove();
                    break;
                }
            }
        }


        entriesOnlyOnLeft.addAll(scriptsSet1);
        entriesOnlyOnRight.addAll(scriptsSet2);
    }

}
