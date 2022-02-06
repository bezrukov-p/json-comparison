package com.company.jsonparser;

import com.company.model.JsonObject;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;

@Component
public class JsonParser {

    private final ObjectMapper mapper = new ObjectMapper();

    public boolean isJSONValid(File file) {
        try {
            mapper.readTree(file);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public JsonObject parseJSONToObject(File file) {
        try {
            JsonObject result = mapper.readValue(file, JsonObject.class);
            return result;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

}
