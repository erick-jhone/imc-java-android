package com.erick.alura.imc.models;

public class Person {

    String name;
    Double corporeHeight, corporeWeight;

    public Person(String name, Double corporeHeight, Double corporeWeight) {
        this.name = name;
        this.corporeHeight = corporeHeight;
        this.corporeWeight = corporeWeight;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getCorporeHeight() {
        return corporeHeight;
    }

    public void setCorporeHeight(Double corporeHeight) {
        this.corporeHeight = corporeHeight;
    }

    public Double getCorporeWeight() {
        return corporeWeight;
    }

    public void setCorporeWeight(Double corporeWeight) {
        this.corporeWeight = corporeWeight;
    }
}
