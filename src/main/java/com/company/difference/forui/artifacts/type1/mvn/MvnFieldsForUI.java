package com.company.difference.forui.artifacts.type1.mvn;

import com.company.model.artifacts.Mvn;
import com.company.model.services.Hashes;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class MvnFieldsForUI {
    private List<String> fields;
    private List<String> hashesFields;

    public MvnFieldsForUI(Mvn mvn) {
        fields = fieldsAndValues(mvn);
        hashesFields = fieldsAndValuesHashes(mvn.getHashes());
    }

    private List<String> fieldsAndValues(Mvn mvn) {
        List<String> result = new ArrayList<>();

        result.add("\"groupId\": \"" + mvn.getGroupId() + "\"");
        result.add("\"artifactId\": \"" + mvn.getArtifactId() + "\"");
        result.add("\"version\": \"" + mvn.getVersion() + "\"");
        if (mvn.getServiceName() != null)
            result.add("\"service_name\": \"" + mvn.getServiceName() + "\"");
        if (mvn.getClassifier() != null)
            result.add("\"classifier\": \"" + mvn.getClassifier() + "\"");
        result.add("\"mvn_type\": \"" + mvn.getMvnType() + "\"");
        result.add("\"mvn_repository\": \"" + mvn.getMvnRepository() + "\"");

        return result;
    }

    private List<String> fieldsAndValuesHashes(Hashes hashes) {
        List<String> result = new ArrayList<>();
        result.add("\"sha1\": \"" + hashes.getSha1() + "\"");
        result.add("\"sha256\": \"" + hashes.getSha256() + "\"");
        return result;
    }
}
