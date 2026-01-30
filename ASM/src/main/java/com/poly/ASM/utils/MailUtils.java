package com.poly.ASM.utils;

public class MailUtils {

    public static String activationContent(String username) {
        return "Xin chào " + username +
                "\nVui lòng kích hoạt tài khoản của bạn.";
    }

    public static String forgotPasswordContent(String password) {
        return "Mật khẩu mới của bạn là: " + password;
    }
}
