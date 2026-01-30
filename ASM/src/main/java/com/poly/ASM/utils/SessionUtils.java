package com.poly.ASM.utils;

import jakarta.servlet.http.HttpServletRequest;

public class SessionUtils {

    public static void set(HttpServletRequest req, String name, Object value) {
        req.getSession().setAttribute(name, value);
    }

    public static Object get(HttpServletRequest req, String name) {
        return req.getSession().getAttribute(name);
    }

    public static void remove(HttpServletRequest req, String name) {
        req.getSession().removeAttribute(name);
    }
}

