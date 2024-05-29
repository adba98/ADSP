package org.adsp.patterns.creational.FactoryMethod;

import org.adsp.utils.models.Logger;

import java.util.Objects;

public class LoggerFactory {
    public Logger getLogger(String selection) {
        if (Objects.equals(selection, "File")) {
            return new FileLogger();
        } else {
            return new ConsoleLogger();
        }
    }
}
