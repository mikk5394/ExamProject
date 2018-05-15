package com.example.demo.models;

public class Customer extends User {

    private String address;
    private int customerId;

    public Customer(String address, int customerId, String name, String mail, String phonenumber){
        super(name, mail, phonenumber);
        this.address = address;
        this.customerId = customerId;
    }
}
