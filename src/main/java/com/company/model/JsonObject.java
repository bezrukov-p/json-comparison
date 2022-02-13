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
public class JsonObject {
    private Metadata metadata;
    private List<Service> services;
    private List<Artifact> artifacts;
    @JsonSetter("script")
    private List<Script> scripts;
    private List<Rpm> rpm;
    private Parameters parameters;

    /*public Metadata getMetadata() {
        return metadata;
    }

    public void setMetadata(Metadata metadata) {
        this.metadata = metadata;
    }

    public List<Service> getServices() {
        return services;
    }

    public void setServices(List<Service> services) {
        this.services = services;
    }

    public List<Artifact> getArtifacts() {
        return artifacts;
    }

    public void setArtifacts(List<Artifact> artifacts) {
        this.artifacts = artifacts;
    }

    public List<Script> getScripts() {
        return scripts;
    }

    public void setScripts(List<Script> scripts) {
        this.scripts = scripts;
    }

    public List<Rpm> getRpm() {
        return rpm;
    }

    public void setRpm(List<Rpm> rpm) {
        this.rpm = rpm;
    }

    public Parameters getParameters() {
        return parameters;
    }

    public void setParameters(Parameters parameters) {
        this.parameters = parameters;
    }

    public JsonObject() {
    }

    public JsonObject(Metadata metadata, List<Service> services, List<Artifact> artifacts, List<Script> scripts, List<Rpm> rpm, Parameters parameters) {
        this.metadata = metadata;
        this.services = services;
        this.artifacts = artifacts;
        this.scripts = scripts;
        this.rpm = rpm;
        this.parameters = parameters;
    }*/


}
