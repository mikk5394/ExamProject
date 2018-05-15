package com.example.demo.models;

public class Item {

    private int id;
    private double price;
    private String description;
    private String dimensions;
    private String name;
    private String type;
    private int quantity;


    public Item(){}

    public Item(int id, String name, String description, int price, String dimensions, String type, int quantity){
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
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

    public String getDimentions() {
        return dimensions;
    }

    public void setDimentions(String dimensions) {
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
