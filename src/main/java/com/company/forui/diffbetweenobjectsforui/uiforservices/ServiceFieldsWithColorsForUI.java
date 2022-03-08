package com.company.forui.diffbetweenobjectsforui.uiforservices;

import com.company.model.services.Service;
import lombok.Data;

import java.util.LinkedHashMap;
import java.util.Map;

@Data
public class ServiceFieldsWithColorsForUI {
    Map<String, String> fields;
    Map<String, String> hashesFields;

    {
        fields = new LinkedHashMap<>();
        hashesFields = new LinkedHashMap<>();
    }

    public ServiceFieldsWithColorsForUI(Service service1, Service service2, Boolean isForLeft) {
        Service service = (isForLeft) ? service1 : service2;

        String shortNameColor =
                getResultOfComparingFieldForUI(service1.getServiceShortName(), service2.getServiceShortName(), isForLeft);
        if (shortNameColor != null)
            fields.put("\"service-short-name\": \"" + service.getServiceShortName() + "\"", shortNameColor);

        String nameColor = getResultOfComparingFieldForUI(service1.getServiceName(), service2.getServiceName(), isForLeft);
        fields.put("\"service_name\": \"" + service.getServiceName() + "\"", nameColor);

        String artifactTypeColor = getResultOfComparingFieldForUI(service1.getArtifactType(), service2.getArtifactType(), isForLeft);
        fields.put("\"artifact_type\": \"" + service.getArtifactType() + "\"", artifactTypeColor);

        String dockerRegistryColor = getResultOfComparingFieldForUI(service1.getDockerRegistry(),
                service2.getDockerRegistry(), isForLeft);
        fields.put("\"docker_registry\": \"" + service.getDockerRegistry() + "\"", dockerRegistryColor);

        String dockerImageNameColor = getResultOfComparingFieldForUI(service1.getDockerImageName(),
                service2.getDockerImageName(), isForLeft);
        fields.put("\"docker_image_name\": \"" + service.getDockerImageName() + "\"", dockerImageNameColor);

        String dockerTagColor = getResultOfComparingFieldForUI(service1.getDockerTag(), service2.getDockerTag(), isForLeft);
        fields.put("\"docker_tag\": \"" + service.getDockerTag() + "\"", dockerTagColor);

        String forceColor = getResultOfComparingFieldForUI(service1.getForce(), service2.getForce(), isForLeft);
        if (forceColor != null)
            fields.put("\"force\": " + service.getForce(), forceColor);

        String githubRepositoryColor = getResultOfComparingFieldForUI(service1.getGithubRepository(),
                service2.getGithubRepository(), isForLeft);
        if (githubRepositoryColor != null)
            fields.put("\"github_repository\": \"" + service.getGithubRepository() + "\"", githubRepositoryColor);

        String githubBranchColor = getResultOfComparingFieldForUI(service1.getGithubBranch(),
                service2.getGithubBranch(), isForLeft);
        if (githubBranchColor != null)
            fields.put("\"github_branch\": \"" + service.getGithubBranch() + "\"", githubBranchColor);

        String githubHashColor = getResultOfComparingFieldForUI(service1.getGithubHash(),
                service2.getGithubHash(), isForLeft);
        if (githubHashColor != null)
            fields.put("\"github_hash\": \"" + service.getGithubHash() + "\"", githubHashColor);

        String sha1Color = getResultOfComparingFieldForUI(service1.getHashes().getSha1(), service2.getHashes().getSha1(), isForLeft);
        hashesFields.put("\"sha1\": \"" + service.getHashes().getSha1() + "\"", sha1Color);

        String sha256Color = getResultOfComparingFieldForUI(service1.getHashes().getSha256(),
                service2.getHashes().getSha256(), isForLeft);
        hashesFields.put("\"sha256\": \"" + service.getHashes().getSha256() + "\"", sha256Color);
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
