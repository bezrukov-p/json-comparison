package com.company.model.services;

import com.fasterxml.jackson.annotation.JsonSetter;

public class Service {
    @JsonSetter("service-short-name")
    private String serviceShortName;
    @JsonSetter("service_name")
    private String serviceName;
    @JsonSetter("artifact_type")
    private String artifactType;
    @JsonSetter("docker_registry")
    private String dockerRegistry;
    @JsonSetter("docker_image_name")
    private String dockerImageName;
    @JsonSetter("docker_tag")
    private String dockerTag;
    private Boolean force;
    @JsonSetter("github_repository")
    private String githubRepository;
    @JsonSetter("github_branch")
    private String githubBranch;
    @JsonSetter("github_hash")
    private String githubHash;
    private Hashes hashes;

    public Service() {
    }

    public Service(String serviceShortName, String serviceName, String artifactType,
                   String dockerRegistry, String dockerImageName, String dockerTag, Boolean force,
                   String githubRepository, String githubBranch, String githubHash, Hashes hashes) {
        this.serviceShortName = serviceShortName;
        this.serviceName = serviceName;
        this.artifactType = artifactType;
        this.dockerRegistry = dockerRegistry;
        this.dockerImageName = dockerImageName;
        this.dockerTag = dockerTag;
        this.force = force;
        this.githubRepository = githubRepository;
        this.githubBranch = githubBranch;
        this.githubHash = githubHash;
        this.hashes = hashes;
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

    public String getArtifactType() {
        return artifactType;
    }

    public void setArtifactType(String artifactType) {
        this.artifactType = artifactType;
    }

    public String getDockerRegistry() {
        return dockerRegistry;
    }

    public void setDockerRegistry(String dockerRegistry) {
        this.dockerRegistry = dockerRegistry;
    }

    public String getDockerImageName() {
        return dockerImageName;
    }

    public void setDockerImageName(String dockerImageName) {
        this.dockerImageName = dockerImageName;
    }

    public String getDockerTag() {
        return dockerTag;
    }

    public void setDockerTag(String dockerTag) {
        this.dockerTag = dockerTag;
    }

    public Boolean getForce() {
        return force;
    }

    public void setForce(Boolean force) {
        this.force = force;
    }

    public String getGithubRepository() {
        return githubRepository;
    }

    public void setGithubRepository(String githubRepository) {
        this.githubRepository = githubRepository;
    }

    public String getGithubBranch() {
        return githubBranch;
    }

    public void setGithubBranch(String githubBranch) {
        this.githubBranch = githubBranch;
    }

    public String getGithubHash() {
        return githubHash;
    }

    public void setGithubHash(String githubHash) {
        this.githubHash = githubHash;
    }

    public Hashes getHashes() {
        return hashes;
    }

    public void setHashes(Hashes hashes) {
        this.hashes = hashes;
    }
}
