package com.poly.ASM.controller;

import com.poly.ASM.Service.AccountService;
import com.poly.ASM.Service.AuthService;
import com.poly.ASM.entity.Account;
import com.poly.ASM.utils.PasswordUtils;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    AccountService accountService;

    @Autowired
    AuthService authService;

    @GetMapping("/login")
    public String login(Model model) {
        model.addAttribute("view", "login");
        return "layout/layout";
    }

    @PostMapping("/login")
    public String login(@RequestParam String username,
                        @RequestParam String password,
                        HttpSession session) {

        Account user = accountService.findByUsername(username);

        if (user == null || !user.getPassword().equals(password)) {
            return "redirect:/auth/login?error";
        }

        // login cho AuthService
        authService.login(user);

        // 🔥 BẮT BUỘC: gán vào HttpSession
        session.setAttribute("user", user);

        String uri = (String) session.getAttribute("security-uri");
        if (uri != null) {
            session.removeAttribute("security-uri");
            return "redirect:" + uri;
        }

        if (Boolean.TRUE.equals(user.getAdmin())) {
            return "redirect:/admin/product";
        }

        return "redirect:/home/index";
    }

    @RequestMapping("/logout")
    public String logout(HttpSession session) {
        authService.logout();
        session.removeAttribute("user");
        return "redirect:/home/index";
    }
}


