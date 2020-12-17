package com.clientproject.soms.wellbeing.DTO;

import java.util.Date;

public class ActivityDTO {
    private String activityName;
    private int activityID;
    private String description;
    private String location;
    private Date date;


    public ActivityDTO(String activityName, int activityID, String description, String location,Date date) {
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

    public Date getDate() {
        return date;
    }
}
