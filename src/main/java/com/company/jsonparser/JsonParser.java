package com.company.jsonparser;

import com.company.model.MyJsonObject;
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

    public MyJsonObject parseJSONToObject(File file) {
        try {
            MyJsonObject result = mapper.readValue(file, MyJsonObject.class);
            return result;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

}
