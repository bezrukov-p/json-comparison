package com.company.differentbetweenobjects;

import com.company.differentbetweenobjects.diffbetweenarrays.DiffBetweenArtifacts;
import com.company.differentbetweenobjects.diffbetweenarrays.DiffBetweenScripts;
import com.company.differentbetweenobjects.diffbetweenarrays.DiffBetweenServices;
import com.company.model.artifacts.Artifact;
import com.company.model.script.Script;
import com.company.model.services.Service;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;

@Component
public class DifferenceBetweenObjects {

    public DiffBetweenServices DifferenceBetweenListsOfServices(List<Service> services1, List<Service> services2) {
        HashSet<Service> servicesHash1 = new LinkedHashSet<>(services1);
        HashSet<Service> servicesHash2 = new LinkedHashSet<>(services2);

        DiffBetweenServices diffBtwServices = new DiffBetweenServices();
        for(Service service1 : servicesHash1) {
            if (servicesHash2.contains(service1)) {
                diffBtwServices.AddToEntriesInCommon(service1);
                servicesHash1.remove(service1);
                servicesHash2.remove(service1);
            }
        }
        for(Service service1 : servicesHash1) {
            for(Service service2 : servicesHash2) {
                if (service1.ComparisonByMandateFields(service2)) {
                    diffBtwServices.AddToEntriesDifferingOnLeft(service1);
                    diffBtwServices.AddToEntriesDifferingOnRight(service2);
                    servicesHash1.remove(service1);
                    servicesHash2.remove(service2);
                }
            }
        }
        diffBtwServices.AddToEntriesOnlyOnLeft(servicesHash1);
        diffBtwServices.AddToEntriesOnlyOnRight(servicesHash2);

        return diffBtwServices;
    }

    public DiffBetweenScripts DifferenceBetweenListsOfScripts(List<Script> scripts1, List<Script> scripts2) {
        HashSet<Script> scriptsHash1 = new LinkedHashSet<>(scripts1);
        HashSet<Script> scriptsHash2 = new LinkedHashSet<>(scripts2);

        DiffBetweenScripts diffBtwScripts = new DiffBetweenScripts();
        for(Script script1 : scriptsHash1) {
            if (scriptsHash2.contains(script1)) {
                diffBtwScripts.AddToEntriesInCommon(script1);
                scriptsHash1.remove(script1);
                scriptsHash2.remove(script1);
            }
        }
        for(Script script1 : scriptsHash1) {
            for(Script script2 : scriptsHash2) {
                if (script1.ComparisonByMandateFields(script2)) {
                    diffBtwScripts.AddToEntriesDifferingOnLeft(script1);
                    diffBtwScripts.AddToEntriesDifferingOnRight(script2);
                    scriptsHash1.remove(script1);
                    scriptsHash2.remove(script2);
                }
            }
        }
        diffBtwScripts.AddToEntriesOnlyOnLeft(scriptsHash1);
        diffBtwScripts.AddToEntriesOnlyOnRight(scriptsHash2);

        return diffBtwScripts;
    }

    /*public DiffBetweenArtifacts DifferenceBetweenListsOfArtifacts(List<Artifact> artifacts1, List<Artifact> artifacts2) {
        HashSet<Artifact> artifactsHash1 = new LinkedHashSet<>(artifacts1);
        HashSet<Artifact> artifactsHash2 = new LinkedHashSet<>(artifacts2);

        DiffBetweenArtifacts diffBtwArtifacts = new DiffBetweenArtifacts();
        for(Artifact artifact1 : artifactsHash1) {
            if (artifactsHash2.contains(artifact1)) {
                diffBtwArtifacts.AddToEntriesInCommon(artifact1);
                artifactsHash1.remove(artifact1);
                artifactsHash2.remove(artifact1);
            }
        }
        for(Artifact artifact1 : artifactsHash1) {
            for(Artifact artifact2 : artifactsHash2) {
                if (artifact1.ComparisonByMandateFields(artifact2)) {
                    diffBtwArtifacts.AddToEntriesDifferingOnLeft(artifact1);
                    diffBtwArtifacts.AddToEntriesDifferingOnRight(artifact2);
                    artifactsHash1.remove(artifact1);
                    artifactsHash2.remove(artifact2);
                }
            }
        }
        diffBtwArtifacts.AddToEntriesOnlyOnLeft(artifactsHash1);
        diffBtwArtifacts.AddToEntriesOnlyOnRight(artifactsHash2);

        return diffBtwArtifacts;
    }*/



}
