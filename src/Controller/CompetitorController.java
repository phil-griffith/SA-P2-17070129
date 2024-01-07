package Controller;

import Model.CompetitorList;
import Model.Competitor;
import View.Form;
import View.CompetitorDetails;

import javax.swing.*;
import java.io.File;

public class CompetitorController {
    // data file
    private String databaseFile = "competitordata.txt";
    private CompetitorList database;
    private Form form;
    private CompetitorDetails competitorDetails;

    public CompetitorController(Form form, CompetitorDetails competitorDetails) {
        this.database = new CompetitorList();
        this.form = form;
        this.competitorDetails = competitorDetails;

        // submit competitor
        this.form.submitCompetitors(e -> {
            String firstname = this.form.getFirstname().trim();
            String middlename = this.form.getMiddlename().trim();
            String lastname = this.form.getLastname().trim();
            String country = this.form.getCountry().trim();
            String age = this.form.getAge().trim();
            String email = this.form.getEmail().trim();
            String competitornumber = this.form.getCompetitorNumber().trim();
            String scorearray = this.form.getScoreArray().trim();
            String category = this.form.getCategory().trim();
            String level = this.form.getLevel().trim();

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
            
            this.database.addCompetitor(new Competitor(firstname, middlename, lastname, country, age, email, competitornumber, scorearray, category, level));
            this.database.saveCompetitor(new File(databaseFile));
            this.form.reset(true);
        });

        // load competitors
        this.form.viewCompetitors(e -> {
            this.competitorDetails.getCompetitors(this.database.loadCompetitors(new File(databaseFile)));
        });
    }
}

