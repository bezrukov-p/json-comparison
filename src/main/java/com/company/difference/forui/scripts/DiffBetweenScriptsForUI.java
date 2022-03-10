package com.company.difference.forui.scripts;

import com.company.difference.btwobjects.DiffBetweenScripts;
import com.company.model.script.Script;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class DiffBetweenScriptsForUI {

    private List<ScriptFieldsWithColorsForUI> entriesDifferingOnLeft;
    private List<ScriptFieldsWithColorsForUI> entriesDifferingOnRight;

    private List<ScriptFieldsForUI> entriesInCommon;
    private List<ScriptFieldsForUI> entriesOnlyOnLeft;
    private List<ScriptFieldsForUI> entriesOnlyOnRight;


    {
        entriesDifferingOnLeft = new ArrayList<>();
        entriesDifferingOnRight = new ArrayList<>();
        entriesInCommon = new ArrayList<>();
        entriesOnlyOnLeft = new ArrayList<>();
        entriesOnlyOnRight = new ArrayList<>();
    }

    public DiffBetweenScriptsForUI(DiffBetweenScripts diffBetweenScripts) {
        for (Script script: diffBetweenScripts.getEntriesInCommon())
            entriesInCommon.add(new ScriptFieldsForUI(script));
        for (Script script: diffBetweenScripts.getEntriesOnlyOnLeft())
            entriesOnlyOnLeft.add(new ScriptFieldsForUI(script));
        for (Script script: diffBetweenScripts.getEntriesOnlyOnRight())
            entriesOnlyOnRight.add(new ScriptFieldsForUI(script));

        int size = diffBetweenScripts.getEntriesDifferingOnLeft().size();
        for(int i = 0; i < size; i++) {
            Script scriptLeft = diffBetweenScripts.getEntriesDifferingOnLeft().get(i);
            Script scriptRight = diffBetweenScripts.getEntriesDifferingOnRight().get(i);
            entriesDifferingOnLeft.add(new ScriptFieldsWithColorsForUI(scriptLeft, scriptRight, true));
            entriesDifferingOnRight.add(new ScriptFieldsWithColorsForUI(scriptLeft, scriptRight, false));
        }
    }
}
