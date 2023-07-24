package com.example.onionarchitecture.infrastructure.details.controllers.responses;

import com.example.onionarchitecture.application.details.DetailResult;

import java.util.UUID;

public class DetailResponse {
    public UUID uuid;
    public String brand;
    public String model;
    public String description;
    public int quantity;
    public boolean inStock;
    public boolean outOfStock;
    public int price;
    public int year;
    public boolean deleted;

    public static DetailResponse fromDetailResult(DetailResult result) {
        DetailResponse response = new DetailResponse();
        response.uuid = result.uuid();
        response.brand = result.brand();
        response.model = result.model();
        response.description = result.description();
        response.quantity = result.quantity();
        response.inStock = result.isInStock();
        response.outOfStock = result.isOutOfStock();
        response.price = result.price();
        response.year = result.year();
        response.deleted = result.isDeleted();
        return response;
    }
}
