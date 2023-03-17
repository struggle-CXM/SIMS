package com.SIMS.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBHelper {
    private static String url="jdbc:mysql://localhost:3306/sims?serverTimezone=UTC&useUnicode=true&characterEncoding=utf-8";
    private static String user="root";
    private static String password="";

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("---驱动加载成功---\n");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(url,user,password);
        } catch (SQLException e) {
            // TODO 自动生成的 catch 块
            e.printStackTrace();
        }
        return null;
    }
}
