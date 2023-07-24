package com.example.onionarchitecture.application.details;

import com.example.onionarchitecture.domain.details.Detail;

import java.util.UUID;

public class DetailResult {
    private UUID uuid;
    private String brand;
    private String model;
    private String description;
    private int quantity;
    private boolean inStock;
    private boolean outOfStock;
    private int price;
    private int year;
    private boolean deleted;
    private boolean favorite;

    public DetailResult(UUID uuid,
                        String brand,
                        String model,
                        String description,
                        int quantity,
                        boolean inStock,
                        boolean outOfStock,
                        int price,
                        int year,
                        boolean deleted) {
        this.uuid = uuid;
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

    public static DetailResult from(Detail detail) {
        return new DetailResult(
                detail.getUuid(),
                detail.getBrand(),
                detail.getModel(),
                detail.getDescription(),
                detail.getQuantity(),
                detail.isInStock(),
                detail.isOutOfStock(),
                detail.getPrice(),
                detail.getYear(),
                detail.isDeleted()
        );
    }

    public UUID uuid() {
        return uuid;
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

    public boolean makeItFavorite() {
        return favorite = true;
    }
}
