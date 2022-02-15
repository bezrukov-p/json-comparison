package com.company.fileactions;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileActions {

    private final static String UPLOADED_FILES_PATH = "src/main/resources/uploadedfiles/";

    public static File uploadFile(MultipartFile file) throws IOException {
        File fileToSave = new File(UPLOADED_FILES_PATH + file.getOriginalFilename());
        fileToSave.createNewFile();
        FileOutputStream fout = new FileOutputStream(fileToSave);
        fout.write(file.getBytes());
        fout.flush();
        fout.close();
        return fileToSave;
    }

}
