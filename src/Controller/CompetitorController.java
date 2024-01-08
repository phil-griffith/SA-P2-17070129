package Controller;

import Model.CompetitorList;
import Model.Competitor;
import Model.Level;
import View.Form;
import View.Menu;
import View.CompetitorDetails;
import Model.Category;

import javax.swing.*;
import java.io.File;

public class CompetitorController {
    // data file
    private String databaseFile = "competitordata.txt";
    private CompetitorList database;
    private Menu menu;
    private Form form;
    private CompetitorDetails competitorDetails;

    public CompetitorController(Menu menu, Form form, CompetitorDetails competitorDetails) {
        this.database = new CompetitorList();
        this.menu = menu;
        this.form = form;
        this.competitorDetails = competitorDetails;

        // submit competitor
        this.form.submitCompetitors(e -> {
            String firstname = this.form.getFirstname().trim();
            String middlename = this.form.getMiddlename().trim();
            String lastname = this.form.getLastname().trim();
            String country = this.form.getCountry().trim();
            int age = this.form.getAge();
            String email = this.form.getEmail().trim();
            int competitornumber = this.competitorDetails.getNextCN(this.database.loadcompetitors(new File(databaseFile)));
            int[] scorearray = this.form.getScoreArray();
            Category category = this.form.getCategory();
            Level level = this.form.getLevel();

            
            // simple validations
            if(firstname.isEmpty()) {
                JOptionPane.showMessageDialog(this.form, "First Name Required.", "Error",
                        JOptionPane.ERROR_MESSAGE);
                return;
            } else if(middlename.isEmpty()) {
                JOptionPane.showMessageDialog(this.form, "Middle Name Required.", "Error",
                        JOptionPane.ERROR_MESSAGE);
                return;
            } else if(lastname.isEmpty()) {
                JOptionPane.showMessageDialog(this.form, "Last Name Required.", "Error",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            this.database.addCompetitor(new Competitor(firstname, middlename, lastname, country, age, email, competitornumber, scorearray, category, level));
            this.database.saveCompetitor(new File(databaseFile));
            this.form.reset(true);
        });

        // load competitors
        this.menu.viewCompetitors(e -> {
            this.competitorDetails.getCompetitors(this.database.loadcompetitors(new File(databaseFile)));
        });
        
        // update competitor
        this.menu.updateCompetitor(e -> {
            this.competitorDetails.getNextCN(this.database.loadcompetitors(new File(databaseFile)));
        });
    }
}

