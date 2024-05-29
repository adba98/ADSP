package org.adsp.patterns.creational.Singleton;

import org.adsp.utils.models.Logger;

public class ConsoleLogger implements Logger {
    private static ConsoleLogger logger;

    public static ConsoleLogger getConsoleLogger() {
        if (logger == null) {
            logger = new ConsoleLogger();
        }
        return logger;
    }

    public synchronized void log(String msg) {
        System.out.println(msg);
    }
}
