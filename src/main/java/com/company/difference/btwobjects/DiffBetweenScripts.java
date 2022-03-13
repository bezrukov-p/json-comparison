package com.company.difference.btwobjects;

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
        List<Script> scriptsCopy1 = new LinkedList<>(scripts1);
        List<Script> scriptsCopy2 = new LinkedList<>(scripts2);

        Iterator<Script> itr = scriptsCopy1.iterator();
        while (itr.hasNext()) {
            Script script = itr.next();
            if(scriptsCopy2.contains(script)) {
                entriesInCommon.add(script);
                itr.remove();
                scriptsCopy2.remove(script);
            }
        }

        Iterator<Script> itr1 = scriptsCopy1.iterator();

        while(itr1.hasNext()) {
            Script script1 = itr1.next();
            Iterator<Script> itr2 = scriptsCopy2.iterator();
            while(itr2.hasNext()) {
                Script script2 = itr2.next();
                if (script1.comparisonByMandateFields(script2)) {
                    entriesDifferingOnLeft.add(script1);
                    entriesDifferingOnRight.add(script2);
                    itr1.remove();
                    itr2.remove();
                    break;
                }
            }
        }


        entriesOnlyOnLeft.addAll(scriptsCopy1);
        entriesOnlyOnRight.addAll(scriptsCopy2);
    }

}
