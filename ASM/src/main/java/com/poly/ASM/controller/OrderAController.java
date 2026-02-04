package com.poly.ASM.controller;

import com.poly.ASM.Service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/order")
public class OrderAController {

    @Autowired
    OrderService orderService; // Đảm bảo bạn đã có OrderServiceImpl

    @GetMapping("/index")
    public String index(Model model) {
        // Lấy danh sách đơn hàng từ Service (Giả sử Service có hàm findAll)
        // Nếu interface OrderService chưa có findAll, bạn hãy bổ sung nó.
        model.addAttribute("items", orderService.findAll());

        // Đổ vào layout
        model.addAttribute("view", "admin/order/index");
        return "layout/layout";
    }
}