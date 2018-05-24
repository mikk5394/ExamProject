package com.example.demo.models;

//Mikkel Olsen, Sebastian Duedahl
public class Item {

    private int id;
    private String name;
    private double price;
    private String description;
    private String dimensions;
    private String type;
    private int quantity;


    public Item(int anInt, String string, double aDouble, String s, String rsString, int rsInt){};

    public Item(){};

    public Item(int id, String name, double price, String description, String dimensions, String type, int quantity){
        this.id = id;
        this.name = name;
        this.price = price;
        this.description = description;
        this.dimensions = dimensions;
        this.type = type;
        this.quantity = quantity;
    }


    // getters og setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDimensions() {
        return dimensions;
    }

    public void setDimensions(String dimensions) {
        this.dimensions = dimensions;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
