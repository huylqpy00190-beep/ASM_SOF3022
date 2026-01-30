package com.poly.ASM.utils;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class CookieUtils {

    public static Cookie get(HttpServletRequest req, String name) {
        if (req.getCookies() == null) return null;
        for (Cookie c : req.getCookies()) {
            if (c.getName().equals(name)) {
                return c;
            }
        }
        return null;
    }

    public static void add(HttpServletResponse res,
                           String name,
                           String value,
                           int hours) {
        Cookie cookie = new Cookie(name, value);
        cookie.setMaxAge(hours * 3600);
        cookie.setPath("/");
        res.addCookie(cookie);
    }

    public static void remove(HttpServletResponse res, String name) {
        add(res, name, "", 0);
    }
}

