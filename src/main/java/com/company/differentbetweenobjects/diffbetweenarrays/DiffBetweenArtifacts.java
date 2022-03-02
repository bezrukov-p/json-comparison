package com.company.differentbetweenobjects.diffbetweenarrays;

import com.company.model.artifacts.Artifact;
import com.company.model.services.Service;
import lombok.Data;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

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

    public void AddToEntriesDifferingOnLeft(Artifact artifact) {
        entriesDifferingOnLeft.add(artifact);
    }
    public void AddToEntriesDifferingOnRight(Artifact artifact) {
        entriesDifferingOnLeft.add(artifact);
    }
    public void AddToEntriesInCommon(Artifact artifact) {
        entriesInCommon.add(artifact);
    }
    public void AddToEntriesOnlyOnLeft(Collection<Artifact> artifacts) {
        entriesDifferingOnLeft.addAll(artifacts);
    }
    public void AddToEntriesOnlyOnRight(Collection<Artifact> artifacts) {
        entriesOnlyOnRight.addAll(artifacts);
    }
}
