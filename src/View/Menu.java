package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

import Model.Category;
import Model.Level;

public class Menu extends JPanel {


    private JButton addButton;
    private JButton viewButton;
    private JButton updateButton;

    public Menu() {


        addButton = new JButton("Add Competitor");
        addButton.setPreferredSize(new Dimension(278, 40));
        viewButton = new JButton("View All Competitors");
        viewButton.setPreferredSize(new Dimension(278, 40));
        updateButton = new JButton("Update Competitor");
        updateButton.setPreferredSize(new Dimension(278, 40));

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
        gridBagConstraints.gridy = 10;
        gridBagConstraints.insets = buttonInset;
        gridBagConstraints.gridwidth = 2;

        add(addButton, gridBagConstraints);

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 11;
        gridBagConstraints.insets = buttonInset;
        gridBagConstraints.gridwidth = 2;

        add(viewButton, gridBagConstraints);
        
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 12;
        gridBagConstraints.insets = buttonInset;
        gridBagConstraints.gridwidth = 2;

        add(updateButton, gridBagConstraints);
    }



    public void addCompetitor(ActionListener actionListener) {
        addButton.addActionListener(actionListener);
    }

    public void viewCompetitors(ActionListener actionListener) {
        viewButton.addActionListener(actionListener);
    }
    
    // NEW IN PROGRESS... 
    public void updateCompetitor(ActionListener actionListener) {
        updateButton.addActionListener(actionListener);
    }


}
