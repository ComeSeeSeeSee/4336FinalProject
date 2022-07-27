package com.example.utils;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;

public class InitializeJdbcUtils {

    private  Connection connection;

    public InitializeJdbcUtils() {
        try {
            System.out.println("Driver loaded");
//            String connectionString = "jdbc:mysql://localhost:3306/jpastudydb2";
            String connectionString = "jdbc:mysql://localhost:3306/moviedb";
            // Establish a connection
            connection = DriverManager.getConnection(connectionString, "root","123456");
            System.out.println("Database connected");
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }


    public Connection getConnection() {
        return connection;
    }
}
