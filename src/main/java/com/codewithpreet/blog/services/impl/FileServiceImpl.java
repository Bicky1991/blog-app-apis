package com.codewithpreet.blog.services.impl;

import com.codewithpreet.blog.services.FileService;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.UUID;

public class FileServiceImpl implements FileService {
    @Override
    public String uploadImage(String path, MultipartFile file) throws IOException {
       //File Name
        String name=file.getOriginalFilename();

        //Random name to Generate File
        String randomId= UUID.randomUUID().toString();
        String fileName=randomId.concat(name.substring(name.lastIndexOf(".")));

        //Full Path
        String filePath=path+ File.separator+fileName;

        //Create Folder If Not Created
        File f=new File(path);
        if (!f.exists()){
            f.mkdir();
        }

        //File Copy
        Files.copy(file.getInputStream(), Paths.get(filePath));

        return fileName;
    }

    @Override
    public InputStream getResource(String path, String fileName) throws FileNotFoundException {
        String fullPath = path + File.separator + fileName;
        InputStream is = new FileInputStream(fullPath);
        //Db Logic to return inputStream
        return is;
    }
}