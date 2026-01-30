package com.poly.ASM.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {

    private static final SimpleDateFormat sdf =
            new SimpleDateFormat("dd/MM/yyyy");

    public static String format(Date date) {
        return date == null ? "" : sdf.format(date);
    }

    public static Date now() {
        return new Date();
    }
}
