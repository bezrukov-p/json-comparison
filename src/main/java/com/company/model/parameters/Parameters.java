package com.company.model.parameters;

import lombok.Data;

import java.util.LinkedHashMap;
import java.util.Map;

@Data
public class Parameters {
    private Map<String,String> common;
    private Map<String, Map<String, String>> services;
}
