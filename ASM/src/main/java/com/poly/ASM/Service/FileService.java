package com.poly.ASM.Service;

import org.springframework.boot.autoconfigure.ssl.SslProperties;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;


public interface FileService {
    File save(MultipartFile file, String folder);
}

