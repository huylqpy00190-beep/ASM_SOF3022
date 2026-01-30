package com.poly.ASM.Interceptor;

import com.poly.ASM.Service.AuthService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class AuthInterceptor implements HandlerInterceptor {

    @Autowired
    AuthService authService;

    @Override
    public boolean preHandle(HttpServletRequest req,
                             HttpServletResponse res,
                             Object handler) throws Exception {

        String uri = req.getRequestURI();
        HttpSession session = req.getSession();

        // CHƯA LOGIN
        if (!authService.isLogin()) {
            session.setAttribute("security-uri", uri);
            res.sendRedirect("/auth/login");
            return false;
        }

        // KHÔNG PHẢI ADMIN NHƯNG VÀO /admin
        if (uri.startsWith("/admin") && !authService.isAdmin()) {
            res.sendRedirect("/home/index");
            return false;
        }

        return true;
    }
}

