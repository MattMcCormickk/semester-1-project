package com.clientproject.soms.wellbeing.DTO;

public class ActivityDTO {
    private String activityName;
    private int activityID;
    private String description;
    private String location;
    private String date;


    public ActivityDTO(String activityName, int activityID, String description, String location, String date) {
        this.activityName = activityName;
        this.activityID = activityID;
        this.description = description;
        this.location = location;
        this.date = date;
    }

    public String getActivityName() {
        return activityName;
    }

    public int getActivityID() {
        return activityID;
    }

    public String getDescription() {
        return description;
    }

    public String getLocation() {
        return location;
    }

    public String getDate() {
        return date;
    }
}
