package com.poly.ASM.controller;

import com.poly.ASM.Service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/cart")
public class CartController {

    @Autowired
    CartService cartService;

    @RequestMapping("/view")
    public String view(Model model) {
        model.addAttribute("cart", cartService);
        model.addAttribute("view", "cart");
        return "layout/layout";
    }

    @RequestMapping("/add/{id}")
    public String add(@PathVariable("id") Integer id) {
        cartService.add(id);
        return "redirect:/cart/view";
    }

    @RequestMapping("/remove/{id}")
    public String remove(@PathVariable("id") Integer id) {
        cartService.remove(id);
        return "redirect:/cart/view";
    }

    @RequestMapping("/clear")
    public String clear() {
        cartService.clear();
        return "redirect:/cart/view";
    }

    @RequestMapping("/update/{id}")
    public String update(@PathVariable("id") Integer id, @RequestParam("qty") Integer qty) {
        cartService.update(id, qty);
        return "redirect:/cart/view";
    }
}

