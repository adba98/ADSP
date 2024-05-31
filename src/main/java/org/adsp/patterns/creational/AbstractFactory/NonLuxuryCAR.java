package org.adsp.patterns.creational.AbstractFactory;

public class NonLuxuryCAR implements NonLuxury {
    private final String name;

    public NonLuxuryCAR(String name) {
        this.name = name;
    }

    public String getNLName() {
        return name;
    }

    public String getNLFeatures() {
        return "Non-Luxury CAR Features ";
    }
}
