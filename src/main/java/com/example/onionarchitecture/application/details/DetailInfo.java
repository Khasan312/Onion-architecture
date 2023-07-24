package com.example.onionarchitecture.application.details;

import java.util.UUID;

public class DetailInfo {
    private String brand;
    private String model;
    private String description;
    private int quantity;
    private boolean inStock;
    private boolean outOfStock;
    private int price;
    private int year;
    private boolean deleted;

    public DetailInfo(
                      String brand,
                      String model,
                      String description,
                      int quantity,
                      boolean inStock,
                      boolean outOfStock,
                      int price,
                      int year,
                      boolean deleted) {
        this.brand = brand;
        this.model = model;
        this.description = description;
        this.quantity = quantity;
        this.inStock = inStock;
        this.outOfStock = outOfStock;
        this.price = price;
        this.year = year;
        this.deleted = deleted;
    }

    public String brand() {
        return brand;
    }

    public String model() {
        return model;
    }

    public String description() {
        return description;
    }

    public int quantity() {
        return quantity;
    }

    public boolean isInStock() {
        return inStock;
    }

    public boolean isOutOfStock() {
        return outOfStock;
    }

    public int price() {
        return price;
    }

    public int year() {
        return year;
    }

    public boolean isDeleted() {
        return deleted;
    }
}

