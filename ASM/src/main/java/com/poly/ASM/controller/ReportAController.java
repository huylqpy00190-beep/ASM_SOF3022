package com.poly.ASM.controller;

import com.poly.ASM.Service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/report")
public class ReportAController {

    @Autowired
    ReportService reportService;
    @RequestMapping("/revenue") // Giờ đây URL sẽ là /admin/revenue
    public String revenue(Model model) {
        model.addAttribute("items", reportService.revenueByCategory());
        model.addAttribute("view", "admin/report/revenue"); // Dùng biến view để đổ vào layout
        return "layout/layout"; // Trả về layout khung
    }
}

