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
    
    // gets competitors from database and loads to table
    public String[] getCompetitor(Object[] objects, int compNO) {
        int i = 0;
        String[] competitor = new String[10];
        String competitorString = "";
       while(i < objects.length) {
            String row = objects[i].toString().trim();
            String[] rows = row.split(";");
            if (Integer.valueOf(rows[6].trim()) == compNO)  {
            	System.out.println("Found Competitor in file");
            	competitor = rows;
            	competitorString = row;
            	System.out.println(row);
            	String temp = "a; b; c; UK; 25; email.email@email.com; 101; 10; Show Jumping; BEGINNER";
            	objects[i] = temp;      
            	System.out.println(objects[i]);
            	

            }
            i++;
        }
   	Frame f = new JFrame();
   	JTextArea t = new JTextArea(200, i);
       f.add(t);
       
       f.setSize(500, 500);
       t.setSize(500, 500);
       f.setLayout(null);
       f.setVisible(true);
       t.setText(competitorString);
       
        return competitor;
    }
    
    public void getCompetitor(ActionListener actionListener) {
        searchButton.addActionListener(actionListener);
    }
}