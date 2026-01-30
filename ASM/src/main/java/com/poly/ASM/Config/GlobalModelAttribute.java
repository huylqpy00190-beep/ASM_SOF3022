package com.poly.ASM.Config;

import com.poly.ASM.Service.AuthService;
import com.poly.ASM.Service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

@ControllerAdvice
public class GlobalModelAttribute {

    @Autowired
    AuthService authService;

    @Autowired
    CartService cartService;

    @ModelAttribute("user")
    public Object user() {
        return authService.getUser();
    }

    @ModelAttribute("cart")
    public Object cart() {
        return cartService;
    }
}
