package com.clientproject.soms.wellbeing.DTO;

import java.util.Date;

public class ActivityDataDTO {
    private int activityID;
    private float hours;
    private String activityName;
    private String description;
    private int noBagsRubbish;
    private int noVolunteer;
    private int userID;
    private Date activityDate;

    public ActivityDataDTO(int activityID, float hours, String activityName, String description, int noBagsRubbish, int noVolunteer, int userID, Date activityDate) {
        this.activityID = activityID;
        this.hours = hours;
        this.activityName = activityName;
        this.description = description;
        this.noBagsRubbish = noBagsRubbish;
        this.noVolunteer = noVolunteer;
        this.userID = userID;
        this.activityDate = activityDate;
    }

    public int getActivityID() {
        return activityID;
    }

    public float getHours() {
        return hours;
    }

    public String getActivityName() {
        return activityName;
    }

    public String getDescription() {
        return description;
    }

    public int getNoBagsRubbish() {
        return noBagsRubbish;
    }

    public int getNoVolunteer() {
        return noVolunteer;
    }

    public int getUserID() {
        return userID;
    }

    public Date getActivityDate() {
        return activityDate;
    }
}
