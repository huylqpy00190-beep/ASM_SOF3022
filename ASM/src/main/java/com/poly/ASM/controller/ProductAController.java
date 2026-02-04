package com.poly.ASM.controller;

import com.poly.ASM.Service.CategoryService;
import com.poly.ASM.Service.FileService;
import com.poly.ASM.Service.ProductService;
import com.poly.ASM.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.Optional;

@Controller
@RequestMapping("/admin/product")
public class ProductAController {
    @Autowired ProductService productService;
    @Autowired
    CategoryService categoryService; // Thêm để lấy danh sách loại hàng
    @Autowired FileService fileService;

    // 1. Trang danh sách có phân trang
    @RequestMapping("/index")
    public String index(Model model, @RequestParam("p") Optional<Integer> p) {
        Pageable pageable = PageRequest.of(p.orElse(0), 8);
        Page<Product> page = productService.findAll(pageable); // Cần nâng cấp Service
        model.addAttribute("page", page);
        model.addAttribute("view", "admin/product/index");
        return "layout/layout";
    }

    // 2. Trang Form (Thêm/Sửa)
    @GetMapping("/form")
    public String form(Model model) {
        model.addAttribute("product", new Product());
        model.addAttribute("categories", categoryService.findAll());
        model.addAttribute("view", "admin/product/form");
        return "layout/layout";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("product", productService.findById(id));
        model.addAttribute("categories", categoryService.findAll());
        model.addAttribute("view", "admin/product/form");
        return "layout/layout";
    }

    // 3. Xử lý Lưu (Create & Update)
    @PostMapping("/save")
    public String save(Product product, @RequestParam("file") MultipartFile file) {
        if (!file.isEmpty()) {
            File saved = fileService.save(file, "products");
            product.setImage(saved.getName());
        }
        productService.update(product);
        return "redirect:/admin/product/index";
    }
}