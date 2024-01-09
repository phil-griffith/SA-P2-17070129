package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

import Model.Category;
import Model.Level;

public class UpdateCompetitor extends JPanel {
	private JTextField competitorNumberField;
	private JButton searchButton;
	
    public UpdateCompetitor() {
    	JLabel competitorNumber = new JLabel("Enter Competitor Number: ");

        competitorNumberField = new JTextField(25);
        
        searchButton = new JButton("Search");
        searchButton.setPreferredSize(new Dimension(278, 40));
        
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
        
        add(competitorNumber, gridBagConstraints);
        
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = GridBagConstraints.WEST;
        
        add(competitorNumberField, gridBagConstraints);
        
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = GridBagConstraints.WEST;
        
        add(searchButton, gridBagConstraints);
    }
    
    // getters for all attributes
    public int getCompNo() {
    	try {
            return Integer.parseInt(competitorNumberField.getText());
        } catch (NumberFormatException e) {
            // Handle the case where the input is not a valid integer
            return 0;  // Default value or handle as needed
        }
    }
    
    public void getCompetitor(ActionListener actionListener) {
        searchButton.addActionListener(actionListener);
    }
}