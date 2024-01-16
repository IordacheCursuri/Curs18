package com.itFactory.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Configuration
public class ProjectConfig {

    private final String DATABASE_URL = "jdbc:mysql://localhost:3306/curs17";
    private final String USER = "root";

    private final String PASSWORD = "1234";


    @Bean
    public Connection databaseConnection() throws SQLException {
        return DriverManager.getConnection(DATABASE_URL, USER, PASSWORD);
    }

}
