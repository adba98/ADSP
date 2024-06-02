package org.adsp;

import org.adsp.patterns.creational.Prototype.Person;

public class Main {
    public static void main(String[] args) {
        // Original Object
        Person p = new Person("Person-A", "Civic");
        System.out.println("Original (original values): " + p.getName() + " - " + p.getCar().getName());

        // Clone as a shallow copy
        Person q = (Person) p.clone();
        System.out.println("Clone (before change): " + q.getName() + " - " + q.getCar().getName());

        // Change the primitive member
        q.setName("Person-B");

        // Change the lower-level object
        q.getCar().setName("Accord");
        System.out.println("Clone (after change): " + q.getName() + " - " + q.getCar().getName());
        System.out.println("Original (after clone is modified): " + p.getName() + " - " + p.getCar().getName());
    }
}
