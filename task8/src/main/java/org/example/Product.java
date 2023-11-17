package org.example;

public class Product {
    private String name;
    private String country;
    private double price;
    private int quantity;

    public Product(String name, String country, double price, int quantity) {
        this.name = name;
        this.country = country;
        this.price = price;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public String getCountry() {
        return country;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }
}
