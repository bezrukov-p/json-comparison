package com.company.controller;


import com.company.fileactions.FileActions;
import com.company.jsonparser.JsonParser;
import com.company.model.MyJsonObject;
import com.networknt.schema.ValidationMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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

    @GetMapping("/main")
    public String MainForm() {
        return "main";
    }


    @PostMapping("/main")
    public void uploadFile(@RequestParam("file1") MultipartFile file1,
                             @RequestParam("file2") MultipartFile file2) throws IOException {
        //из MultipartFile в File
        File jsonFile1 = FileActions.uploadFile(file1);
        File jsonFile2 = FileActions.uploadFile(file2);

        //проверка на правильно структурированный json
        //и валидация файлов, если есть ошибки, то вывод их в консоль
        //если валидация успешна, то мапинг объекта и вывод его в консоль
        boolean isJSON1Valid = jsonParser.isJSONValid(jsonFile1);
        boolean isJSON2Valid = jsonParser.isJSONValid(jsonFile2);
        if (!isJSON1Valid)
            System.out.println(file1.getOriginalFilename() + " не является json");
        else {
            Set<ValidationMessage> validationResult1 = jsonParser.getValidationMessages(jsonFile1);
            if (!validationResult1.isEmpty()) {
                System.out.println(jsonFile1.getName() + " не валидный");
                validationResult1.forEach(vm -> System.out.println(vm.getMessage()));
            }
            else {
                MyJsonObject jsonObj1 = jsonParser.parseJSONToObject(jsonFile1);
                System.out.println(jsonObj1);
            }
        }

        if (!isJSON2Valid)
            System.out.println(file2.getOriginalFilename() + " не является json");
        else {
            Set<ValidationMessage> validationResult2 = jsonParser.getValidationMessages(jsonFile2);
            if (!validationResult2.isEmpty()) {
                System.out.println(jsonFile2.getName() + " не валидный");
                validationResult2.forEach(vm -> System.out.println(vm.getMessage()));
            }
            else {
                MyJsonObject jsonObj2 = jsonParser.parseJSONToObject(jsonFile2);
                System.out.println(jsonObj2);
            }
        }


    }




}
