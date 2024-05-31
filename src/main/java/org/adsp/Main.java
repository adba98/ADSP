package org.adsp;

import org.adsp.gui.FrameUI;

import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            JFrame frame = new FrameUI();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(1050, 550);
            frame.setVisible(true);
        });
    }
}
