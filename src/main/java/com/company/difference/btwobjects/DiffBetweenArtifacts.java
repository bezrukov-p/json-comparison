package com.company.difference.btwobjects;

import com.company.model.artifacts.Artifact;
import lombok.Data;

import java.util.*;

@Data
public class DiffBetweenArtifacts {
    private List<Artifact> entriesDifferingOnLeftType2;
    private List<Artifact> entriesDifferingOnRightType2;
    private List<Artifact> entriesInCommonType1;
    private List<Artifact> entriesInCommonType2;
    private List<Artifact> entriesOnlyOnLeftType1;
    private List<Artifact> entriesOnlyOnLeftType2;
    private List<Artifact> entriesOnlyOnRightType1;
    private List<Artifact> entriesOnlyOnRightType2;

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

    public DiffBetweenArtifacts(List<Artifact> artifacts1, List<Artifact> artifacts2) {

        Set<Artifact> artifacts1Type1 = new LinkedHashSet<>();
        Set<Artifact> artifacts1Type2 = new LinkedHashSet<>();
        Set<Artifact> artifacts2Type1 = new LinkedHashSet<>();
        Set<Artifact> artifacts2Type2 = new LinkedHashSet<>();

        for(Artifact artifact : artifacts1) {
            if (artifact.getMvn() != null)
                artifacts1Type1.add(artifact);
            else
                artifacts1Type2.add(artifact);
        }
        for(Artifact artifact : artifacts2) {
            if (artifact.getMvn() != null)
                artifacts2Type1.add(artifact);
            else
                artifacts2Type2.add(artifact);
        }

        Iterator<Artifact> itr = artifacts1Type1.iterator();
        while(itr.hasNext()) {
            Artifact artifact = itr.next();
            if (artifacts2Type1.contains(artifact)) {
                entriesInCommonType1.add(artifact);
                itr.remove();
                artifacts2Type1.remove(artifact);
            }
        }
        entriesOnlyOnLeftType1.addAll(artifacts1Type1);
        entriesOnlyOnRightType1.addAll(artifacts2Type1);

        /////////////////////////////////////////////////////////////////////////

        itr = artifacts1Type2.iterator();
        while (itr.hasNext()) {
            Artifact artifact = itr.next();
            if (artifacts2Type2.contains(artifact)) {
                entriesInCommonType2.add(artifact);
                itr.remove();
                artifacts2Type2.remove(artifact);
            }
        }

        Iterator<Artifact> itr1 = artifacts1Type2.iterator();
        while (itr1.hasNext()) {
            Artifact artifact1 = itr1.next();
            Iterator<Artifact> itr2 = artifacts2Type2.iterator();
            while(itr2.hasNext()) {
                Artifact artifact2 = itr2.next();
                if (artifact1.comparisonByMandateFields(artifact2)) {
                    entriesDifferingOnLeftType2.add(artifact1);
                    entriesDifferingOnRightType2.add(artifact2);
                    itr1.remove();
                    itr2.remove();
                    break;
                }
            }
        }

        entriesOnlyOnLeftType2.addAll(artifacts1Type2);
        entriesOnlyOnRightType2.addAll(artifacts2Type2);



    }
}
