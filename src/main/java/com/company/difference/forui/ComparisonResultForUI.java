package com.company.difference.forui;

import com.company.difference.forui.artifacts.DiffBetweenArtifactsForUI;
import com.company.difference.forui.parameters.common.DiffBetweenParametersCommonForUI;
import com.company.difference.forui.parameters.services.DiffBetweenParametersServicesForUI;
import com.company.difference.forui.rpm.DiffBetweenRpmForUI;
import com.company.difference.forui.scripts.DiffBetweenScriptsForUI;
import com.company.difference.forui.services.DiffBetweenServicesForUI;
import lombok.Data;

import java.util.Map;

@Data
public class ComparisonResultForUI {
    //(поле: значение, цвет)
    private Map<String, String> metadataDescription;
    private Map<String, String> metadataApplication;
    private Map<String, String> rpm;
    private Map<String, String> rpmHashes;

    private DiffBetweenServicesForUI diffBetweenServicesForUI;
    private DiffBetweenArtifactsForUI diffBetweenArtifactsForUI;
    private DiffBetweenScriptsForUI diffBetweenScriptsForUI;
    private DiffBetweenRpmForUI diffBetweenRpmForUI;
    private DiffBetweenParametersCommonForUI diffBetweenParametersCommonForUI;
    private DiffBetweenParametersServicesForUI diffBetweenParametersServicesForUI;
}
