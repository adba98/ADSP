package org.adsp.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

public class FrameUI extends JFrame {
    public static final String GET_CANDIDATES = "Show Certificates";
    public static final String EXIT = "Exit";
    public static final String SUN = "Sun MicroSystems";
    public static final String APACHE = "Apache Project";
    public static final String APPLE = "Apple";

    private JComboBox<String> cmbCertificationType;
    private JTextArea taSelectedCandidates;
    private JLabel lblCertificationType, lblSelectedCandidates;
    private JButton btnGetSelectedCandidates, exitButton;

    public FrameUI() {
        super("External Iterator Pattern - Example");
        initComponents();
        setupLayout();
    }

    private void initComponents() {
        cmbCertificationType = new JComboBox<>();
        cmbCertificationType.addItem(SUN);
        cmbCertificationType.addItem(APACHE);
        cmbCertificationType.addItem(APPLE);

        taSelectedCandidates = new JTextArea(15, 20);
        taSelectedCandidates.setEditable(false);

        lblCertificationType = new JLabel("Certification Type:");
        lblSelectedCandidates = new JLabel("Results:");

        btnGetSelectedCandidates = new JButton(GET_CANDIDATES);
        btnGetSelectedCandidates.setMnemonic(KeyEvent.VK_R);

        exitButton = new JButton(EXIT);
        exitButton.setMnemonic(KeyEvent.VK_X);

        ButtonHandler objButtonHandler = new ButtonHandler(this);
        btnGetSelectedCandidates.addActionListener(objButtonHandler);
        exitButton.addActionListener(objButtonHandler);
    }

    private void setupLayout() {
        JPanel buttonPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.anchor = GridBagConstraints.WEST;
        gbc.gridx = 0;
        gbc.gridy = 0;
        buttonPanel.add(lblCertificationType, gbc);
        gbc.gridx = 1;
        buttonPanel.add(cmbCertificationType, gbc);
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        buttonPanel.add(lblSelectedCandidates, gbc);
        gbc.gridy = 2;
        buttonPanel.add(taSelectedCandidates, gbc);
        gbc.insets = new Insets(40, 2, 2, 2);
        gbc.gridy = 6;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.gridx = 0;
        buttonPanel.add(btnGetSelectedCandidates, gbc);
        gbc.gridx = 1;
        buttonPanel.add(exitButton, gbc);
        getContentPane().add(buttonPanel, BorderLayout.CENTER);
        pack();
    }
    
    public String getCertificationType() {
        return (String) cmbCertificationType.getSelectedItem();
    }

    public void setSelectedCandidates(String selectedCandidates) {
        taSelectedCandidates.setText(selectedCandidates);
    }
}
