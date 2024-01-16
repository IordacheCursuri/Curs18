package com.itFactory.dto;

import com.itFactory.model.User;

public class UserRequest {

    private int id;
    private String username;
    private String email;
    private double salary;

    public UserRequest(int id, String username, String email, double salary) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.salary = salary;
    }

    public UserRequest(){};

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
