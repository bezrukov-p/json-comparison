package com.company.forui;

import com.company.differentbetweenobjects.DiffBetweenArtifacts;
import com.company.differentbetweenobjects.DiffBetweenParametersServices;
import com.company.forui.diffbetweenobjectsforui.*;
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
