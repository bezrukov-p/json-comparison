package com.company.differentbetweenobjects;

import com.company.model.artifacts.Artifact;
import com.company.model.script.Script;
import com.company.model.services.Service;
import lombok.Data;

import java.util.*;

@Data
public class DiffBetweenArtifacts {
    private List<Artifact> entriesDifferingOnLeft;
    private List<Artifact> entriesDifferingOnRight;
    private List<Artifact> entriesInCommon;
    private List<Artifact> entriesOnlyOnLeft;
    private List<Artifact> entriesOnlyOnRight;

    {
        entriesDifferingOnLeft = new ArrayList<>();
        entriesDifferingOnRight = new ArrayList<>();
        entriesInCommon = new ArrayList<>();
        entriesOnlyOnLeft = new ArrayList<>();
        entriesOnlyOnRight = new ArrayList<>();
    }

    public DiffBetweenArtifacts(List<Artifact> artifacts1, List<Artifact> artifacts2) {
        Set<Artifact> artifactsSet1 = new LinkedHashSet<>(artifacts1);
        Set<Artifact> artifactsSet2 = new LinkedHashSet<>(artifacts2);

        Iterator<Artifact> itr = artifactsSet1.iterator();
        while (itr.hasNext()) {
            Artifact artifact = itr.next();
            if(artifactsSet2.contains(artifact)) {
                entriesInCommon.add(artifact);
                itr.remove();
                artifactsSet2.remove(artifact);
            }
        }

        Iterator<Artifact> itr1 = artifactsSet1.iterator();
        while(itr1.hasNext()) {
            Artifact artifact1 = itr1.next();
            Iterator<Artifact> itr2 = artifactsSet2.iterator();
            while(itr2.hasNext()) {
                Artifact artifact2 = itr2.next();
                if (artifact1.ComparisonByMandateFields(artifact2)) {
                    entriesDifferingOnLeft.add(artifact1);
                    entriesDifferingOnRight.add(artifact2);
                    itr1.remove();
                    itr2.remove();
                    break;
                }
            }
        }


        entriesOnlyOnLeft.addAll(artifactsSet1);
        entriesOnlyOnRight.addAll(artifactsSet2);
    }
}
