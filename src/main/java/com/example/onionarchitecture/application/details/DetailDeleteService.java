package com.example.onionarchitecture.application.details;

import com.example.onionarchitecture.domain.details.Details;

import java.util.UUID;

public class DetailDeleteService {
    private final Details details;

    public DetailDeleteService(Details details) {
        this.details = details;
    }

    public void deleteDetail(UUID uuid) {
        this.details.removeDetail(uuid);
    }
}
