package com.company.model.artifacts;

import com.company.model.services.Hashes;
import com.fasterxml.jackson.annotation.JsonSetter;

public class Mvn {

    private String groupId;
    private String artifactId;
    private String version;
    @JsonSetter("service_name")
    private String serviceName;
    private String classifier;
    @JsonSetter("mvn_type")
    private String mvnType;
    @JsonSetter("mvn_repository")
    private String mvnRepository;
    private Hashes hashes;

    public Mvn() {
    }

    public Mvn(String groupId, String artifactId, String version, String serviceName,
               String classifier, String mvnType, String mvnRepository, Hashes hashes) {
        this.groupId = groupId;
        this.artifactId = artifactId;
        this.version = version;
        this.serviceName = serviceName;
        this.classifier = classifier;
        this.mvnType = mvnType;
        this.mvnRepository = mvnRepository;
        this.hashes = hashes;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public String getArtifactId() {
        return artifactId;
    }

    public void setArtifactId(String artifactId) {
        this.artifactId = artifactId;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getClassifier() {
        return classifier;
    }

    public void setClassifier(String classifier) {
        this.classifier = classifier;
    }

    public String getMvnType() {
        return mvnType;
    }

    public void setMvnType(String mvnType) {
        this.mvnType = mvnType;
    }

    public String getMvnRepository() {
        return mvnRepository;
    }

    public void setMvnRepository(String mvnRepository) {
        this.mvnRepository = mvnRepository;
    }

    public Hashes getHashes() {
        return hashes;
    }

    public void setHashes(Hashes hashes) {
        this.hashes = hashes;
    }
}
