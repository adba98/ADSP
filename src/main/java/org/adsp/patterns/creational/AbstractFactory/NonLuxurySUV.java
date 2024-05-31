package org.adsp.patterns.creational.AbstractFactory;

public class NonLuxurySUV implements NonLuxury {
    private final String name;

    public NonLuxurySUV(String name) {
        this.name = name;
    }

    public String getNLName() {
        return name;
    }

    public String getNLFeatures() {
        return "Non-Luxury SUV Features ";
    }
}
