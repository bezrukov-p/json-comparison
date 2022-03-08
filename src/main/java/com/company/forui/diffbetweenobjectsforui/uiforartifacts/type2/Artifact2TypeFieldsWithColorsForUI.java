package com.company.forui.diffbetweenobjectsforui.uiforartifacts.type2;

import com.company.model.artifacts.Artifact;
import com.company.model.script.Script;
import lombok.Data;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Data
public class Artifact2TypeFieldsWithColorsForUI {
    private Map<String, String> fields;
    private Map<String, String> file;
    private Map<String, String> hashesFields;

    {
        fields = new LinkedHashMap<>();
        file = new LinkedHashMap<>();
        hashesFields = new LinkedHashMap<>();
    }

    public Artifact2TypeFieldsWithColorsForUI(Artifact artifact1, Artifact artifact2, Boolean isForLeft) {
        Artifact artifact = (isForLeft) ? artifact1 : artifact2;

        String shortNameColor = getResultOfComparingFieldForUI(
                artifact1.getServiceShortName(), artifact2.getServiceShortName(), isForLeft);
        if (shortNameColor != null)
            fields.put("\"service-short-name\": \"" + artifact.getServiceShortName() + "\"", shortNameColor);

        String nameColor = getResultOfComparingFieldForUI(artifact1.getServiceName(), artifact2.getServiceName(), isForLeft);
        if (nameColor != null)
            fields.put("\"service_name\": \"" + artifact.getServiceName() + "\"", nameColor);

        String targetRepositoryColor = getResultOfComparingFieldForUI(
                artifact1.getTargetRepository(), artifact2.getTargetRepository(), isForLeft);
        fields.put("\"target_repository\": \"" + artifact.getTargetRepository() + "\"", targetRepositoryColor);

        String sha1Color = getResultOfComparingFieldForUI(artifact1.getHashes().getSha1(), artifact2.getHashes().getSha1(), isForLeft);
        hashesFields.put("\"sha1\": \"" + artifact.getHashes().getSha1() + "\"", sha1Color);

        String sha256Color = getResultOfComparingFieldForUI(artifact1.getHashes().getSha256(),
                artifact2.getHashes().getSha256(), isForLeft);
        hashesFields.put("\"sha256\": \"" + artifact.getHashes().getSha256() + "\"", sha256Color);

        String fileColor = getResultOfComparingFieldForUI(artifact1.getFile(), artifact2.getFile(), isForLeft);
        file.put("\"" + artifact.getFile().get(0) + "\"", fileColor);
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
