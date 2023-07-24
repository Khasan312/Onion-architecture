package com.example.onionarchitecture.application.details;

import java.util.UUID;

public class UpdateDetailInput {
    private final UUID uuid;
    private final DetailInfo info;

    public UpdateDetailInput(UUID uuid,DetailInfo info) {
        this.info = info;
        this.uuid = uuid;
    }

    public DetailInfo info() {
        return info;
    }
}
