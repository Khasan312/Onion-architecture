package com.example.onionarchitecture.application.details;

import java.util.UUID;

public class DetailListInput {
    private final Long userId;

    public DetailListInput(Long userId) {
        this.userId = userId;
    }

    public Long userId(){
        return userId;
    }
}
