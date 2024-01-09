package Controller;

import Model.CompetitorList;
import Model.Competitor;
import Model.Level;
import View.Form;
import View.Form2;
import View.Menu;
import View.UpdateCompetitor;
import View.CompetitorDetails;
import Model.Category;

import javax.swing.*;
import java.io.File;
import java.util.Arrays;

public class CompetitorController {
    // data file
    private String databaseFile = "competitordata.txt";
    private CompetitorList database;
    private UpdateCompetitor updateCompetitor;
    private Menu menu;
    private Form form;
    private Form2 form2;
    private CompetitorDetails competitorDetails;

    public CompetitorController(Menu menu, UpdateCompetitor updateCompetitor, Form form, CompetitorDetails competitorDetails) {
        this.database = new CompetitorList();
        this.menu = menu;
        this.form = form;
        this.competitorDetails = competitorDetails;
        this.updateCompetitor = updateCompetitor;

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
        
//        // update competitor
//        this.form2.updateCompetitor(e -> {
//            String firstname = this.form2.getFirstname().trim();
//            String middlename = this.form2.getMiddlename().trim();
//            String lastname = this.form2.getLastname().trim();
//            String country = this.form2.getCountry().trim();
//            int age = this.form2.getAge();
//            String email = this.form2.getEmail().trim();
//            String competitorNumber = this.form2.getCompetitorNumber();
//            int[] scorearray = this.form.getScoreArray();
//            Category category = this.form.getCategory();
//            Level level = this.form.getLevel();
//
//
//            
//            // simple validations
//            if(firstname.isEmpty()) {
//                JOptionPane.showMessageDialog(this.form, "First Name Required.", "Error",
//                        JOptionPane.ERROR_MESSAGE);
//                return;
//            } else if(middlename.isEmpty()) {
//                JOptionPane.showMessageDialog(this.form, "Middle Name Required.", "Error",
//                        JOptionPane.ERROR_MESSAGE);
//                return;
//            } else if(lastname.isEmpty()) {
//                JOptionPane.showMessageDialog(this.form, "Last Name Required.", "Error",
//                        JOptionPane.ERROR_MESSAGE);
//                return;
//            }
//            
//            String data = String.format("%s; %s; %s; %s; %d; %s; %d; %s; %s; %s",
//                    firstname,
//                    middlename,
//                    lastname,
//                    country,
//                    age,
//                    email,
//                    competitorNumber,
//                    scorearray,
//                    category,
//                    level);
//            
//            this.database.updateCompetitor(new File(databaseFile), data,competitorNumber, this.database.loadcompetitors(new File(databaseFile)));
//            this.form2.reset(true);
//        });

        // load competitors
        this.menu.viewCompetitors(e -> {
            this.competitorDetails.getCompetitors(this.database.loadcompetitors(new File(databaseFile)));
        });
        
        // get competitor
        this.updateCompetitor.getCompetitor(e -> {
        	int compNo = this.updateCompetitor.getCompNo();
        	
            this.updateCompetitor.getCompetitor(this.database.loadcompetitors(new File(databaseFile)),compNo);
  });
}
}

