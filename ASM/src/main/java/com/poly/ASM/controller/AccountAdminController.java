package com.poly.ASM.controller;

import com.poly.ASM.Service.AccountService;
import com.poly.ASM.entity.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

@Controller
@RequestMapping("/admin/account")
public class AccountAdminController {

    @Autowired
    AccountService accountService;

    // Hiển thị danh sách với phân trang 8 dòng
    @GetMapping("/index")
    public String index(Model model, @RequestParam(value = "p", defaultValue = "0") int p) {
        Pageable pageable = PageRequest.of(p, 8);
        Page<Account> page = accountService.findAll(pageable); // Cần sửa Service trả về Page

        model.addAttribute("page", page);
        model.addAttribute("view", "admin/account/index");
        return "layout/layout";
    }

    // Nút "Thêm mới" -> Chuyển sang trang form trống
    @GetMapping("/add")
    public String add(Model model) {
        model.addAttribute("item", new Account());
        model.addAttribute("view", "admin/account/form");
        return "layout/layout";
    }

    @GetMapping("/edit/{username}")
    public String edit(Model model, @PathVariable("username") String username) {
        Account item = accountService.findByUsername(username);
        model.addAttribute("item", item);
        model.addAttribute("view", "admin/account/form");
        return "layout/layout";
    }

    @PostMapping("/create")
    public String create(Account item) {
        accountService.create(item);
        return "redirect:/admin/account/index";
    }

    @PostMapping("/update")
    public String update(Account item) {
        accountService.update(item);
        return "redirect:/admin/account/index";
    }

    @GetMapping("/delete/{username}")
    public String delete(@PathVariable("username") String username) {
        accountService.delete(username);
        return "redirect:/admin/account/index";
    }
}