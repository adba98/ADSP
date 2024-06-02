package org.adsp.patterns.creational.Prototype;

public class Person implements Cloneable {
    //Lower-level object
    private final Car car;
    private String name;

    public Car getCar() {
        return car;
    }

    public String getName() {
        return name;
    }

    public void setName(String s) {
        name = s;
    }

    public Person(String s, String t) {
        name = s;
        car = new Car(t);
    }

    public Object clone() {
        return new Person(name, car.getName());
    }
}