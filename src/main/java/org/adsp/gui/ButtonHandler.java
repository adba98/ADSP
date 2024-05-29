package org.adsp.gui;

import org.adsp.patterns.creational.FactoryMethod.LoggerFactory;
import org.adsp.utils.models.Logger;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class ButtonHandler implements ActionListener {
    LoggerFrame loggerFrame;
    LoggerFactory factory = new LoggerFactory();

    public ButtonHandler(LoggerFrame loggerFrame) {
        this.loggerFrame = loggerFrame;
    }

    public void actionPerformed(ActionEvent e) {
        String Result = null;
        if (e.getActionCommand().equals(LoggerFrame.EXIT)) {
            System.exit(0);
        }
        if (e.getActionCommand().equals(LoggerFrame.LOG_MESSAGE)) {
            String message = loggerFrame.getMessage();
            String outputType = loggerFrame.getOutputType();
            Logger logger = factory.getLogger(outputType);
            logger.log(message);
            Result = "The message was written by " + logger.getClass();
            loggerFrame.setResultDisplay(Result);
        }
    }
}
