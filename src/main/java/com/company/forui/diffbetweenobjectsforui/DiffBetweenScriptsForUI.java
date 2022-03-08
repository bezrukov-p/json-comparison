package com.company.forui.diffbetweenobjectsforui;

import com.company.differentbetweenobjects.DiffBetweenScripts;
import com.company.forui.diffbetweenobjectsforui.uiforscripts.ScriptFieldsForUI;
import com.company.forui.diffbetweenobjectsforui.uiforscripts.ScriptFieldsWithColorsForUI;
import com.company.model.script.Script;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class DiffBetweenScriptsForUI {

    List<ScriptFieldsWithColorsForUI> entriesDifferingOnLeft;
    List<ScriptFieldsWithColorsForUI> entriesDifferingOnRight;

    List<ScriptFieldsForUI> entriesInCommon;
    List<ScriptFieldsForUI> entriesOnlyOnLeft;
    List<ScriptFieldsForUI> entriesOnlyOnRight;


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
