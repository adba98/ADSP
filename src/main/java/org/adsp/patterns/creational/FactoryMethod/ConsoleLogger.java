package org.adsp.patterns.creational.FactoryMethod;

public class ConsoleLogger implements Logger {
    public void log(String msg) {
        System.out.println(msg);
    }
}
