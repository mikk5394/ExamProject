package com.example.demo.models;

public class Employee extends User {

    private String username;
    private String password;

    public Employee(String username, String password, String name, String mail, String phonenumber){

        super(name,mail,phonenumber);
        this.username = username;
        this.password = password;
    }
}
