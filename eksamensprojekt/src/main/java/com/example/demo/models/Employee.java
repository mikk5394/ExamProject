package com.example.demo.models;

public class Employee extends User {

    private int employeeId;
    private String username;
    private String password;

    public Employee(int employeeId, String name, String mail, String phonenumber){
        super(name,mail,phonenumber);
        this.employeeId = employeeId;
    };

    public Employee(int employeeId, String name, String mail, String phonenumber, String username, String password){

        super(name,mail,phonenumber);
        this.employeeId = employeeId;
        this.username = username;
        this.password = password;
    }

}
