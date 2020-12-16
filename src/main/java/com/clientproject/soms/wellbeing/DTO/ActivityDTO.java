package com.clientproject.soms.wellbeing.DTO;

import java.util.Date;

public class ActivityDTO {
    private String activityID;
    private String activityName;
    private Date date;
    private String Description;
    private String Location;
    private String Keywords;

    public ActivityDTO(String activityID, String activityName, Date date, String description, String location, String keywords) {
        this.activityID = activityID;
        this.activityName = activityName;
        this.date = date;
        Description = description;
        Location = location;
        Keywords = keywords;
    }

    public String getActivityID() {
        return activityID;
    }

    public void setActivityID(String activityID) {
        this.activityID = activityID;
    }

    public String getActivityName() {
        return activityName;
    }

    public void setActivityName(String activityName) {
        this.activityName = activityName;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getLocation() {
        return Location;
    }

    public void setLocation(String location) {
        Location = location;
    }

    public String getKeywords() {
        return Keywords;
    }

    public void setKeywords(String keywords) {
        Keywords = keywords;
    }
}
