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
    private String userFirstName;
    private String userLastName;

    public ActivityDataDTO(int activityID, float hours, String activityName, String description, int noBagsRubbish, int noVolunteer, int userID, Date activityDate, String userFirstName, String userLastName) {
        this.activityID = activityID;
        this.hours = hours;
        this.activityName = activityName;
        this.description = description;
        this.noBagsRubbish = noBagsRubbish;
        this.noVolunteer = noVolunteer;
        this.userID = userID;
        this.activityDate = activityDate;
        this.userFirstName = userFirstName;
        this.userLastName = userLastName;
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

    public String getUserFirstName() {
        return userFirstName;
    }

    public String getUserLastName() {
        return userLastName;
    }
}
