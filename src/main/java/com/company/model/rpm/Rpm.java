package com.company.model.rpm;

import com.company.model.services.Hashes;
import com.fasterxml.jackson.annotation.JsonSetter;
import lombok.Data;

@Data
public class Rpm {
    private String url;
    @JsonSetter("rpm_repository_name")
    private String rpmRepositoryName;
    private Hashes hashes;
    @JsonSetter("service-short-name")
    private String serviceShortName;
}
