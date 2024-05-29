package org.adsp.gui;

import org.adsp.utils.models.Logger;
import org.adsp.patterns.creational.Singleton.ConsoleLogger;
import org.adsp.patterns.creational.Singleton.FileLogger;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

class ButtonHandler implements ActionListener {
    LoggerFrame loggerFrame;

    public ButtonHandler(LoggerFrame loggerFrame) {
        this.loggerFrame = loggerFrame;
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals(LoggerFrame.EXIT)) {
            System.exit(0);
        }
        if (e.getActionCommand().equals(LoggerFrame.LOG_MESSAGE)) {
            String result;
            String message = loggerFrame.getMessage();
            String outputType = loggerFrame.getOutputType();
            if (Objects.equals(outputType, "File")) {
                long start = System.nanoTime();
                Logger logger = FileLogger.getFileLogger();
                long end = System.nanoTime();
                System.out.println("Getting object of type FileLogger took: " + (end - start) + " milliseconds");
                logger.log(message);
                result = " Message registered successfully to file";
            } else {
                Logger logger = ConsoleLogger.getConsoleLogger();
                logger.log(message);
                result = "Message wrote successfully to console ";
            }
            loggerFrame.setResultDisplay(result);
        }
    }
}
