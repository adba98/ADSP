package org.adsp.patterns.collections.Flyweight;

import java.util.HashMap;

public class FlyweightFactory {
    private final HashMap<String, FlyweightIntr> lstFlyweight;
    private static final FlyweightFactory factory = new FlyweightFactory();

    private FlyweightFactory() {
        lstFlyweight = new HashMap<>();
    }

    public synchronized FlyweightIntr getFlyweight(String faculty) {
        if (lstFlyweight.get(faculty) == null) {
            FlyweightIntr fw = new Flyweight(faculty);
            lstFlyweight.put(faculty, fw);
            return fw;
        } else {
            return lstFlyweight.get(faculty);
        }
    }

    public static FlyweightFactory getInstance() {
        return factory;
    }

    private static class Flyweight implements FlyweightIntr {
        private String nameFac;
        private String locality;
        private String address;
        private String neighbourhood;
        private String coordinates;

        private Flyweight(String faculty) {
            if (faculty.equals("Tech")) {
                setValues("Technological Faculty", "Ciudad Bolívar", "Av. Villavicencio", "Candelaria", "South");
            }
            if (faculty.equals("Env")) {
                setValues("Environmental Faculty", "La Candelaria", "Av Circunvalar", "La Candelaria", "East");
            }
            if (faculty.equals("Eng")) {
                setValues("Engineering Faculty", "Teusaquillo", "Cra. Séptima Cl. 40", "Palermo", "West-North");
            }
            if (faculty.equals("Arts")) {
                setValues("Arts Faculty", "Mártires", "Cra. 13 Cl. 14", "Mártires", "Center");
            }
        }

        private void setValues(String nm, String loc, String addr, String ngb, String coord) {
            nameFac = nm;
            locality = loc;
            address = addr;
            neighbourhood = ngb;
            coordinates = coord;
        }

        @Override
        public String getNameFac() {
            return nameFac;
        }

        @Override
        public String getLocality() {
            return locality;
        }

        @Override
        public String getAddress() {
            return address;
        }

        @Override
        public String getNeighbourhood() {
            return neighbourhood;
        }

        @Override
        public String getCoordinates() {
            return coordinates;
        }
    }
}
