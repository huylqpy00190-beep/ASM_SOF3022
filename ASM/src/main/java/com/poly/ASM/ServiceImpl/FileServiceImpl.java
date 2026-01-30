package com.poly.ASM.ServiceImpl;

import com.poly.ASM.Service.FileService;
import lombok.SneakyThrows;
import org.springframework.boot.autoconfigure.ssl.SslProperties;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

@Service
public class FileServiceImpl implements FileService {

    @SneakyThrows
    @Override
    public File save(MultipartFile file, String folder) {
        File dir = new File("uploads/" + folder);
        if (!dir.exists()) dir.mkdirs();

        File saved = new File(dir, file.getOriginalFilename());
        file.transferTo(saved);
        return saved;
    }
}
