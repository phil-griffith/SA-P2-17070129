package Model;

public class Category {
    private String name;
    private String description;

    // Constructor for Category
    public Category(String name, String description) {
        this.name = name;
        this.description = description;
    }

    // Getters and Setters for name
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Getters and Setters for description
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

