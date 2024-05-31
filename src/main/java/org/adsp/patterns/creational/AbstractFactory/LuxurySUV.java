package org.adsp.patterns.creational.AbstractFactory;

public class LuxurySUV implements Luxury {
    private final String name;

    public LuxurySUV(String name) {
        this.name = name;
    }

    public String getLuxuryName() {
        return name;
    }

    public String getLuxuryFeatures() {
        return "Luxury SUV Features ";
    }
}
