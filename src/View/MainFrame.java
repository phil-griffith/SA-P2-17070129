package View;

import Controller.CompetitorController;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {

    // Card layout for switching view
    private CardLayout cardLayout;

    public MainFrame() {
        super("Event Manager ");
        cardLayout = new CardLayout();
        Form form = new Form();
        Menu menu = new Menu();
        CompetitorDetails competitorDetails = new CompetitorDetails();
        // sets our layout as a card layout
        setLayout(cardLayout);

        // initialize competitor controller
        new CompetitorController(menu, form, competitorDetails);

        // adds view to card layout with unique constraints
        add(menu, "menu");
        add(form, "form");
        add(competitorDetails, "competitor details");
        // switch view according to its constraints on click
        menu.addCompetitor(e -> cardLayout.show(MainFrame.this.getContentPane(), "form"));
        menu.viewCompetitors(e -> cardLayout.show(MainFrame.this.getContentPane(), "competitor details"));
        competitorDetails.backButton(e -> cardLayout.show(MainFrame.this.getContentPane(), "menu"));
        form.backButton(e -> cardLayout.show(MainFrame.this.getContentPane(), "menu"));

        
       
        // frame width & height
        int FRAME_WIDTH = 1200;
        int FRAME_HEIGHT = 700;
        // size of our application frame
        setSize(FRAME_WIDTH, FRAME_HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}