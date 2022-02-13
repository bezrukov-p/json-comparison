package com.company.model.artifacts;

import com.company.model.services.Hashes;
import com.fasterxml.jackson.annotation.JsonSetter;
import lombok.Data;

import java.util.List;

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
}
