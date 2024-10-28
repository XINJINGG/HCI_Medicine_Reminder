package com.example.myapplication.ui.home;

public class Medicine {
    private final String name; // Medicine name
    private final String purpose; // Purpose of the medicine
    private final int imageResId; // Resource ID for the medicine image
    private final String timeRemaining; // Time remaining until next dose
    private final String source; // New field for the medicine source
    private int percentage;   // Add a new field for the percentage

    // Constructor
    public Medicine(String name, String purpose, int imageResId, String timeRemaining,
                    String source,int percentage) {
        this.name = name;
        this.purpose = purpose;
        this.imageResId = imageResId;
        this.timeRemaining = timeRemaining;
        this.source = source;
        this.percentage = percentage;
    }

    // Getter for name
    public String getName() {
        return name;
    }

    // Getter for purpose
    public String getPurpose() {
        return purpose;
    }

    // Getter for image resource ID
    public int getImageResId() {
        return imageResId;
    }

    // Getter for time remaining
    public String getTimeRemaining() {
        return timeRemaining;
    }

    // Getter for medicine source
    public String getSource() {
        return source; // New getter method
    }

    // Getter for percentage
    public int getPercentage() {
        return percentage;
    }
}
