package com.company.differentbetweenobjects;

import com.company.differentbetweenobjects.diffbetweenarrays.DiffBetweenParametersServices;
import com.company.differentbetweenobjects.diffbetweenarrays.DiffBetweenScripts;
import com.company.differentbetweenobjects.diffbetweenarrays.DiffBetweenServices;
import com.company.model.script.Script;
import com.company.model.services.Service;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class DifferenceBetweenObjects {

    public DiffBetweenServices differenceBetweenListsOfServices(List<Service> services1, List<Service> services2) {
        Set<Service> servicesSet1 = new LinkedHashSet<>(services1);
        Set<Service> servicesSet2 = new LinkedHashSet<>(services2);

        DiffBetweenServices result = new DiffBetweenServices();

        Iterator<Service> itr = servicesSet1.iterator();
        while(itr.hasNext()) {
            Service service = itr.next();
            if (servicesSet2.contains(service)) {
                result.addToEntriesInCommon(service);
                itr.remove();
                servicesSet2.remove(service);
            }
        }

        Iterator<Service> itr1 = servicesSet1.iterator();
        Iterator<Service> itr2 = servicesSet2.iterator();
        while(itr1.hasNext()) {
            Service service1 = itr1.next();
            while(itr2.hasNext()) {
                Service service2 = itr2.next();
                if (service1.ComparisonByMandateFields(service2)) {
                    result.addToEntriesDifferingOnLeft(service1);
                    result.addToEntriesDifferingOnRight(service2);
                    itr1.remove();
                    itr2.remove();
                    break;
                }
            }
        }

        result.addToEntriesOnlyOnLeft(servicesSet1);
        result.addToEntriesOnlyOnRight(servicesSet2);

        return result;
    }

    public DiffBetweenScripts differenceBetweenListsOfScripts(List<Script> scripts1, List<Script> scripts2) {
        Set<Script> scriptsSet1 = new LinkedHashSet<>(scripts1);
        Set<Script> scriptsSet2 = new LinkedHashSet<>(scripts2);

        DiffBetweenScripts result = new DiffBetweenScripts();

        Iterator<Script> itr = scriptsSet1.iterator();
        while (itr.hasNext()) {
            Script script = itr.next();
            if(scriptsSet2.contains(script)) {
                result.addToEntriesInCommon(script);
                itr.remove();
                scriptsSet2.remove(script);
            }
        }

        Iterator<Script> itr1 = scriptsSet1.iterator();
        Iterator<Script> itr2 = scriptsSet2.iterator();

        while(itr1.hasNext()) {
            Script script1 = itr1.next();
            while(itr2.hasNext()) {
                Script script2 = itr2.next();
                if (script1.ComparisonByMandateFields(script2)) {
                    result.addToEntriesDifferingOnLeft(script1);
                    result.addToEntriesDifferingOnRight(script2);
                    itr1.remove();
                    itr2.remove();
                    break;
                }
            }
        }


        result.addToEntriesOnlyOnLeft(scriptsSet1);
        result.addToEntriesOnlyOnRight(scriptsSet2);

        return result;
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

    public DiffBetweenParametersServices diffBetweenParametersServices(Map<String, Map<String, String>> services1,
                                                                       Map<String, Map<String, String>> services2) {
        Map<String, Map<String, String>> s1 = new LinkedHashMap<>(services1);
        Map<String, Map<String, String>> s2 = new LinkedHashMap<>(services2);
        DiffBetweenParametersServices result = new DiffBetweenParametersServices();

        for (Map.Entry<String, Map<String, String>> entry : s1.entrySet()) {
            String key = entry.getKey();
            if (s2.containsKey(key)) {
                if (s1.get(key).equals(s2.get(key))) {
                    result.getEntriesInCommon().put(key, entry.getValue());
                } else {
                    result.getEntriesDifferingOnLeft().put(key, s1.get(key));
                    result.getEntriesDifferingOnRight().put(key, s2.get(key));
                }
                s1.remove(key);
                s2.remove(key);
            }
        }

        result.getEntriesOnlyOnLeft().putAll(s1);
        result.getEntriesOnlyOnRight().putAll(s2);

        return result;
    }



}
