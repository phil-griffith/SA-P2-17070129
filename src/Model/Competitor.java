package Model;
import java.util.Arrays;

//Enum for levels
enum Level {
 BEGINNER, INTERMEDIATE, EXPERT
}

public class Competitor extends Person {
    private int competitorNumber;
    private int[] scoreArray;
    private String initials;
    private Category category; // Reference to Category
    private Level level; // Competitor level

    // Constructor 
    public Competitor(String firstname, String middlename, String lastname, String country,
            int age, String email, int competitorNumber, int[] scoreArray, Category category, Level level) {
super(firstname, middlename, lastname, country, age, email);
this.competitorNumber = competitorNumber;
this.initials = generateInitials(firstname, middlename, lastname);
this.scoreArray = scoreArray;
this.category = category;
this.level = level;
    }

    // Getters and Setters for competitorNumber
    public int getCompetitorNumber() {
        return competitorNumber;
    }

    public void setCompetitorNumber(int competitorNumber) {
        this.competitorNumber = competitorNumber;
    }

    // Getters and Setters for level (Beginner, Intermediate, Expert)
    public Level getLevel() {
        return level;
    }

    public void setLevel(Level level) {
        this.level = level;
    }
    
    // Getters and Setters for category
    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    // Getters and Setters for scoreArray
    public int[] getScoreArray() {
        return scoreArray;
    }

    public void setScoreArray(int[] scoreArray) {
        this.scoreArray = scoreArray;
    }
    
    // Getters and Setters for initials
    public String getInitials() {
        return initials;
    }

    public void setInitials(String initials) {
        this.initials = initials;
    }

    // Method to calculate overall score from scoreArray
    public double getOverallScore() {
        // Example: Calculating the average of all scores
        int sum = Arrays.stream(scoreArray).sum();
        return (double) sum / scoreArray.length;
    }
    
    // Method to get short details 
    public String getFullDetails() {
        return String.format("Competitor number %d, name %s %s %s, country %s.\n%s is a %s, aged %d and received these scores in the %s category: %s\nThis gives an overall score of %.2f.",
                competitorNumber, getFirstname(), getMiddlename(), getLastname(), getCountry(),
                getFirstname(), getLevel(), getAge(), category.getName(), Arrays.toString(scoreArray), getOverallScore());
    }

    // Method to get full details including scores ( CN 100 (KJT) has overall score 5)
    public String getShortDetails() {
        return String.format("CN %d (%s) has overall score %s.",
                competitorNumber, getInitials(), getOverallScore());
    }
    
    // Helper method to generate initials
    private String generateInitials(String firstname, String middlename, String lastname) {
        StringBuilder initialsBuilder = new StringBuilder();
        initialsBuilder.append(firstname.charAt(0));
        if (!middlename.isEmpty()) {
            initialsBuilder.append(middlename.charAt(0));
        }
        initialsBuilder.append(lastname.charAt(0));
        return initialsBuilder.toString().toUpperCase();
    }


    public static void main(String[] args) {
    	 // Example usage to test the methods
        int[] scores1 = {5, 4, 5, 4, 3};
        Category showJumping = new Category("Show Jumping", "Description");
        Competitor competitor1 = new Competitor("Keith", "John", "Talbot", "UK", 21, "keith@example.com", 100, scores1, showJumping,  Level.BEGINNER);

        int[] scores2 = {4, 3, 5, 2, 4};
        Category dressage = new Category("Dressage", "Description");
        Competitor competitor2 = new Competitor("Alice", "Mary", "Jones", "USA", 25, "alice@example.com", 101, scores2, dressage,  Level.INTERMEDIATE);

        System.out.println(competitor1.getFullDetails());
        System.out.println(competitor2.getFullDetails());
        System.out.println(competitor1.getShortDetails());
        System.out.println(competitor2.getShortDetails());
    }
}