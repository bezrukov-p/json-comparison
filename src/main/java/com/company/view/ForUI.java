package com.company.view;

import com.company.difference.btwobjects.*;
import com.company.difference.forui.ComparisonResultForUI;
import com.company.difference.forui.artifacts.DiffBetweenArtifactsForUI;
import com.company.difference.forui.parameters.common.DiffBetweenParametersCommonForUI;
import com.company.difference.forui.parameters.services.DiffBetweenParametersServicesForUI;
import com.company.difference.forui.rpm.DiffBetweenRpmForUI;
import com.company.difference.forui.scripts.DiffBetweenScriptsForUI;
import com.company.difference.forui.services.DiffBetweenServicesForUI;
import com.company.jsonparser.JsonParser;
import com.company.model.JsonMappedObject;
import com.networknt.schema.ValidationMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;

import java.io.File;
import java.util.Set;

@Component
public class ForUI {
    @Autowired
    private JsonParser jsonParser;

    public void jsonNotValid(File jsonFile1, File jsonFile2, Model model) {
        boolean isJSON1Valid = jsonParser.isJSONValid(jsonFile1);
        boolean isJSON2Valid = jsonParser.isJSONValid(jsonFile2);

        if (!isJSON1Valid) {
            model.addAttribute("file1NotJson", jsonFile1.getName().concat(" не является json файлом"));
        }
        if (!isJSON2Valid) {
            model.addAttribute("file2NotJson", jsonFile2.getName().concat(" не является json файлом"));
        }
    }

    public void jsonNotValidFields(Set<ValidationMessage> validationResult1,
                                   Set<ValidationMessage> validationResult2,
                                   Model model) {

        model.addAttribute("m1", validationResult1);
        model.addAttribute("m2", validationResult2);
    }

    public void resultOfComparingForUI(File jsonFile1, File jsonFile2, Model model) {
        JsonMappedObject jsonObj1 = jsonParser.parseJSONToObject(jsonFile1);
        JsonMappedObject jsonObj2 = jsonParser.parseJSONToObject(jsonFile2);
        ComparisonResultForUI comparisonResultForUI = new ComparisonResultForUI();
        model.addAttribute("obj1", jsonObj1);
        model.addAttribute("obj2", jsonObj2);
        model.addAttribute("res", comparisonResultForUI);

        //для metadata/description/version
        forVersion(jsonObj1, jsonObj2, model);
        //для metadata/application/name
        forName(jsonObj1, jsonObj2, model);

        //для services
        DiffBetweenServices diffBetweenServices = new DiffBetweenServices(jsonObj1.getServices(), jsonObj2.getServices());
        DiffBetweenServicesForUI diffBetweenServicesForUI = new DiffBetweenServicesForUI(diffBetweenServices);
        comparisonResultForUI.setDiffBetweenServicesForUI(diffBetweenServicesForUI);


        //для artifacts
        DiffBetweenArtifacts diffBetweenArtifacts = new DiffBetweenArtifacts(jsonObj1.getArtifacts(), jsonObj2.getArtifacts());
        DiffBetweenArtifactsForUI diffBetweenArtifactsForUI = new DiffBetweenArtifactsForUI(diffBetweenArtifacts);
        comparisonResultForUI.setDiffBetweenArtifactsForUI(diffBetweenArtifactsForUI);

        //для scripts
        DiffBetweenScripts diffBetweenScripts = new DiffBetweenScripts(jsonObj1.getScripts(), jsonObj2.getScripts());
        DiffBetweenScriptsForUI diffBetweenScriptsForUI = new DiffBetweenScriptsForUI(diffBetweenScripts);
        comparisonResultForUI.setDiffBetweenScriptsForUI(diffBetweenScriptsForUI);

        //для rpm
        model.addAttribute("isRpmOnlyOnLeft", (jsonObj1.getRpm() != null && jsonObj2.getRpm() == null));
        model.addAttribute("isRpmOnlyOnRight", (jsonObj1.getRpm() == null && jsonObj2.getRpm() != null));
        model.addAttribute("isRpmLeftExists", (jsonObj1.getRpm() != null));
        model.addAttribute("isRpmRightExists", (jsonObj2.getRpm() != null));
        comparisonResultForUI.setDiffBetweenRpmForUI(new DiffBetweenRpmForUI(jsonObj1.getRpm(), jsonObj2.getRpm()));

        //для parameters/common
        model.addAttribute("isCommonOnlyOnLeft", (
                jsonObj1.getParameters().getCommon() != null && jsonObj2.getParameters().getCommon() == null));
        model.addAttribute("isCommonOnlyOnRight", (
                jsonObj1.getParameters().getCommon() == null && jsonObj2.getParameters().getCommon() != null));
        model.addAttribute("isCommonLeftExists", (jsonObj1.getParameters().getCommon() != null));
        model.addAttribute("isCommonRightExists", (jsonObj2.getParameters().getCommon() != null));
        comparisonResultForUI.setDiffBetweenParametersCommonForUI(
                new DiffBetweenParametersCommonForUI(
                        new DiffBetweenParametersCommon(
                                jsonObj1.getParameters().getCommon(), jsonObj2.getParameters().getCommon())));

        //для parameters/services
        model.addAttribute("isServicesOnlyOnLeft", (
                jsonObj1.getParameters().getServices() != null && jsonObj2.getParameters().getServices() == null));
        model.addAttribute("isServicesOnlyOnRight", (
                jsonObj1.getParameters().getServices() == null && jsonObj2.getParameters().getServices() != null));
        model.addAttribute("isServicesLeftExists", (jsonObj1.getParameters().getServices() != null));
        model.addAttribute("isServicesRightExists", (jsonObj2.getParameters().getServices() != null));
        DiffBetweenParametersServices diffBetweenParametersServices =
                new DiffBetweenParametersServices(jsonObj1.getParameters().getServices(), jsonObj2.getParameters().getServices());
        DiffBetweenParametersServicesForUI diffBetweenParametersServicesForUI =
                new DiffBetweenParametersServicesForUI(diffBetweenParametersServices);
        comparisonResultForUI.setDiffBetweenParametersServicesForUI(diffBetweenParametersServicesForUI);


    }

    private void forVersion(JsonMappedObject jsonObj1, JsonMappedObject jsonObj2, Model model) {
        Integer version1 = jsonObj1.getMetadata().getDescription().getVersion();
        Integer version2 = jsonObj2.getMetadata().getDescription().getVersion();
        Boolean isVersionEquals = true;
        if (!version1.equals(version2))
            isVersionEquals = false;
        model.addAttribute("version1", version1);
        model.addAttribute("version2", version2);
        model.addAttribute("isVersionEquals", isVersionEquals);
    }

    private void forName(JsonMappedObject jsonObj1, JsonMappedObject jsonObj2, Model model) {
        String name1 = jsonObj1.getMetadata().getApplication().getName();
        String name2 = jsonObj2.getMetadata().getApplication().getName();
        Boolean isNameEquals = true;
        if (!name1.equals(name2))
            isNameEquals = false;
        model.addAttribute("name1", '"' + name1 + '"');
        model.addAttribute("name2", '"' + name2 + '"');
        model.addAttribute("isNameEquals", isNameEquals);
    }
}
