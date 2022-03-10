package com.company.difference.forui.artifacts;

import com.company.difference.btwobjects.DiffBetweenArtifacts;
import com.company.difference.forui.artifacts.type1.Artifact1TypeFieldsForUI;
import com.company.difference.forui.artifacts.type2.Artifact2TypeFieldsForUI;
import com.company.difference.forui.artifacts.type2.Artifact2TypeFieldsWithColorsForUI;
import com.company.model.artifacts.Artifact;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class DiffBetweenArtifactsForUI {

    private List<Artifact2TypeFieldsWithColorsForUI> entriesDifferingOnLeftType2;
    private List<Artifact2TypeFieldsWithColorsForUI> entriesDifferingOnRightType2;
    private List<Artifact1TypeFieldsForUI> entriesInCommonType1;
    private List<Artifact2TypeFieldsForUI> entriesInCommonType2;
    private List<Artifact1TypeFieldsForUI> entriesOnlyOnLeftType1;
    private List<Artifact2TypeFieldsForUI> entriesOnlyOnLeftType2;
    private List<Artifact1TypeFieldsForUI> entriesOnlyOnRightType1;
    private List<Artifact2TypeFieldsForUI> entriesOnlyOnRightType2;

    {
        entriesDifferingOnLeftType2 = new ArrayList<>();
        entriesDifferingOnRightType2 = new ArrayList<>();
        entriesInCommonType1 = new ArrayList<>();
        entriesInCommonType2 = new ArrayList<>();
        entriesOnlyOnLeftType1 = new ArrayList<>();
        entriesOnlyOnLeftType2 = new ArrayList<>();
        entriesOnlyOnRightType1 = new ArrayList<>();
        entriesOnlyOnRightType2 = new ArrayList<>();
    }

    public DiffBetweenArtifactsForUI(DiffBetweenArtifacts diffBetweenArtifacts) {
        for (Artifact artifact : diffBetweenArtifacts.getEntriesInCommonType1())
            entriesInCommonType1.add(new Artifact1TypeFieldsForUI(artifact));
        for (Artifact artifact : diffBetweenArtifacts.getEntriesInCommonType2())
            entriesInCommonType2.add(new Artifact2TypeFieldsForUI(artifact));
        for(Artifact artifact : diffBetweenArtifacts.getEntriesOnlyOnLeftType1())
            entriesOnlyOnLeftType1.add(new Artifact1TypeFieldsForUI(artifact));
        for (Artifact artifact : diffBetweenArtifacts.getEntriesOnlyOnLeftType2())
            entriesOnlyOnLeftType2.add(new Artifact2TypeFieldsForUI(artifact));
        for (Artifact artifact : diffBetweenArtifacts.getEntriesOnlyOnRightType1())
            entriesOnlyOnRightType1.add(new Artifact1TypeFieldsForUI(artifact));
        for (Artifact artifact : diffBetweenArtifacts.getEntriesOnlyOnRightType2())
            entriesOnlyOnRightType2.add(new Artifact2TypeFieldsForUI(artifact));
        for (int i = 0; i < diffBetweenArtifacts.getEntriesDifferingOnLeftType2().size(); i++){
            Artifact artifact1 = diffBetweenArtifacts.getEntriesDifferingOnLeftType2().get(i);
            Artifact artifact2 = diffBetweenArtifacts.getEntriesDifferingOnRightType2().get(i);
            entriesDifferingOnLeftType2.add(new Artifact2TypeFieldsWithColorsForUI(artifact1, artifact2, true));
            entriesDifferingOnRightType2.add(new Artifact2TypeFieldsWithColorsForUI(artifact1, artifact2, false));
        }
    }
}
