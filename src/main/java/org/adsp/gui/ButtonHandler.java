package org.adsp.gui;

import org.adsp.patterns.creational.AbstractFactory.Luxury;
import org.adsp.patterns.creational.AbstractFactory.NonLuxury;
import org.adsp.patterns.creational.AbstractFactory.VehicleFactory;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class ButtonHandler implements ActionListener {
    FrameUI frame;

    public ButtonHandler(FrameUI frame) {
        this.frame = frame;
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals(FrameUI.EXIT)) {
            System.exit(0);
        }
        if (e.getActionCommand().equals(FrameUI.SEARCH)) {
            String result = null;
            String vhCategory = frame.getSelectedCategory();
            String vhType = frame.getSelectedType();

            VehicleFactory vf = VehicleFactory.getVehicleFactory(vhType);
            if (vhCategory.equals(FrameUI.LUXURY)) {
                Luxury c = vf.getLuxury();
                result = "Name: " + c.getLuxuryName() + "  Features: " + c.getLuxuryFeatures();
            }
            if (vhCategory.equals(FrameUI.NON_LUXURY)) {
                NonLuxury s = vf.getNonLuxury();
                result = "Name: " + s.getNLName() + "  Features: " + s.getNLFeatures();
            }
            frame.setResultDisplay(result);
        }
    }
}
