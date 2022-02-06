package com.company.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class MainController {

    @GetMapping("/main")
    public String MainForm() {
        return "main";
    }

    @PostMapping("/main")
    public String uploadFile(@RequestParam("file1") MultipartFile file1,
                             @RequestParam("file2") MultipartFile file2){

        return "result";
    }




}
