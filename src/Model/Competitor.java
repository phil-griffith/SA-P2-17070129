package Model;
import java.util.Arrays;

public class Competitor extends Person {
    private int competitorNumber;
    private String initials;
    private int[] scoreArray;

    // Constructor 
    public Competitor(String firstname, String middlename, String lastname, String country,
                                  int age, String email, int competitorNumber, int[] scoreArray) {
        super(firstname, middlename, lastname, country, age, email);
        this.competitorNumber = competitorNumber;
        this.scoreArray = scoreArray;
    }

    // Getters and Setters for competitorNumber
    public int getCompetitorNumber() {
        return competitorNumber;
    }

    public void setCompetitorNumber(int competitorNumber) {
        this.competitorNumber = competitorNumber;
    }

    // Getters and Setters for initials
    public String getInitials() {
        return initials;
    }

    public void setInitials(String initials) {
        this.initials = initials;
    }

    // Getters and Setters for scoreArray
    public int[] getScoreArray() {
        return scoreArray;
    }

    public void setScoreArray(int[] scoreArray) {
        this.scoreArray = scoreArray;
    }

    // Method to calculate overall score from scoreArray
    public double getOverallScore() {
        // Example: Calculating the average of all scores
        int sum = Arrays.stream(scoreArray).sum();
        return (double) sum / scoreArray.length;
    }

    // Method to get full details including scores
    public String getFullDetails() {
        return String.format("Competitor number %d, name %s %s %s, country %s.\n%s is aged %d and received these scores: %s\nThis gives him an overall score of %.2f.",
                competitorNumber, getFirstname(), getMiddlename(), getLastname(), getCountry(),
                getFirstname(), getAge(), Arrays.toString(scoreArray), getOverallScore());
    }


    public static void main(String[] args) {
        // Example usage to test the methods
        int[] scores1 = {5, 4, 5, 4, 3};
        Competitor competitor1 = new Competitor("Keith", "John", "Talbot", "UK", 21, "keith@example.com", 100, scores1);

        int[] scores2 = {4, 3, 5, 2, 4};
        Competitor competitor2 = new Competitor("Alice", "Mary", "Jones", "USA", 25, "alice@example.com", 101, scores2);

        System.out.println(competitor1.getFullDetails());
        System.out.println(competitor2.getFullDetails());
    }
}