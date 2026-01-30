package com.poly.ASM.utils;

import java.sql.Connection;
import java.sql.DriverManager;

public class JdbcUtils {

    private static final String URL =
            "jdbc:sqlserver://localhost:1433;databaseName=WEBANHANG;encrypt=true;trustServerCertificate=true";
    private static final String USER = "sa";
    private static final String PASS = "123456";

    static {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(URL, USER, PASS);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

