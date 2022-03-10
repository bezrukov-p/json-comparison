package com.company.model.script;

import com.company.model.services.Hashes;
import com.fasterxml.jackson.annotation.JsonSetter;
import lombok.Data;

@Data
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

    public boolean comparisonByMandateFields(Script script) {
        if (this.scriptName.equals(script.getScriptName()) &&
                this.url.equals(script.getUrl())) {
            return true;
        }
        else
            return false;
    }

    public String fieldsToJsonString() {
        return this.toString();
    }
}
