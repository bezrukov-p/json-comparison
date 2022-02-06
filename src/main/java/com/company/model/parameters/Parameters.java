package com.company.model.parameters;

import java.util.Map;

public class Parameters {
    private Map<String,String> common;
    private Map<String, Map<String, String>> services;

    public Parameters() {
    }

    public Parameters(Map<String, String> common, Map<String, Map<String, String>> services) {
        this.common = common;
        this.services = services;
    }

    public Map<String, String> getCommon() {
        return common;
    }

    public void setCommon(Map<String, String> common) {
        this.common = common;
    }

    public Map<String, Map<String, String>> getServices() {
        return services;
    }

    public void setServices(Map<String, Map<String, String>> services) {
        this.services = services;
    }
}
