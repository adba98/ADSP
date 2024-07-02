package org.adsp.gui;

import org.adsp.patterns.creational.Builder.BuilderFactory;
import org.adsp.patterns.creational.Builder.UIBuilder;
import org.adsp.patterns.creational.Builder.UIDirector;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class ButtonHandler implements ActionListener {
    FrameUI frame;
    UIBuilder builder;

    public ButtonHandler(FrameUI frame) {
        this.frame = frame;
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals(FrameUI.EXIT)) {
            System.exit(0);
        }
        if (e.getActionCommand().equals(FrameUI.GET_SQL)) {
            frame.setSQL(builder.getSQL());
        }
        if (e.getSource() == frame.getSearchTypeCtrl()) {
            String selection = frame.getSearchType();
            if (!selection.isEmpty()) {
                BuilderFactory factory = new BuilderFactory();
                // create an appropriate builder instance
                builder = factory.getUIBuilder(selection);
                //configure the director with the builder
                UIDirector director = new UIDirector(builder);
                //director invokes different builder
                // methods
                director.build();
                //get the final build object
                JPanel UIObj = builder.getSearchUI();
                frame.displayNewUI(UIObj);
            }
        }

    }
}
