package com.company.model;

import com.company.model.artifacts.Artifact;
import com.company.model.metadata.Metadata;
import com.company.model.parameters.Parameters;
import com.company.model.rpm.Rpm;
import com.company.model.script.Script;
import com.company.model.services.Service;
import com.fasterxml.jackson.annotation.JsonSetter;
import lombok.Data;

import java.util.List;


@Data
public class MyJsonObject {
    private Metadata metadata;
    private List<Service> services;
    private List<Artifact> artifacts;
    @JsonSetter("script")
    private List<Script> scripts;
    private Rpm rpm;
    private Parameters parameters;
}
