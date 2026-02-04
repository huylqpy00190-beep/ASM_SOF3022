package com.poly.ASM.Config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // Ánh xạ đường dẫn ảo /images/** vào thư mục vật lý trên máy tính của bạn
        registry.addResourceHandler("/images/**")
                .addResourceLocations("file:///C:/Users/pc/Documents/Java_5/Assignment/src/main/resources/static/images/")
                .addResourceLocations("file:///C:/WEB-DATA/images/"); // Thêm thư mục bất kỳ bạn muốn
    }
}