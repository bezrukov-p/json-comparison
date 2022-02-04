package com.company.model;

import com.company.model.artifacts.Artifact;
import com.company.model.metadata.Metadata;
import com.company.model.parameters.Parameters;
import com.company.model.rpm.Rpm;
import com.company.model.script.Script;
import com.company.model.services.Service;

import java.util.List;

public class JsonObject {
    private Metadata metadata;
    private List<Service> services;
    private List<Artifact> artifacts;
    private List<Script> scripts;
    private List<Rpm> rpm;
    private Parameters parameters;
}
