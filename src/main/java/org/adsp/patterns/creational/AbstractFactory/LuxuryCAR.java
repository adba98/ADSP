package org.adsp.patterns.creational.AbstractFactory;

public class LuxuryCAR implements Luxury {
    private final String name;

    public LuxuryCAR(String name) {
        this.name = name;
    }

    public String getLuxuryName() {
        return name;
    }

    public String getLuxuryFeatures() {
        return "Luxury Car Features ";
    }
}
