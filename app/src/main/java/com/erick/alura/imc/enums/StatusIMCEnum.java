package com.erick.alura.imc.enums;

public enum StatusIMCEnum {

    UNDERWEIGHT("Abaixo do peso"),
    NORMAL_WEIGHT("Peso normal"),
    OVERWEIGHT("Acima do peso");

    private final String description;

    StatusIMCEnum(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}