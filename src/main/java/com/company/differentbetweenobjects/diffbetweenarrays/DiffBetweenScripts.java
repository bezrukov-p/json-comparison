package com.company.differentbetweenobjects.diffbetweenarrays;

import com.company.model.script.Script;
import lombok.Data;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

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

    public void addToEntriesDifferingOnLeft(Script script) {
        entriesDifferingOnLeft.add(script);
    }
    public void addToEntriesDifferingOnRight(Script script) {
        entriesDifferingOnRight.add(script);
    }
    public void addToEntriesInCommon(Script script) {
        entriesInCommon.add(script);
    }
    public void addToEntriesOnlyOnLeft(Collection<Script> scripts) {
        entriesOnlyOnLeft.addAll(scripts);
    }
    public void addToEntriesOnlyOnRight(Collection<Script> scripts) {
        entriesOnlyOnRight.addAll(scripts);
    }
}
