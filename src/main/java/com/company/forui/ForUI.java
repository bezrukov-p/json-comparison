package com.company.forui;

import com.company.differentbetweenobjects.DifferenceBetweenObjects;
import com.company.differentbetweenobjects.diffbetweenarrays.DiffBetweenServices;
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

    public void ComparingJSON(File jsonFile1, File jsonFile2, Model model) {
        JsonMappedObject jsonObj1 = jsonParser.parseJSONToObject(jsonFile1);
        JsonMappedObject jsonObj2 = jsonParser.parseJSONToObject(jsonFile2);

        DiffBetweenServices resultCompServices = diffBtwObjects.DifferenceBetweenListsOfServices(
                jsonObj1.getServices(), jsonObj2.getServices()
        );


    }
}
