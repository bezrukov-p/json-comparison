package com.company.difference.forui.artifacts.type2;

import com.company.model.artifacts.Artifact;
import com.company.model.services.Hashes;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Artifact2TypeFieldsForUI {
    private List<String> fields;
    private String file;
    private List<String> hashesFields;

    public Artifact2TypeFieldsForUI(Artifact artifact) {
        fields = fieldsAndValues(artifact);
        hashesFields = fieldsAndValuesHashes(artifact.getHashes());
        file = "\"" + artifact.getFile().get(0) + "\"";
    }

    private List<String> fieldsAndValues(Artifact artifact) {
        List<String> result = new ArrayList<>();

        if (artifact.getServiceShortName() != null)
            result.add("\"service-name\": \"" + artifact.getServiceShortName() + "\"");
        if (artifact.getServiceName() != null)
            result.add("\"service-short-name\": \"" + artifact.getServiceName() + "\"");
        result.add("\"target_repository\": \"" + artifact.getTargetRepository() + "\"");

        return result;
    }

    private List<String> fieldsAndValuesHashes(Hashes hashes) {
        List<String> result = new ArrayList<>();
        result.add("\"sha1\": \"" + hashes.getSha1() + "\"");
        result.add("\"sha256\": \"" + hashes.getSha256() + "\"");
        return result;
    }
}
