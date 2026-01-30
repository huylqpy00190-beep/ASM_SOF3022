package com.poly.ASM.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordUtils {

    private static final BCryptPasswordEncoder encoder =
            new BCryptPasswordEncoder();

    public static String encrypt(String raw) {
        return encoder.encode(raw);
    }

    public static boolean check(String raw, String encrypted) {
        return encoder.matches(raw, encrypted);
    }
}
