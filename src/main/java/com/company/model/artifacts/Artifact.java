package com.company.model.artifacts;

import com.company.model.services.Hashes;
import com.fasterxml.jackson.annotation.JsonSetter;
import lombok.Data;
import org.apache.commons.collections4.CollectionUtils;

import java.util.List;
import java.util.Objects;

@Data
public class Artifact {
    private List<Mvn> mvn;
    @JsonSetter("target_repository")
    private String targetRepository;

    @JsonSetter("service-short-name")
    private String serviceShortName;
    @JsonSetter("service_name")
    private String serviceName;
    private Hashes hashes;
    private List<String> file;

    public boolean comparisonByMandateFields(Artifact artifact) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Artifact artifact = (Artifact) o;

        boolean isMvnEquals = false;
        if (mvn == null && artifact.mvn == null)
            isMvnEquals = true;
        if (mvn != null && artifact.mvn != null) {
            if (CollectionUtils.isEqualCollection(mvn, artifact.mvn))
                isMvnEquals = true;
        }


        return isMvnEquals
                && Objects.equals(targetRepository, artifact.targetRepository)
                && Objects.equals(serviceShortName, artifact.serviceShortName)
                && Objects.equals(serviceName, artifact.serviceName)
                && Objects.equals(hashes, artifact.hashes)
                && Objects.equals(file, artifact.file);
    }
}
