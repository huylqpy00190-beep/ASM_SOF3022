package com.poly.ASM.controller;

import com.poly.ASM.Service.AccountService;
import com.poly.ASM.Service.MailService;
import com.poly.ASM.entity.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/account")
public class AccountController {

    @Autowired
    AccountService accountService;

    @Autowired
    MailService mailService;

    @GetMapping("/sign-up")
    public String signUp(Model model) {
        model.addAttribute("view", "account/sign-up");
        return "layout/layout";
    }

    @PostMapping("/sign-up")
    public String signUp(Account account) {
        account.setActivated(false);
        accountService.create(account);
        mailService.send(account.getEmail(), "Kích hoạt tài khoản",
                "Vui lòng kích hoạt tài khoản...");
        return "redirect:/auth/login";
    }

    @GetMapping("/edit-profile")
    public String editProfile(Model model) {
        model.addAttribute("view", "account/edit-profile");
        return "layout/layout";
    }

    @GetMapping("/forgot-password")
    public String forgot(Model model) {
        model.addAttribute("view", "account/forgot-password");
        return "layout/layout";
    }

    @GetMapping("/change-password")
    public String changePassword(Model model) {
        model.addAttribute("view", "account/change-password");
        return "layout/layout";
    }
}
