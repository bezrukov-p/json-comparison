package com.company.jsonparser;

import com.company.model.JsonMappedObject;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.networknt.schema.JsonSchema;
import com.networknt.schema.JsonSchemaFactory;
import com.networknt.schema.SpecVersion;
import com.networknt.schema.ValidationMessage;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.util.Set;

@Component
public class JsonParser {

    private final ObjectMapper mapper = new ObjectMapper();
    private final String SCHEMA_PATH = "src/main/resources/model/json-schema.json";

    public boolean isJSONValid(File file) {
        try {
            mapper.readTree(file);
            return true;
        } catch (IOException e) {
            /*e.printStackTrace();*/
            return false;
        }
    }

    public Set<ValidationMessage> getValidationMessages(File jsonFile) throws IOException {
        JsonSchemaFactory schemaFactory = JsonSchemaFactory.getInstance(SpecVersion.VersionFlag.V201909);
        File jsonSchemaFile = new File(SCHEMA_PATH);
        JsonNode jsonNode = mapper.readTree(jsonFile);
        JsonNode schemaNode = mapper.readTree(jsonSchemaFile);
        JsonSchema jsonSchema = schemaFactory.getSchema(schemaNode);

        return jsonSchema.validate(jsonNode);
    }

    public JsonMappedObject parseJSONToObject(File file) {
        try {
            JsonMappedObject result = mapper.readValue(file, JsonMappedObject.class);
            return result;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }



}
