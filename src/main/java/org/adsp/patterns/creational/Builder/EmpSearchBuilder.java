package org.adsp.patterns.creational.Builder;

import javax.swing.*;
import java.awt.*;
import java.util.Calendar;

class EmpSearchBuilder extends UIBuilder {
    private final JTextField txtUserName = new JTextField(15);
    private final JTextField txtCity = new JTextField(15);
    private final JTextField txtRenewal = new JTextField(10);

    public void addUIControls() {
        searchUI = new JPanel();
        JLabel lblUserName = new JLabel("Name :");
        JLabel lblCity = new JLabel("City:");
        JLabel lblRenewal = new JLabel("Membership Renewal :");

        GridBagLayout gridBag = new GridBagLayout();
        searchUI.setLayout(gridBag);
        GridBagConstraints gbc = new GridBagConstraints();

        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.anchor = GridBagConstraints.WEST;

        gbc.gridx = 0;
        gbc.gridy = 0;
        searchUI.add(lblUserName, gbc);
        gbc.gridx = 0;
        gbc.gridy = 1;
        searchUI.add(lblCity, gbc);
        gbc.gridx = 0;
        gbc.gridy = 2;
        searchUI.add(lblRenewal, gbc);
        gbc.gridx = 1;
        gbc.gridy = 0;
        searchUI.add(txtUserName, gbc);
        gbc.gridx = 1;
        gbc.gridy = 1;
        searchUI.add(txtCity, gbc);
        gbc.gridx = 1;
        gbc.gridy = 2;
        searchUI.add(txtRenewal, gbc);
    }

    public void initialize() {
        Calendar cal = Calendar.getInstance();
        cal.setTime(new java.util.Date());
        txtUserName.setText("Enter UserName Here");
        txtRenewal.setText((cal.get(Calendar.MONTH) + 1) + "/" + cal.get(Calendar.DATE) + "/" + cal.get(Calendar.YEAR));
    }

    public String getSQL() {
        return ("SELECT * FROM Employer WHERE Username='" + txtUserName.getText() + "'" + " AND City='" + txtCity.getText() + "' AND DateRenewal='" + txtRenewal.getText() + "'");
    }
}
