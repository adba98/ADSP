package org.adsp.gui;

import org.adsp.patterns.collections.Visitor.OrderVisitor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

public class FrameUI extends JFrame {
    public static final String GET_TOTAL = "Get Total";
    public static final String CREATE_ORDER = "Create Order";
    public static final String EXIT = "Exit";
    public static final String CA_ORDER = "California Order";
    public static final String NON_CA_ORDER = "Non-California Order";
    public static final String OVERSEAS_ORDER = "Overseas Order";

    private JComboBox<String> cmbOrderType;
    private JTextField txtOrderAmount, txtAdditionalTax, txtAdditionalSH;
    private JLabel lblOrderType, lblOrderAmount;
    private JLabel lblAdditionalTax, lblAdditionalSH;
    private JLabel lblTotal, lblTotalValue;

    JButton getTotalButton, createOrderButton, exitButton;

    private final OrderVisitor objVisitor;

    public FrameUI() {
        super("Visitor Pattern - Example");
        objVisitor = new OrderVisitor();
        initComponents();
        setupLayout();
    }

    private void initComponents() {
        cmbOrderType = new JComboBox<>();
        cmbOrderType.addItem(CA_ORDER);
        cmbOrderType.addItem(NON_CA_ORDER);
        cmbOrderType.addItem(OVERSEAS_ORDER);

        txtOrderAmount = new JTextField(10);
        txtAdditionalTax = new JTextField(10);
        txtAdditionalSH = new JTextField(10);

        lblOrderType = new JLabel("Order Type:");
        lblOrderAmount = new JLabel("Order Amount:");
        lblAdditionalTax = new JLabel("Additional Tax(CA Orders Only):");
        lblAdditionalSH = new JLabel("Additional S & H(Overseas Orders Only):");
        lblTotal = new JLabel("Result:");
        lblTotalValue = new JLabel("Click Create or GetTotal Button");

        getTotalButton = new JButton(GET_TOTAL);
        getTotalButton.setMnemonic(KeyEvent.VK_G);

        createOrderButton = new JButton(CREATE_ORDER);
        getTotalButton.setMnemonic(KeyEvent.VK_C);

        exitButton = new JButton(EXIT);
        exitButton.setMnemonic(KeyEvent.VK_X);

        ButtonHandler objButtonHandler = new ButtonHandler(this);
        getTotalButton.addActionListener(objButtonHandler);
        createOrderButton.addActionListener(objButtonHandler);
        exitButton.addActionListener(objButtonHandler);
    }

    private void setupLayout() {
        JPanel buttonPanel = new JPanel();
        JPanel panel = new JPanel();
        GridBagLayout gridbag2 = new GridBagLayout();
        panel.setLayout(gridbag2);
        GridBagConstraints gbc2 = new GridBagConstraints();
        panel.add(getTotalButton);
        panel.add(createOrderButton);
        panel.add(exitButton);
        gbc2.anchor = GridBagConstraints.EAST;
        gbc2.gridx = 0;
        gbc2.gridy = 0;
        gridbag2.setConstraints(createOrderButton, gbc2);
        gbc2.gridx = 1;
        gbc2.gridy = 0;
        gridbag2.setConstraints(getTotalButton, gbc2);
        gbc2.gridx = 2;
        gbc2.gridy = 0;
        gridbag2.setConstraints(exitButton, gbc2);

        GridBagLayout gridbag = new GridBagLayout();
        buttonPanel.setLayout(gridbag);
        GridBagConstraints gbc = new GridBagConstraints();

        buttonPanel.add(lblOrderType);
        buttonPanel.add(cmbOrderType);
        buttonPanel.add(lblOrderAmount);
        buttonPanel.add(txtOrderAmount);
        buttonPanel.add(lblAdditionalTax);
        buttonPanel.add(txtAdditionalTax);
        buttonPanel.add(lblAdditionalSH);
        buttonPanel.add(txtAdditionalSH);
        buttonPanel.add(lblTotal);
        buttonPanel.add(lblTotalValue);

        gbc.insets = new Insets(5, 5, 5, 5);

        gbc.anchor = GridBagConstraints.EAST;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gridbag.setConstraints(lblOrderType, gbc);
        gbc.anchor = GridBagConstraints.WEST;
        gbc.gridx = 1;
        gbc.gridy = 0;
        gridbag.setConstraints(cmbOrderType, gbc);

        gbc.anchor = GridBagConstraints.EAST;
        gbc.gridx = 0;
        gbc.gridy = 1;
        gridbag.setConstraints(lblOrderAmount, gbc);
        gbc.anchor = GridBagConstraints.WEST;
        gbc.gridx = 1;
        gbc.gridy = 1;
        gridbag.setConstraints(txtOrderAmount, gbc);

        gbc.anchor = GridBagConstraints.EAST;
        gbc.gridx = 0;
        gbc.gridy = 2;
        gridbag.setConstraints(lblAdditionalTax, gbc);
        gbc.anchor = GridBagConstraints.WEST;
        gbc.gridx = 1;
        gbc.gridy = 2;
        gridbag.setConstraints(txtAdditionalTax, gbc);

        gbc.anchor = GridBagConstraints.EAST;
        gbc.gridx = 0;
        gbc.gridy = 3;
        gridbag.setConstraints(lblAdditionalSH, gbc);
        gbc.anchor = GridBagConstraints.WEST;
        gbc.gridx = 1;
        gbc.gridy = 3;
        gridbag.setConstraints(txtAdditionalSH, gbc);

        gbc.anchor = GridBagConstraints.EAST;
        gbc.gridx = 0;
        gbc.gridy = 4;
        gridbag.setConstraints(lblTotal, gbc);
        gbc.anchor = GridBagConstraints.WEST;
        gbc.gridx = 1;
        gbc.gridy = 4;
        gridbag.setConstraints(lblTotalValue, gbc);

        gbc.insets.left = 2;
        gbc.insets.right = 2;
        gbc.insets.top = 40;

        Container contentPane = getContentPane();

        contentPane.add(buttonPanel, BorderLayout.NORTH);
        contentPane.add(panel, BorderLayout.CENTER);
        pack();
    }

    public void setTotalValue(String msg) {
        lblTotalValue.setText(msg);
    }

    public OrderVisitor getOrderVisitor() {
        return objVisitor;
    }

    public String getOrderType() {
        return (String) cmbOrderType.getSelectedItem();
    }

    public String getOrderAmount() {
        return txtOrderAmount.getText();
    }

    public String getTax() {
        return txtAdditionalTax.getText();
    }

    public String getSH() {
        return txtAdditionalSH.getText();
    }
}
