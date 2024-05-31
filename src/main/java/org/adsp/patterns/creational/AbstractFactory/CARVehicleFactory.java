package org.adsp.patterns.creational.AbstractFactory;

public class CARVehicleFactory extends VehicleFactory {

    public LuxuryCAR getLuxury() {
        return new LuxuryCAR("Luxury-Car");
    }

    public NonLuxuryCAR getNonLuxury() {
        return new NonLuxuryCAR("NonLuxuryL-Car");
    }
}
