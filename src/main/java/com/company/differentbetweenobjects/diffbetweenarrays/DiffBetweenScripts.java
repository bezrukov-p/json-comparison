package com.company.differentbetweenobjects.diffbetweenarrays;

import com.company.model.script.Script;
import com.company.model.services.Service;
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

    public void AddToEntriesDifferingOnLeft(Script script) {
        entriesDifferingOnLeft.add(script);
    }
    public void AddToEntriesDifferingOnRight(Script script) {
        entriesDifferingOnLeft.add(script);
    }
    public void AddToEntriesInCommon(Script script) {
        entriesInCommon.add(script);
    }
    public void AddToEntriesOnlyOnLeft(Collection<Script> scripts) {
        entriesDifferingOnLeft.addAll(scripts);
    }
    public void AddToEntriesOnlyOnRight(Collection<Script> scripts) {
        entriesOnlyOnRight.addAll(scripts);
    }
}
