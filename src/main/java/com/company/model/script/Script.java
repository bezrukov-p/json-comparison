package com.company.model.script;

import com.company.model.services.Hashes;
import com.fasterxml.jackson.annotation.JsonSetter;

public class Script {
    @JsonSetter("service-short-name")
    private String serviceShortName;
    @JsonSetter("start-point")
    private String startPoint;
    @JsonSetter("end-point")
    private String endPoint;
    @JsonSetter("script_name")
    private String scriptName;
    private Hashes hashes;
    private String url;

    public Script() {
    }

    public Script(String serviceShortName, String startPoint, String endPoint, String scriptName, Hashes hashes, String url) {
        this.serviceShortName = serviceShortName;
        this.startPoint = startPoint;
        this.endPoint = endPoint;
        this.scriptName = scriptName;
        this.hashes = hashes;
        this.url = url;
    }

    public String getServiceShortName() {
        return serviceShortName;
    }

    public void setServiceShortName(String serviceShortName) {
        this.serviceShortName = serviceShortName;
    }

    public String getStartPoint() {
        return startPoint;
    }

    public void setStartPoint(String startPoint) {
        this.startPoint = startPoint;
    }

    public String getEndPoint() {
        return endPoint;
    }

    public void setEndPoint(String endPoint) {
        this.endPoint = endPoint;
    }

    public String getScriptName() {
        return scriptName;
    }

    public void setScriptName(String scriptName) {
        this.scriptName = scriptName;
    }

    public Hashes getHashes() {
        return hashes;
    }

    public void setHashes(Hashes hashes) {
        this.hashes = hashes;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
