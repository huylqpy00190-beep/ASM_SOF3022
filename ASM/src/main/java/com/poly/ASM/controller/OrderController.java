package com.poly.ASM.controller;

import com.poly.ASM.Service.AuthService;
import com.poly.ASM.Service.CartService;
import com.poly.ASM.Service.OrderDetailService;
import com.poly.ASM.Service.OrderService;
import com.poly.ASM.entity.Order;
import com.poly.ASM.entity.OrderDetail;
import com.poly.ASM.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/order")
public class OrderController {

    @Autowired
    OrderService orderService;

    @Autowired
    OrderDetailService orderDetailService;

    @Autowired
    CartService cartService;

    @Autowired
    AuthService authService;

    @GetMapping("/checkout")
    public String checkout(Model model) {
        model.addAttribute("view", "order/checkout");
        return "layout/layout";
    }
    @PostMapping("/checkout")
    public String purchase(@RequestParam("address") String address) {

        // 1. Tạo Order
        Order order = new Order();
        order.setAccount(authService.getUser());
        order.setAddress(address);
        orderService.create(order);

        // 2. Tạo OrderDetail
        cartService.getItems().forEach(item -> {
            OrderDetail detail = new OrderDetail();
            detail.setOrder(order);

            // LẤY TRỰC TIẾP TỪ ĐỐI TƯỢNG PRODUCT TRONG ITEM
            detail.setProduct(item.getProduct());
            detail.setPrice(item.getProduct().getPrice());
            detail.setQuantity(item.getQuantity()); // Dùng getQuantity() khớp với CartItem mới

            orderDetailService.create(detail);
        });

        // 3. Clear cart
        cartService.clear();

        return "redirect:/order/list";
    }

    @GetMapping("/list")
    public String list(Model model) {
        model.addAttribute("orders",
                orderService.findByUsername(
                        authService.getUser().getUsername()));
        model.addAttribute("view", "order/order-list");
        return "layout/layout";
    }

    @GetMapping("/detail/{id}")
    public String detail(@PathVariable Long id, Model model) {
        model.addAttribute("order", orderService.findById(id));
        model.addAttribute("details",
                orderDetailService.findByOrderId(id));
        model.addAttribute("view", "order/order-detail");
        return "layout/layout";
    }

    @GetMapping("/my-product-list")
    public String myProducts(Model model) {
        model.addAttribute("items",
                orderDetailService.findProductsByUsername(
                        authService.getUser().getUsername()));
        model.addAttribute("view",   "order/my-product-list");
        return "layout/layout";
    }
}


