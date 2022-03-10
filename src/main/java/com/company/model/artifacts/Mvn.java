package com.company.model.artifacts;

import com.company.model.services.Hashes;
import com.fasterxml.jackson.annotation.JsonSetter;
import lombok.Data;

@Data
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
}
