package org.adsp.patterns.creational.FactoryMethod;

import org.adsp.utils.models.Logger;

public class ConsoleLogger implements Logger {
    public void log(String msg) {
        System.out.println(msg);
    }
}
