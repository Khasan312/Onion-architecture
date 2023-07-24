package com.example.onionarchitecture.application.details;

public class CreateDetailInput {
    private final DetailInfo info;

    public CreateDetailInput(DetailInfo info) {
        this.info = info;
    }

    public DetailInfo info(){
        return info;
    }
}
