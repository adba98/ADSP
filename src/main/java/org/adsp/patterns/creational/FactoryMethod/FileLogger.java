package org.adsp.patterns.creational.FactoryMethod;

import org.adsp.utils.models.Logger;
import org.adsp.utils.FileUtil;

public class FileLogger implements Logger {
    public void log(String msg) {
        FileUtil fileUtil = new FileUtil();
        fileUtil.writeToFile("src/main/resources/log.txt", msg, true, true);
    }
}
