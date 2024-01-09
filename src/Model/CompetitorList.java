package Model;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class CompetitorList {

    private ArrayList<Competitor> competitorArrayList;

    public CompetitorList() {
        competitorArrayList = new ArrayList<>();
    }

    // adds competitor to our collection
    public void addCompetitor(Competitor competitor) {
        competitorArrayList.add(competitor);
    }

    // saves competitor to database file
    public void saveCompetitor(File file) {
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file, true));

            for (int i = 0; i < competitorArrayList.size(); i++) {
                Competitor competitor = competitorArrayList.get(i);
                String saveData = String.format("%s; %s; %s; %s; %d; %s; %d; %s; %s; %s",
                        competitor.getFirstname(),
                        competitor.getMiddlename(),
                        competitor.getLastname(),
                        competitor.getCountry(),
                        competitor.getAge(),
                        competitor.getEmail(),
                        competitor.getCompetitorNumber(),
                        Arrays.toString(competitor.getScoreArray()),
                        competitor.getCategory().getName(),
                        competitor.getLevel());

                bufferedWriter.write(saveData);
                bufferedWriter.newLine();
            }

            // prevents memory leak
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    // updates competitor in database file
    public void updateCompetitor(File file, String data, String compNo, Object[] objects) {
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file, true));

            int i = 0;
            while(i < objects.length) {
                String row = objects[i].toString().trim();
                String[] rows = row.split(";");
                String saveData;
                if (rows[6].trim() == compNo)  {
                	System.out.println("Found Competitor in file");
                	System.out.println(row);
                	saveData = data;
                }
                else {
                saveData = row;
                }
                i++;
                bufferedWriter.write(saveData);
                bufferedWriter.newLine();
            }

            // prevents memory leak
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // reads competitor from database file
    public Object[] loadcompetitors(File file) {
        Object[] objects;
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            // each lines to array
            objects = bufferedReader.lines().toArray();
            bufferedReader.close();
            return objects;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }



}