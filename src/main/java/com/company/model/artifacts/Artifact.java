package com.company.model.artifacts;

import com.company.model.services.Hashes;
import com.fasterxml.jackson.annotation.JsonSetter;
import lombok.Data;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@Data
public class Artifact {
    private LinkedHashSet<Mvn> mvn;
    @JsonSetter("target_repository")
    private String targetRepository;

    @JsonSetter("service-short-name")
    private String serviceShortName;
    @JsonSetter("service_name")
    private String serviceName;
    private Hashes hashes;
    private List<String> file;

    public boolean ComparisonByMandateFields(Artifact artifact) {
        if (targetRepository != null && mvn != null &&
                artifact.getTargetRepository() != null && artifact.getMvn() != null) {
            if (targetRepository.equals(artifact.getTargetRepository()) && mvn.equals(artifact.getMvn()))
                return true;
        }
        if (targetRepository != null && file != null &&
                artifact.getTargetRepository() != null && artifact.getFile() != null) {
            if (targetRepository.equals(artifact.getTargetRepository()) && file.equals(artifact.getFile()))
                return true;
        }
        return false;
    }

    public String fieldsToJsonString() {
        return this.toString();
    }
}
