package com.poly.ASM.Service;

import org.springframework.boot.web.server.Cookie;

public interface CookieService {
    Cookie get(String name);
    Cookie add(String name, String value, int hours);
    void remove(String name);
}
