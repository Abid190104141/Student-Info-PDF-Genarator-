package org.example.firstapplication;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    // Change these according to your MySQL setup
    private static final String URL = "jdbc:mysql://localhost:3306/studentdb";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "Abid141";

    public static Connection getConnection() {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection(URL, USERNAME, PASSWORD);

            System.out.println("Database Connected Successfully!");
            return con;

        } catch (ClassNotFoundException e) {
            System.out.println("MySQL JDBC Driver not found.");
            e.printStackTrace();

        } catch (SQLException e) {
            System.out.println("Database Connection Failed.");
            e.printStackTrace();
        }

        return null;
    }
}