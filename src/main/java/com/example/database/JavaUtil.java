package com.example.database;

import java.sql.*;

public class JavaUtil {
    public static Connection getConnection() {
        Connection conn = null;
        try {
            String url = "jdbc:mySQL://localhost:3306/StudentManagement_jdbc";
            String username = "root";
            String password = "";
            conn = DriverManager.getConnection(url, username, password);

        } catch (Exception e) {

            System.out.println("Kết nối thất bại: " + e.getMessage());
        }

        return conn;
    }

    public static void closeConnection(Connection conn){
        try {
            if(conn != null){
                conn.close();
            }
        } catch (Exception e) {
            System.out.println("Ngắt kết nối db không thành công: " +  e.getMessage());
        }
    }

}
