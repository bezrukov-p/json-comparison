package com.company.forui;

import com.company.differentbetweenobjects.DiffBetweenArtifacts;
import com.company.differentbetweenobjects.DiffBetweenParametersServices;
import com.company.differentbetweenobjects.DiffBetweenScripts;
import com.company.forui.diffbetweenobjectsforui.DiffBetweenParametersCommonForUI;
import com.company.forui.diffbetweenobjectsforui.DiffBetweenRpmForUI;
import com.company.forui.diffbetweenobjectsforui.DiffBetweenServicesForUI;
import com.company.model.rpm.Rpm;
import lombok.Data;

import java.util.LinkedHashMap;
import java.util.Map;

@Data
public class ComparisonResultForUI {
    //(поле: значение, цвет)
    private Map<String, String> metadataDescription;
    private Map<String, String> metadataApplication;
    private Map<String, String> rpm;
    private Map<String, String> rpmHashes;

    private DiffBetweenServicesForUI diffBetweenServicesForUI;
    private DiffBetweenArtifacts diffBetweenArtifacts;
    private DiffBetweenScripts diffBetweenScripts;
    private DiffBetweenRpmForUI diffBetweenRpmForUI;
    private DiffBetweenParametersCommonForUI diffBetweenParametersCommonForUI;
    private DiffBetweenParametersServices diffBetweenParametersServices;
}
