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

    public boolean ComparisonByMandateFields(Service service) {
        if (this.serviceName.equals(service.getServiceName()) &&
                this.artifactType.equals(service.getArtifactType()) &&
                this.dockerRegistry.equals(service.getDockerRegistry())) {
            return true;
        }
        else
            return false;
    }

    public String fieldsToJsonString() {
        StringBuilder result = new StringBuilder();
        if (serviceShortName != null)
            result.append("\"service-short-name\": \"").append(serviceShortName).append("\"").append("\n");
        result.append("\"service_name\": \"").append(serviceName).append("\"").append("\n");
        result.append("\"artifact_type\": \"").append(artifactType).append("\"").append("\n");
        result.append("\"docker_registry\": \"").append(dockerRegistry).append("\"").append("\n");
        result.append("\"docker_image_name\": \"").append(dockerImageName).append("\"").append("\n");
        result.append("\"docker_tag\": \"").append(dockerTag).append("\"").append("\n");
        if (force != null)
            result.append("\"force\": \"").append(force).append("\n");
        if (githubRepository != null)
            result.append("\"github_repository\": \"").append(githubRepository).append("\"").append("\n");
        if (githubBranch != null)
            result.append("\"github_branch\": \"").append(githubBranch).append("\"").append("\n");
        if (githubHash != null)
            result.append("\"github_hash\": \"").append(githubHash).append("\"").append("\n");

        result.append("\"hashes\": {\n" + "  \"sha1\": \"")
                .append(hashes.getSha1()).append("\"\n").append("  \"sha256\": \"")
                .append(hashes.getSha256()).append("\"");

        return result.toString();
    }
}
