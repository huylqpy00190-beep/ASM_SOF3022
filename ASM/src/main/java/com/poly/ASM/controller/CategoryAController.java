package com.poly.ASM.controller;

import com.poly.ASM.Service.CategoryService;
import com.poly.ASM.entity.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/admin/category")
public class CategoryAController {

    @Autowired
    CategoryService categoryService;

    // Hiển thị danh sách có phân trang (8 mục/trang)
    @RequestMapping("/index")
    public String index(Model model, @RequestParam("p") Optional<Integer> p) {
        // p.orElse(0) lấy trang hiện tại, 8 là kích thước mỗi trang
        Pageable pageable = PageRequest.of(p.orElse(0), 8);
        Page<Category> page = categoryService.findAll(pageable);

        model.addAttribute("page", page); // Gửi đối tượng Page sang View
        model.addAttribute("view", "admin/category/index");
        return "layout/layout";
    }

    // Mở trang thêm mới/chỉnh sửa
    @GetMapping("/form")
    public String form(Model model) {
        model.addAttribute("item", new Category());
        model.addAttribute("view", "admin/category/form");
        return "layout/layout";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable String id, Model model) {
        model.addAttribute("item", categoryService.findById(id));
        model.addAttribute("view", "admin/category/form");
        return "layout/layout";
    }

    @PostMapping("/save")
    public String save(Category category) {
        // Nếu ID đã tồn tại thì update, chưa thì create
        categoryService.update(category);
        return "redirect:/admin/category/index";
    }

    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable String id) {
        categoryService.delete(id);
        return "redirect:/admin/category/index";
    }
}

