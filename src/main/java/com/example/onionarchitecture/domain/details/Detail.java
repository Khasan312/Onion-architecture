package com.example.onionarchitecture.domain.details;

import com.example.onionarchitecture.application.details.DetailInfo;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "details")
public class Detail {

    @Id
    @GeneratedValue
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
    private LocalDateTime createdAt = LocalDateTime.now();
    private LocalDateTime updatedAt;
    private LocalDateTime deletedAt;


    public Detail() {}

    public Detail(DetailInfo info) {
        this.brand = info.brand();
        this.model = info.model();
        this.description = info.description();
        this.quantity = info.quantity();
        this.inStock = info.isInStock();
        this.outOfStock = info.isOutOfStock();
        this.price = info.price();
        this.year = info.year();
        this.deleted = info.isDeleted();
    }

    public void updateInfo(DetailInfo info) {
        this.brand = info.brand();
        this.model = info.model();
        this.description = info.description();
        this.quantity = info.quantity();
        this.inStock = info.isInStock();
        this.outOfStock = info.isOutOfStock();
        this.price = info.price();
        this.year = info.year();
        this.deleted = info.isDeleted();
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public boolean isInStock() {
        return inStock;
    }

    public void setInStock(boolean inStock) {
        this.inStock = inStock;
    }

    public boolean isOutOfStock() {
        return outOfStock;
    }

    public void setOutOfStock(boolean outOfStock) {
        this.outOfStock = outOfStock;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }
}
