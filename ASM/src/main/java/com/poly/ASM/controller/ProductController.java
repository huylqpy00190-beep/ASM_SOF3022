package com.poly.ASM.controller;

import com.poly.ASM.Service.CategoryService;
import com.poly.ASM.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ProductController {

    @Autowired
    ProductService productService;

    @Autowired
    CategoryService categoryService;

    @RequestMapping("/home/index")
    public String home(Model model) {
        model.addAttribute("items", productService.findAll());
        model.addAttribute("categories", categoryService.findAll());

        // view nhúng
        model.addAttribute("view", "home");

        // render layout
        return "layout/layout";
    }

    @RequestMapping("/product/list-by-category/{id}")
    public String listByCategory(@PathVariable("id") String id, Model model) {
        // Lấy sản phẩm theo loại
        model.addAttribute("items", productService.findByCategory(id));

        // Cần truyền lại danh sách categories để Sidebar không bị trống
        model.addAttribute("categories", categoryService.findAll());

        // Sử dụng chung file home.html hoặc một file list riêng có sidebar
        model.addAttribute("view", "home");
        return "layout/layout";
    }

    @RequestMapping("/product/detail/{id}")
    public String detail(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("item", productService.findById(id));
        model.addAttribute("view", "product-detail");
        return "layout/layout";
    }
}
