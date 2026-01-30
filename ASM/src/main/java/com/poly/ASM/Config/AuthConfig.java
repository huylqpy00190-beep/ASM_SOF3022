package com.poly.ASM.Config;

import com.poly.ASM.Interceptor.AuthInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class AuthConfig implements WebMvcConfigurer {

    @Autowired
    AuthInterceptor authInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(authInterceptor)
                .addPathPatterns(
                        "/cart/**",
                        "/order/**",
                        "/admin/**",
                        "/account/**"
                )
                .excludePathPatterns(
                        "/auth/**",
                        "/home/**",
                        "/product/**",
                        "/account/sign-up",
                        "/account/forgot-password",
                        "/css/**",
                        "/js/**",
                        "/images/**"
                );
    }
}


