package com.poly.ASM.ServiceImpl;

import com.poly.ASM.Service.FileService;
import jakarta.servlet.ServletContext;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.ssl.SslProperties;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

@Service
public class FileServiceImpl implements FileService {
    @Override
    public File save(MultipartFile file, String folder) {
        // Lưu vào thư mục static để project nhận diện ngay hoặc thư mục ngoài tùy ý
        String uploadPath = "C:/Users/pc/Documents/Java_5/Assignment/src/main/resources/static/images/" + folder;
        File dir = new File(uploadPath);

        if (!dir.exists()) dir.mkdirs();

        try {
            File savedFile = new File(dir, file.getOriginalFilename());
            file.transferTo(savedFile);
            return savedFile;
        } catch (Exception e) {
            throw new RuntimeException("Lỗi lưu file: " + e.getMessage());
        }
    }
}
