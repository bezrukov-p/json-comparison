package com.company.forui;

import com.company.differentbetweenobjects.DifferenceBetweenObjects;
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

    @Autowired
    private DifferenceBetweenObjects diffBtwObjects;

    public void jsonNotValid(File jsonFile1, File jsonFile2, Model model) {
        boolean isJSON1Valid = jsonParser.isJSONValid(jsonFile1);
        boolean isJSON2Valid = jsonParser.isJSONValid(jsonFile2);

        if (!isJSON1Valid) {
            model.addAttribute("json1", jsonFile1.getName().concat(" не является json файлом"));
        }
        if (!isJSON2Valid) {
            model.addAttribute("json2", jsonFile2.getName().concat(" не является json файлом"));
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
        comparisonResultForUI.setDiffBetweenServices
                (diffBtwObjects.differenceBetweenListsOfServices(jsonObj1.getServices(), jsonObj2.getServices()));
        comparisonResultForUI.setDiffBetweenScripts(
                diffBtwObjects.differenceBetweenListsOfScripts(jsonObj1.getScripts(), jsonObj2.getScripts()));

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

    private void forServices(Model model) {

    }
}
