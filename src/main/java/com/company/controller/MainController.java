package com.company.controller;


import com.company.fileactions.FileActions;
import com.company.forui.ForUI;
import com.company.jsonparser.JsonParser;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.networknt.schema.ValidationMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Set;

@Controller
public class MainController {
    @Autowired
    JsonParser jsonParser;
    @Autowired
    ForUI forUI;

    @GetMapping("/main")
    public String MainForm() {
        return "main";
    }


    @PostMapping("/main")
    public String uploadFile(@RequestParam("file1") MultipartFile file1,
                           @RequestParam("file2") MultipartFile file2,
                           Model model) throws IOException {
        File jsonFile1 = FileActions.uploadFile(file1);
        File jsonFile2 = FileActions.uploadFile(file2);
        model.addAttribute("file1", jsonFile1.getName());
        model.addAttribute("file2", jsonFile2.getName());

        boolean isJSON1Valid = jsonParser.isJSONValid(jsonFile1);
        boolean isJSON2Valid = jsonParser.isJSONValid(jsonFile2);

        if (!isJSON1Valid || !isJSON2Valid) {
            forUI.jsonNotValid(jsonFile1, jsonFile2, model);
            return "main";
        }

        Set<ValidationMessage> validationResult1 = jsonParser.getValidationMessages(jsonFile1);
        Set<ValidationMessage> validationResult2 = jsonParser.getValidationMessages(jsonFile2);
        if (!validationResult1.isEmpty() || !validationResult2.isEmpty()) {
            forUI.jsonNotValidFields(validationResult1, validationResult2, model);
            return "json-not-valid";
        }


        forUI.resultOfComparingForUI(jsonFile1, jsonFile2, model);

        return "result";
    }




}
