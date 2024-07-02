package org.adsp.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

public class FrameUI extends JFrame {
    public static final String GET_SQL = "Show SQL Statement";
    public static final String EXIT = "Exit";
    public static final String CANDIDATE_SRCH = "Candidate SQL Statement";
    public static final String EMPLOYER_SRCH = "Employer SQL Statement";
    public static final String BLANK = "";

    private JComboBox<String> cmbSearchType;
    private JPanel pSearchCriteria;
    private JTextArea txtSQL;
    private JLabel lblSearchType, lblWhereClause, lblSearchCriteria;
    private JButton btnGetWhereClause, exitButton;

    public FrameUI() {
        super("Builder Pattern - Example");
        initComponents();
        setupLayout();
    }

    private void initComponents() {
        cmbSearchType = new JComboBox<>();
        txtSQL = new JTextArea(" The SQL statement will be displayed here.", 5, 25);
        txtSQL.setFont(new Font("Serif", Font.ITALIC, 12));
        txtSQL.setLineWrap(true);
        txtSQL.setWrapStyleWord(true);

        pSearchCriteria = new JPanel();

        cmbSearchType.addItem(BLANK);
        cmbSearchType.addItem(CANDIDATE_SRCH);
        cmbSearchType.addItem(EMPLOYER_SRCH);

        lblSearchType = new JLabel("Statement type:");
        lblWhereClause = new JLabel("SQL Statement:");
        lblSearchCriteria = new JLabel("Statement's criteria:");

        btnGetWhereClause = new JButton(GET_SQL);
        btnGetWhereClause.setMnemonic(KeyEvent.VK_G);
        exitButton = new JButton(EXIT);
        exitButton.setMnemonic(KeyEvent.VK_X);

        ButtonHandler objButtonHandler = new ButtonHandler(this);
        btnGetWhereClause.addActionListener(objButtonHandler);
        exitButton.addActionListener(objButtonHandler);
        cmbSearchType.addActionListener(objButtonHandler);
    }

    private void setupLayout() {
        JPanel buttonPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        buttonPanel.add(lblSearchType);
        buttonPanel.add(cmbSearchType);
        buttonPanel.add(lblSearchCriteria);
        buttonPanel.add(pSearchCriteria);
        buttonPanel.add(lblWhereClause);
        buttonPanel.add(txtSQL);
        buttonPanel.add(btnGetWhereClause);
        buttonPanel.add(exitButton);

        gbc.insets = new Insets(5, 5, 5, 5);

        gbc.anchor = GridBagConstraints.WEST;
        gbc.gridx = 0;
        gbc.gridy = 0;
        buttonPanel.add(lblSearchType, gbc);
        gbc.gridx = 1;
        gbc.gridy = 0;
        buttonPanel.add(cmbSearchType, gbc);
        gbc.gridx = 0;
        gbc.gridy = 1;
        buttonPanel.add(lblSearchCriteria, gbc);
        gbc.gridx = 1;
        gbc.gridy = 2;
        buttonPanel.add(pSearchCriteria, gbc);
        gbc.gridx = 0;
        gbc.gridy = 3;
        buttonPanel.add(lblWhereClause, gbc);
        gbc.anchor = GridBagConstraints.WEST;
        gbc.gridwidth = 3;
        gbc.gridheight = 5;
        gbc.gridx = 1;
        gbc.gridy = 3;
        buttonPanel.add(txtSQL, gbc);
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.anchor = GridBagConstraints.EAST;
        gbc.insets.left = 2;
        gbc.insets.right = 2;
        gbc.insets.top = 40;
        gbc.gridx = 0;
        gbc.gridy = 8;
        buttonPanel.add(btnGetWhereClause, gbc);
        gbc.anchor = GridBagConstraints.WEST;
        gbc.gridx = 1;
        gbc.gridy = 8;
        buttonPanel.add(exitButton, gbc);

        getContentPane().add(buttonPanel, BorderLayout.CENTER);
        pack();
    }

    public void setSQL(String str) {
        txtSQL.setText(str);
    }

    public String getSearchType() {
        return (String) cmbSearchType.getSelectedItem();
    }

    public JComboBox<String> getSearchTypeCtrl() {
        return cmbSearchType;
    }

    public void displayNewUI(JPanel panel) {
        pSearchCriteria.removeAll();
        pSearchCriteria.add(panel);
        pSearchCriteria.validate();
        validate();
    }
}
