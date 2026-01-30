package com.poly.ASM.controller;

import com.poly.ASM.Service.FileService;
import com.poly.ASM.Service.ProductService;
import com.poly.ASM.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.ssl.SslProperties;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

@Controller
@RequestMapping("/admin/product")
public class ProductAController {

    @Autowired
    ProductService productService;

    @Autowired
    FileService fileService;

    // URL: /admin/product
    @RequestMapping("")
    public String index(Model model) {
        model.addAttribute("items", productService.findAll());
        model.addAttribute("view", "admin/product");
        return "layout/layout";
    }

    // URL: /admin/product/create
    @PostMapping("/create")
    public String create(Product product,
                         @RequestParam("file") MultipartFile file) {
        if (!file.isEmpty()) {
            File saved = fileService.save(file, "products");
            product.setImage(saved.getName());
        }
        productService.create(product);
        return "redirect:/admin/product";
    }
}
