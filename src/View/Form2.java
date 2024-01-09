package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

import Model.Category;
import Model.Level;

public class Form2 extends JPanel {

    private JTextField firstnameField;
    private JTextField middlenameField;
    private JTextField lastnameField;
    private JTextField countryField;
    private JTextField ageField;
    private JTextField emailField;
    private JTextField[] scoreArrayField;
    private JTextField categoryField;
    private JTextField levelField;

    private JButton updateButton;
    
    // back button
    private JButton backButton;
    
    private String competitorNumber;
    
    public Form2() {}

    public Form2(String[] competitor) {

        JLabel firstnameLabel = new JLabel("First Name: ");
        JLabel middlenameLabel = new JLabel("Middle Name: ");
        JLabel lastnameLabel = new JLabel("Last Name: ");
        JLabel countryLabel = new JLabel("Country: ");
        JLabel ageLabel = new JLabel("Age: ");
        JLabel emailLabel = new JLabel("Email: ");
        //JLabel competitorNumberLabel = new JLabel("Competitor Number: ");
        JLabel scoreArrayLabel = new JLabel("Score Array (comma-separated): ");
        JLabel categoryLabel = new JLabel("Category: ");
        JLabel levelLabel = new JLabel("Level: ");

        firstnameField = new JTextField(25);
        middlenameField = new JTextField(25);
        lastnameField = new JTextField(25);
        countryField = new JTextField(25);
        ageField = new JTextField(3);
        emailField = new JTextField(25);
        scoreArrayField = new JTextField[5];
        categoryField = new JTextField(25);
        levelField = new JTextField(25);

        updateButton = new JButton("Update");
        updateButton.setPreferredSize(new Dimension(278, 40));
        
        backButton = new JButton("Back");
        backButton.setPreferredSize(new Dimension(278, 40));
        
        int a = 0;
		for (int i = 0; i < 5; i++) {
            //JLabel label = new JLabel("Score " + (i + 1) + ": ");
            scoreArrayField[i] = new JTextField(1); // Accept only 1 character
            //add(label, gridBagConstraints);
            
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.anchor = GridBagConstraints.WEST;
            gbc.insets = new Insets(5, a , 5, 5); // Padding
            a=a+20;
            gbc.gridx = 1;
            gbc.gridy = 6;
            add(scoreArrayField[i], gbc);
        }
        
        String[] scoresArray = convertStringToArray(competitor[7]);
        if (scoresArray.length > 0) {
        	for (int i = 0 ; i < scoresArray.length ; i++) {
        		scoreArrayField[i].setText(scoresArray[i]);
        	}
        }
        	

        firstnameField.setText(competitor[0]);
        middlenameField.setText(competitor[1]);
        lastnameField.setText(competitor[2]);
        countryField.setText(competitor[3]);
        ageField.setText(competitor[4]);
        emailField.setText(competitor[5]);
        competitorNumber = competitor[6];
        //scoreArrayField.setText(scoresArray)
        categoryField.setText(competitor[8]);
        levelField.setText(competitor[9]);

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

//        add(competitorNumberLabel, gridBagConstraints);
//
//        gridBagConstraints.gridx = 1;
//        gridBagConstraints.gridy = 6;
//
//        add(competitorNumberField, gridBagConstraints);
//
//        gridBagConstraints.gridx = 0;
//        gridBagConstraints.gridy = 7;
//        gridBagConstraints.anchor = GridBagConstraints.WEST;

        add(scoreArrayLabel, gridBagConstraints);
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;

        
        for (int i = 0; i < 5; i++) {
            //JLabel label = new JLabel("Score " + (i + 1) + ": ");
            scoreArrayField[i] = new JTextField(1); // Accept only 1 character
            //add(label, gridBagConstraints);
            
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.anchor = GridBagConstraints.WEST;
            gbc.insets = new Insets(5, a, 5, 5); // Padding
            a=a+20;
            gbc.gridx = 1;
            gbc.gridy = 6;
            add(scoreArrayField[i], gbc);
        }



        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.anchor = GridBagConstraints.WEST;

        add(categoryLabel, gridBagConstraints);

        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 7;

        add(categoryField, gridBagConstraints);

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.anchor = GridBagConstraints.WEST;

        add(levelLabel, gridBagConstraints);

        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 8;

        add(levelField, gridBagConstraints);

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.insets = buttonInset;
        gridBagConstraints.gridwidth = 2;

        add(updateButton, gridBagConstraints);
        
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.insets = buttonInset;
        gridBagConstraints.gridwidth = 2;

        add(backButton, gridBagConstraints);
    }
    
    // Method to convert String to String array
    private static String[] convertStringToArray(String arrayString) {
        // Check for null input
        if (arrayString == null) {
            return new String[0]; // or throw an exception, depending on your requirements
        }

        // Remove brackets and split the string into individual elements
        String[] elements = arrayString.substring(1, arrayString.length() - 1).split(",");

        // Convert each element to an integer and store in the int array
        String[] stringArray = new String[elements.length];
        for (int i = 0; i < elements.length; i++) {
            stringArray[i] = elements[i].trim();
        }

        return stringArray;
    }

    
    
    // populate values from competitor string array
    

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
    
    public String getCompetitorNumber() {
        return competitorNumber;
    }

    public int[] getScoreArray() {
        int[] integers = new int[5];

        for (int i = 0; i < 5; i++) {
            String text = scoreArrayField[i].getText();
            try {
                // Parse the input as an integer
                integers[i] = Integer.parseInt(text);
            } catch (NumberFormatException e) {
                // Handle the case where the input is not a valid integer
                return null;
            }

            // Validate that the input is a single-digit integer
            if (integers[i] < 0 || integers[i] > 9) {
                // Handle the case where the input is not a single-digit integer
                return null;
            }
        }

        return integers;
    }

    public Category getCategory() {
        String categoryText = categoryField.getText();
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

    public void updateCompetitor(ActionListener actionListener) {
        updateButton.addActionListener(actionListener);
    }
    
    // event listener for back button
    public void backButton(ActionListener actionListener) {
        backButton.addActionListener(actionListener);
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
            //competitorNumberField.setText("");
            for (JTextField field : scoreArrayField) {
                field.setText(""); // Clear the text fields
            }
            categoryField.setText("");
            levelField.setText("");
        }
    }
}