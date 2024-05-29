package org.adsp.patterns.creational.Singleton;

import org.adsp.utils.models.Logger;
import org.adsp.utils.FileUtil;

public class FileLogger implements Logger {
    private static FileLogger logger;

    public static synchronized FileLogger getFileLogger() {
        if (logger == null) {
            logger = new FileLogger();
        }
        return logger;
    }

    public synchronized void log(String msg) {
        FileUtil fileUtil = new FileUtil();
        fileUtil.writeToFile("src/main/resources/log.txt", msg, true, true);
    }
}
