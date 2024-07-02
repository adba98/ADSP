package org.adsp.patterns.creational.Builder;

import javax.swing.*;
import java.awt.*;

class CandidateSearchBuilder extends UIBuilder {
    private final JTextField txtUserName = new JTextField(15);
    private final JTextField txtSkill = new JTextField(10);
    private final JComboBox<String> cmbExperience = new JComboBox<>();

    public void addUIControls() {
        searchUI = new JPanel();
        JLabel lblUserName = new JLabel("Name :");
        JLabel lblExperienceRange = new JLabel("Experience(min Yrs.):");
        JLabel lblSkill = new JLabel("Skill :");
        cmbExperience.addItem("<5");
        cmbExperience.addItem(">5");

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
        searchUI.add(lblExperienceRange, gbc);
        gbc.gridx = 0;
        gbc.gridy = 2;
        searchUI.add(lblSkill, gbc);
        gbc.gridx = 1;
        gbc.gridy = 0;
        searchUI.add(txtUserName, gbc);
        gbc.gridx = 1;
        gbc.gridy = 1;
        searchUI.add(cmbExperience, gbc);
        gbc.gridx = 1;
        gbc.gridy = 2;
        searchUI.add(txtSkill, gbc);
    }

    public void initialize() {
        txtUserName.setText("Enter UserName Here");
        txtSkill.setText("Internet Tech");
    }

    public String getSQL() {
        String experience = (String) cmbExperience.getSelectedItem();
        return ("SELECT * FROM Candidate WHERE Username='" + txtUserName.getText() + "' AND Experience " + experience + " AND Skill='" + txtSkill.getText() + "'");
    }
}
