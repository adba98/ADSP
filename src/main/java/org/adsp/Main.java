package org.adsp;

import org.adsp.patterns.creational.FactoryMethod.Logger;
import org.adsp.patterns.creational.FactoryMethod.LoggerFactory;

public class Main {
    public static void main(String[] args) {
        LoggerFactory factory = new LoggerFactory();
        Logger logger = factory.getLogger();
        logger.log("Write the message to selected output");
    }
}