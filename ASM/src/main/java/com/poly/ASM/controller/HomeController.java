package com.poly.ASM.controller;

import com.poly.ASM.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @Autowired
    ProductService productService;

    @GetMapping({"/", "/home/index"})
    public String home(Model model) {

        // danh sách sản phẩm nổi bật
        model.addAttribute("items", productService.findAll());

        // view sẽ được nhúng vào layout
        model.addAttribute("view", "home");

        // render layout
        return "layout/layout";
    }
}
