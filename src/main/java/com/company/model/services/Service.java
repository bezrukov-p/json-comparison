package com.company.model.services;

import com.fasterxml.jackson.annotation.JsonSetter;
import lombok.Data;

@Data
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

    public boolean comparisonByMandateFields(Service service) {
        if (this.serviceName.equals(service.getServiceName()) &&
                this.artifactType.equals(service.getArtifactType()) &&
                this.dockerRegistry.equals(service.getDockerRegistry())) {
            return true;
        }
        else
            return false;
    }
}
