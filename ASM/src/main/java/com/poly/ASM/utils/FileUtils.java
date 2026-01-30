package com.poly.ASM.utils;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;

public class FileUtils {

    public static File save(MultipartFile file, String folder) {
        try {
            File dir = new File("uploads/" + folder);
            if (!dir.exists()) dir.mkdirs();

            File saved = new File(dir, file.getOriginalFilename());
            file.transferTo(saved);
            return saved;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

