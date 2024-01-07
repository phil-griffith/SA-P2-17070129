package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

import Model.Category;
import Model.Level;

public class Form extends JPanel {

    private JTextField firstnameField;
    private JTextField middlenameField;
    private JTextField lastnameField;
    private JTextField countryField;
    private JTextField ageField;
    private JTextField emailField;
    private JTextField competitorNumberField;
    private JList<Integer> scoreArrayField;
    private JTextField categoryField;
    private JTextField levelField;

    private JButton addButton;
    private JButton viewButton;

    public Form() {

        JLabel firstnameLabel = new JLabel("First Name: ");
        JLabel middlenameLabel = new JLabel("Middle Name: ");
        JLabel lastnameLabel = new JLabel("Last Name: ");
        JLabel countryLabel = new JLabel("Country: ");
        JLabel ageLabel = new JLabel("Age: ");
        JLabel emailLabel = new JLabel("Email: ");
        JLabel competitorNumberLabel = new JLabel("Competitor Number: ");
        JLabel scoreArrayLabel = new JLabel("Score Array (comma-separated): ");
        JLabel categoryLabel = new JLabel("Category: ");
        JLabel levelLabel = new JLabel("Level: ");

        firstnameField = new JTextField(25);
        middlenameField = new JTextField(25);
        lastnameField = new JTextField(25);
        countryField = new JTextField(25);
        ageField = new JTextField(3);
        emailField = new JTextField(25);
        competitorNumberField = new JTextField(25);
        scoreArrayField = new JList<>(new Integer[]{1, 2, 3, 4, 5});
        categoryField = new JTextField(25);
        levelField = new JTextField(25);

        addButton = new JButton("Add Competitor");
        addButton.setPreferredSize(new Dimension(278, 40));
        viewButton = new JButton("View All Competitors");
        viewButton.setPreferredSize(new Dimension(278, 40));

        // space between fields
        Insets fieldsInset = new Insets(0, 0, 10, 0);
        // space between buttons
        Insets buttonInset = new Insets(20,0,0,0);

        // uses Grid Bag Layout
        setLayout(new GridBagLayout());
        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.insets = fieldsInset;
        gridBagConstraints.fill = GridBagConstraints.NONE;

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = GridBagConstraints.WEST;

        add(firstnameLabel, gridBagConstraints);

        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;

        add(firstnameField, gridBagConstraints);

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = GridBagConstraints.WEST;

        add(middlenameLabel, gridBagConstraints);

        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;

        add(middlenameField, gridBagConstraints);

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = GridBagConstraints.WEST;

        add(lastnameLabel, gridBagConstraints);

        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;

        add(lastnameField, gridBagConstraints);

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = GridBagConstraints.WEST;

        add(countryLabel, gridBagConstraints);

        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;

        add(countryField, gridBagConstraints);

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = GridBagConstraints.WEST;

        add(ageLabel, gridBagConstraints);

        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;

        add(ageField, gridBagConstraints);

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.anchor = GridBagConstraints.WEST;

        add(emailLabel, gridBagConstraints);

        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 5;

        add(emailField, gridBagConstraints);

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.anchor = GridBagConstraints.WEST;

        add(competitorNumberLabel, gridBagConstraints);

        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 6;

        add(competitorNumberField, gridBagConstraints);

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.anchor = GridBagConstraints.WEST;

        add(scoreArrayLabel, gridBagConstraints);

        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 7;

        add(scoreArrayField, gridBagConstraints);

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.anchor = GridBagConstraints.WEST;

        add(categoryLabel, gridBagConstraints);

        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 8;

        add(categoryField, gridBagConstraints);

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.anchor = GridBagConstraints.WEST;

        add(levelLabel, gridBagConstraints);

        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 9;

        add(levelField, gridBagConstraints);

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.insets = buttonInset;
        gridBagConstraints.gridwidth = 2;

        add(addButton, gridBagConstraints);

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 11;
        gridBagConstraints.insets = buttonInset;
        gridBagConstraints.gridwidth = 2;

        add(viewButton, gridBagConstraints);
    }

    // getters for all attributes
    public String getFirstname() {
        return firstnameField.getText();
    }

    public String getMiddlename() {
        return middlenameField.getText();
    }

    public String getLastname() {
        return lastnameField.getText();
    }

    public String getCountry() {
        return countryField.getText();
    }

    public int getAge() {
    	try {
            return Integer.parseInt(ageField.getText());
        } catch (NumberFormatException e) {
            // Handle the case where the input is not a valid integer
            return 0;  // Default value or handle as needed
        }
    }

    public String getEmail() {
        return emailField.getText();
    }

    public int getCompetitorNumber() {
    	try {
            return Integer.parseInt(competitorNumberField.getText());
        } catch (NumberFormatException e) {
            // Handle the case where the input is not a valid integer
            return 0;  // Default value or handle as needed
        }
    }
    public int[] getScoreArray() {
        return scoreArrayField.getSelectedValuesList().stream().mapToInt(Integer::intValue).toArray();
    }

    public Category getCategory() {
        String categoryText = categoryField.getText();

        // Assuming Category is a class with a constructor that takes a String
        return new Category(categoryText, categoryText);
    }

    public Level getLevel() {
        String levelText = levelField.getText();
        try {
            return Level.valueOf(levelText.toUpperCase());
        } catch (IllegalArgumentException e) {
            // Handle the case where the input string does not match any enum value
            return Level.BEGINNER; // Replace with your default value or handle as needed
        }
    }

    public void submitCompetitors(ActionListener actionListener) {
        addButton.addActionListener(actionListener);
    }

    public void viewCompetitors(ActionListener actionListener) {
        viewButton.addActionListener(actionListener);
    }

    // reset fields
    public void reset(boolean bln) {
        if(bln) {
            firstnameField.setText("");
            middlenameField.setText("");
            lastnameField.setText("");
            countryField.setText("");
            ageField.setText("");
            emailField.setText("");
            competitorNumberField.setText("");
            scoreArrayField.clearSelection();
            categoryField.setText("");
            levelField.setText("");
        }
    }
}