package com.login.munem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLConnection {
    private static final String url = "jdbc:mysql://localhost:3306/mydatabase";
    private static final String username = "root";
    private static final String password = "";
    private static Connection conn;

    public static Connection conn() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url, username, password);
            System.out.println("Database connected successfully!");
        } catch (ClassNotFoundException e) {
            System.out.println("JDBC Driver not found: " + e.getMessage());
        } catch (SQLException e) {
            System.out.println("Database Connection Error: " + e.getMessage());
            e.printStackTrace();
        }
        return conn;
    }
}
