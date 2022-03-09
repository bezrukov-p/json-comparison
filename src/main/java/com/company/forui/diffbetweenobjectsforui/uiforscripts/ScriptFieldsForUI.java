package com.company.forui.diffbetweenobjectsforui.uiforscripts;

import com.company.model.script.Script;
import com.company.model.services.Hashes;
import com.company.model.services.Service;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class ScriptFieldsForUI {
    //содержат готовые строки "ключ": "значение" для ui
    private List<String> fields;
    private List<String> hashesFields;

    public ScriptFieldsForUI(Script script) {
        fields = fieldsAndValues(script);
        hashesFields = fieldsAndValuesHashes(script.getHashes());
    }

    private List<String> fieldsAndValues(Script script) {
        List<String> result = new ArrayList<>();

        if (script.getServiceShortName() != null)
            result.add("\"service-short-name\": \"" + script.getServiceShortName() + "\"");
        if (script.getStartPoint() != null)
            result.add("\"start-point\": \"" + script.getStartPoint() + "\"");
        if (script.getEndPoint() != null)
            result.add("\"end-point\": \"" + script.getEndPoint() + "\"");
        result.add("\"script_name\": \"" + script.getScriptName() + "\"");
        result.add("\"url\": \"" + script.getUrl() + "\"");

        return result;
    }

    private List<String> fieldsAndValuesHashes(Hashes hashes) {
        List<String> result = new ArrayList<>();
        result.add("\"sha1\": \"" + hashes.getSha1() + "\"");
        result.add("\"sha256\": \"" + hashes.getSha256() + "\"");
        return result;
    }
}
