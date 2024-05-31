package org.adsp.gui;

import org.adsp.patterns.creational.AbstractFactory.VehicleFactory;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

public class FrameUI extends JFrame {
    public static final String SEARCH = "Search";
    public static final String EXIT = "Exit";
    public static final String LUXURY = "Luxury";
    public static final String NON_LUXURY = "Non-Luxury";

    private JComboBox<String> cmbVehicleCategory, cmbVehicleType;
    private JLabel lblVehicleCategory, lblVehicleType, lblCarName, lblCarNameValue;
    private JButton openButton;
    private JButton exitButton;

    public FrameUI() {
        super("Abstract Factory - Example");
        initComponents();
        setupLayout();
    }

    private void initComponents() {
        cmbVehicleCategory = new JComboBox<>();
        cmbVehicleCategory.addItem(LUXURY);
        cmbVehicleCategory.addItem(NON_LUXURY);

        cmbVehicleType = new JComboBox<>();
        cmbVehicleType.addItem(VehicleFactory.CAR);
        cmbVehicleType.addItem(VehicleFactory.SUV);

        lblVehicleCategory = new JLabel("Vehicle Category:");
        lblVehicleType = new JLabel("VehicleType:");
        lblCarName = new JLabel("Search Result:");
        lblCarNameValue = new JLabel(" Please click on Search button");

        openButton = new JButton(SEARCH);
        openButton.setMnemonic(KeyEvent.VK_S);
        exitButton = new JButton(EXIT);
        exitButton.setMnemonic(KeyEvent.VK_X);

        ButtonHandler objButtonHandler = new ButtonHandler(this);
        openButton.addActionListener(objButtonHandler);
        exitButton.addActionListener(objButtonHandler);
    }

    private void setupLayout() {
        JPanel buttonPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.WEST;

        buttonPanel.add(lblVehicleCategory);
        buttonPanel.add(cmbVehicleCategory);
        buttonPanel.add(lblVehicleType);
        buttonPanel.add(cmbVehicleType);
        buttonPanel.add(lblCarName);
        buttonPanel.add(lblCarNameValue);
        buttonPanel.add(openButton);
        buttonPanel.add(exitButton);

        gbc.insets = new Insets(5, 5, 5, 5);

        gbc.anchor = GridBagConstraints.EAST;
        gbc.gridx = 0;
        gbc.gridy = 0;
        buttonPanel.add(lblVehicleCategory, gbc);
        gbc.anchor = GridBagConstraints.WEST;
        gbc.gridx = 1;
        gbc.gridy = 0;
        buttonPanel.add(cmbVehicleCategory, gbc);
        gbc.anchor = GridBagConstraints.EAST;
        gbc.gridx = 0;
        gbc.gridy = 1;
        buttonPanel.add(lblVehicleType, gbc);
        gbc.anchor = GridBagConstraints.WEST;
        gbc.gridx = 1;
        gbc.gridy = 1;
        buttonPanel.add(cmbVehicleType, gbc);
        gbc.anchor = GridBagConstraints.EAST;
        gbc.gridx = 0;
        gbc.gridy = 2;
        buttonPanel.add(lblCarName, gbc);
        gbc.anchor = GridBagConstraints.WEST;
        gbc.gridx = 1;
        gbc.gridy = 2;
        buttonPanel.add(lblCarNameValue, gbc);
        gbc.insets.left = 2;
        gbc.insets.right = 2;
        gbc.insets.top = 40;
        gbc.anchor = GridBagConstraints.EAST;
        gbc.gridx = 0;
        gbc.gridy = 5;
        buttonPanel.add(openButton, gbc);
        gbc.anchor = GridBagConstraints.WEST;
        gbc.gridx = 1;
        gbc.gridy = 5;
        buttonPanel.add(exitButton, gbc);

        getContentPane().add(buttonPanel, BorderLayout.CENTER);
        pack();
    }

    public String getSelectedCategory() {
        return (String) cmbVehicleCategory.getSelectedItem();
    }

    public String getSelectedType() {
        return (String) cmbVehicleType.getSelectedItem();
    }

    public void setResultDisplay(String searchResult) {
        lblCarNameValue.setText(searchResult);
    }
}
