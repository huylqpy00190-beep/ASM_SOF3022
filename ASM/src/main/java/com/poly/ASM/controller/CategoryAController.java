package com.poly.ASM.controller;

import com.poly.ASM.Service.CategoryService;
import com.poly.ASM.entity.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/category")
public class CategoryAController {

    @Autowired
    CategoryService categoryService;

    @RequestMapping("/index")
    public String index(Model model) {
        model.addAttribute("view", "admin/category");
        return "layout/layout";
    }

    @RequestMapping("/edit/{id}")
    public String edit(@PathVariable String id, Model model) {
        model.addAttribute("item", categoryService.findById(id));
        return "admin/category";
    }

    @RequestMapping("/create")
    public String create(Category category) {
        categoryService.create(category);
        return "redirect:/admin/category/index";
    }

    @RequestMapping("/update")
    public String update(Category category) {
        categoryService.update(category);
        return "redirect:/admin/category/index";
    }

    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable String id) {
        categoryService.delete(id);
        return "redirect:/admin/category/index";
    }
}

