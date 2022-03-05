package com.company.forui;

import com.company.differentbetweenobjects.diffbetweenarrays.DiffBetweenArtifacts;
import com.company.differentbetweenobjects.diffbetweenarrays.DiffBetweenScripts;
import com.company.differentbetweenobjects.diffbetweenarrays.DiffBetweenServices;
import lombok.Data;

import java.util.Map;

@Data
public class ComparisonResultForUI {
    //(поле: значение, цвет)
    private Map<String, String> metadataDescription;
    private Map<String, String> metadataApplication;
    private Map<String, String> rpm;
    private Map<String, String> rpmHashes;
    private Map<String, String> parametersCommon;

    private DiffBetweenServices diffBetweenServices;
    /*private DiffBetweenArtifacts diffBetweenArtifacts;*/
    private DiffBetweenScripts diffBetweenScripts;


}
