package com.company.model.artifacts;

import com.company.model.services.Hashes;
import com.fasterxml.jackson.annotation.JsonSetter;

import java.util.List;

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

    public Artifact() {
    }

    public Artifact(List<Mvn> mvn, String targetRepository, String serviceShortName,
                    String serviceName, Hashes hashes, List<String> file) {
        this.mvn = mvn;
        this.targetRepository = targetRepository;
        this.serviceShortName = serviceShortName;
        this.serviceName = serviceName;
        this.hashes = hashes;
        this.file = file;
    }

    public List<Mvn> getMvn() {
        return mvn;
    }

    public void setMvn(List<Mvn> mvn) {
        this.mvn = mvn;
    }

    public String getTargetRepository() {
        return targetRepository;
    }

    public void setTargetRepository(String targetRepository) {
        this.targetRepository = targetRepository;
    }

    public String getServiceShortName() {
        return serviceShortName;
    }

    public void setServiceShortName(String serviceShortName) {
        this.serviceShortName = serviceShortName;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public Hashes getHashes() {
        return hashes;
    }

    public void setHashes(Hashes hashes) {
        this.hashes = hashes;
    }

    public List<String> getFile() {
        return file;
    }

    public void setFile(List<String> file) {
        this.file = file;
    }
}
