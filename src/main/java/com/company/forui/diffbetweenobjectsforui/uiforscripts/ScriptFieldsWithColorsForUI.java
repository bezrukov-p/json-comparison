package com.company.forui.diffbetweenobjectsforui.uiforscripts;

import com.company.model.script.Script;
import com.company.model.services.Service;
import lombok.Data;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Data
public class ScriptFieldsWithColorsForUI {
    //строка - цвет
    Map<String, String> fields;
    Map<String, String> hashesFields;

    {
        fields = new LinkedHashMap<>();
        hashesFields = new LinkedHashMap<>();
    }

    public ScriptFieldsWithColorsForUI(Script script1, Script script2, Boolean isForLeft) {
        Script script = (isForLeft) ? script1 : script2;

        String shortNameColor = getResultOfComparingFieldForUI(script1.getServiceShortName(), script2.getServiceShortName(), isForLeft);
        if (shortNameColor != null)
            fields.put("\"service-short-name\": \"" + script.getServiceShortName() + "\"", shortNameColor);

        String startPointColor = getResultOfComparingFieldForUI(script1.getStartPoint(), script2.getStartPoint(), isForLeft);
        if (startPointColor != null)
            fields.put("\"start-point\": \"" + script.getStartPoint() + "\"", startPointColor);

        String endPointColor = getResultOfComparingFieldForUI(script1.getEndPoint(), script2.getEndPoint(), isForLeft);
        if (endPointColor != null)
            fields.put("\"end-point\": \"" + script.getEndPoint() + "\"", endPointColor);

        String scriptNameColor = getResultOfComparingFieldForUI(script1.getScriptName(), script2.getScriptName(), isForLeft);
        fields.put("\"script_name\": \"" + script.getScriptName() + "\"", scriptNameColor);

        String urlColor = getResultOfComparingFieldForUI(script1.getUrl(), script2.getUrl(), isForLeft);
        fields.put("\"url\": \"" + script.getUrl() + "\"", urlColor);

        String sha1Color = getResultOfComparingFieldForUI(script1.getHashes().getSha1(), script2.getHashes().getSha1(), isForLeft);
        hashesFields.put("\"sha1\": \"" + script.getHashes().getSha1() + "\"", sha1Color);

        String sha256Color = getResultOfComparingFieldForUI(script1.getHashes().getSha256(),
                script2.getHashes().getSha256(), isForLeft);
        hashesFields.put("\"sha256\": \"" + script.getHashes().getSha256() + "\"", sha256Color);
    }

    private String getResultOfComparingFieldForUI(Object o1, Object o2, Boolean isForLeft) {
        if(o1 == null && o2 == null)
            return null;
        if (o1 != null && o2 == null)
            return isForLeft ? "red" : null;
        if (o1 == null && o2 != null)
            return isForLeft ? null : "green";
        if (o1.equals(o2))
            return "white";
        else
            return "dark-orange";
    }
}
