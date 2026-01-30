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

    @RequestMapping("/revenue")
    public String revenue(Model model) {
        model.addAttribute("items", reportService.revenueByCategory());
        return "admin/revenue";
    }

    @RequestMapping("/vip")
    public String vip(Model model) {
        model.addAttribute("items", reportService.top10VipCustomers());
        return "admin/vip";
    }
}

