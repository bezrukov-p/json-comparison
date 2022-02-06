package com.company.model.rpm;

import com.company.model.services.Hashes;
import com.fasterxml.jackson.annotation.JsonSetter;

public class Rpm {
    private String url;

    @JsonSetter("rpm_repository_name")
    private String rpmRepositoryName;

    private Hashes hashes;

    @JsonSetter("service-short-name")
    private String serviceShortName;

    public Rpm() {
    }

    public Rpm(String url, String rpmRepositoryName, Hashes hashes, String serviceShortName) {
        this.url = url;
        this.rpmRepositoryName = rpmRepositoryName;
        this.hashes = hashes;
        this.serviceShortName = serviceShortName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getRpmRepositoryName() {
        return rpmRepositoryName;
    }

    public void setRpmRepositoryName(String rpmRepositoryName) {
        this.rpmRepositoryName = rpmRepositoryName;
    }

    public Hashes getHashes() {
        return hashes;
    }

    public void setHashes(Hashes hashes) {
        this.hashes = hashes;
    }

    public String getServiceShortName() {
        return serviceShortName;
    }

    public void setServiceShortName(String serviceShortName) {
        this.serviceShortName = serviceShortName;
    }


}
