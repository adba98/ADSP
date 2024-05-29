package org.adsp.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.Objects;

public class LoggerFrame extends JFrame {
    public static final String LOG_MESSAGE = "LOG MESSAGE";
    public static final String EXIT = "Exit";
    private static final String FILE = "File";
    private static final String CONSOLE = "Console";

    private JComboBox<String> cmbOutputTypes;
    private JTextField txtMessage;
    private JLabel lblMessage;
    private JLabel lblOutputType;
    private JLabel lblResultValue;
    private JButton logMessageButton;
    private JButton exitButton;

    public LoggerFrame() {
        super(" Factory Method Pattern - Example ");
        initComponents();
        setupLayout();
    }

    private void initComponents() {
        cmbOutputTypes = new JComboBox<>();
        cmbOutputTypes.addItem(FILE);
        cmbOutputTypes.addItem(CONSOLE);
        lblOutputType = new JLabel("Output Type:");
        txtMessage = new JTextField(60);
        lblMessage = new JLabel("Write the message(60 characters max.):");
        lblResultValue = new JLabel(" Please click on LOG MESSAGE button to register");

        logMessageButton = new JButton(LOG_MESSAGE);
        logMessageButton.setMnemonic(KeyEvent.VK_L);
        exitButton = new JButton(EXIT);
        exitButton.setMnemonic(KeyEvent.VK_X);

        ButtonHandler objButtonHandler = new ButtonHandler(this);
        logMessageButton.addActionListener(objButtonHandler);
        exitButton.addActionListener(objButtonHandler);
    }

    private void setupLayout() {
        JPanel buttonPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.WEST;

        buttonPanel.add(lblOutputType);
        buttonPanel.add(cmbOutputTypes);
        buttonPanel.add(lblMessage);
        buttonPanel.add(txtMessage);
        buttonPanel.add(lblResultValue);
        buttonPanel.add(logMessageButton);
        buttonPanel.add(exitButton);

        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.gridx = 0;
        gbc.gridy = 5;
        buttonPanel.add(lblOutputType, gbc);
        gbc.gridx = 1;
        gbc.gridy = 5;
        buttonPanel.add(cmbOutputTypes, gbc);
        gbc.gridx = 1;
        gbc.gridy = 8;
        buttonPanel.add(lblResultValue, gbc);
        gbc.insets.left = 2;
        gbc.insets.right = 2;
        gbc.insets.top = 40;
        gbc.anchor = GridBagConstraints.EAST;
        gbc.gridx = 0;
        gbc.gridy = 10;
        buttonPanel.add(logMessageButton, gbc);
        gbc.anchor = GridBagConstraints.WEST;
        gbc.gridx = 1;
        gbc.gridy = 10;
        buttonPanel.add(exitButton, gbc);

        getContentPane().add(buttonPanel, BorderLayout.CENTER);
        pack();
    }

    public String getMessage() {
        return txtMessage.getText();
    }

    public String getOutputType() {
        return Objects.requireNonNull(cmbOutputTypes.getSelectedItem()).toString();
    }

    public void setResultDisplay(String msg) {
        lblResultValue.setText(msg);
    }
}
