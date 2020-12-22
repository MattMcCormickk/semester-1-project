package com.clientproject.soms.wellbeing.DTO;

import java.util.Date;

public class ActivityDTO {
    private String activityName;
    private int activityID;
    private int serProID;
    private String description;
    private String location;
    private Date date;
    private String keyWords;


    public ActivityDTO(int activityID, String activityName,  int serProID, String description, String location, Date date, String keyWords) {
        this.activityName = activityName;
        this.activityID = activityID;
        this.serProID = serProID;
        this.description = description;
        this.location = location;
        this.date = date;
        this.keyWords = keyWords;
    }

    public String getActivityName() {
        return activityName;
    }

    public int getActivityID() {
        return activityID;
    }

    public int getSerProID() {
        return serProID;
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

    public String getKeyWords() {
        return keyWords;
    }
}
