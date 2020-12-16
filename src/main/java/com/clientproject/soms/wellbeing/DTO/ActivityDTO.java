package com.clientproject.soms.wellbeing.DTO;

public class ActivityDTO {
    private String activityName;
    private int activityID;
    private String Description;
    private String Location;
    private String date;


    public ActivityDTO(String activityName, int activityID, String Description, String Location, String date){
        this.activityName = activityName;
        this.activityID = activityID;
        this.Description = Description;
        this.Location = Location;
        this.date = date;
    }

    public String getActivityName() {
        return activityName;
    }

    public int getActivityID() {
        return activityID;
    }

    public String getDescription() {
        return Description;
    }

    public String getLocation() {
        return Location;
    }

    public String getKeywords() {
        return date;
    }

}
