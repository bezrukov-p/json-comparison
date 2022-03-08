package com.company.forui.diffbetweenobjectsforui.uiforservices;

import com.company.model.services.Hashes;
import com.company.model.services.Service;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class ServiceFieldsForUI {
    private List<String> fields;
    private List<String> hashesFields;

    public ServiceFieldsForUI(Service service) {
        fields = fieldsAndValues(service);
        hashesFields = fieldsAndValuesHashes(service.getHashes());
    }

    private List<String> fieldsAndValues(Service service) {
        List<String> result = new ArrayList<>();
        if (service.getServiceShortName() != null)
            result.add("\"service-short-name\": \"" + service.getServiceShortName() + "\"");
        result.add("\"service_name\": \"" + service.getServiceName() + "\"");
        result.add("\"artifact_type\": \"" + service.getArtifactType() + "\"");
        result.add("\"docker_registry\": \"" + service.getDockerRegistry() + "\"");
        result.add("\"docker_registry\": \"" + service.getDockerImageName() + "\"");
        result.add("\"docker_tag\": \"" + service.getDockerTag() + "\"");
        if (service.getForce() != null)
            result.add("\"force\": " + service.getForce());
        if (service.getGithubRepository() != null)
            result.add("\"github_repository\": \"" + service.getGithubRepository() + "\"");
        if (service.getGithubBranch() != null)
            result.add("\"github_branch\": \"" + service.getGithubBranch() + "\"");
        if (service.getGithubHash() != null)
            result.add("\"github_hash\": \"" + service.getGithubHash() + "\"");

        return result;
    }

    private List<String> fieldsAndValuesHashes(Hashes hashes) {
        List<String> result = new ArrayList<>();
        result.add("\"sha1\": \"" + hashes.getSha1() + "\"");
        result.add("\"sha256\": \"" + hashes.getSha256() + "\"");
        return result;
    }
}
