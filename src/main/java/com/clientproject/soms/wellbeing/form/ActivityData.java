package com.clientproject.soms.wellbeing.form;

import java.util.Date;

public class ActivityData {

    private String activityID;
    private String servProvId;
    private String activityDate;
    private int noOfHours;
    private int noOfVolunteers;
    private int bagsOfRubbish;

    public ActivityData(String activityID, String servProvId, String activityDate, int noOfHours, int noOfVolunteers, int bagsOfRubbish) {
        this.activityID = activityID;
        this.servProvId = servProvId;
        this.activityDate = activityDate;
        this.noOfHours = noOfHours;
        this.noOfVolunteers = noOfVolunteers;
        this.bagsOfRubbish = bagsOfRubbish;
    }

    public String getActivityID() {
        return activityID;
    }

    public String getServProvId() {
        return servProvId;
    }

    public String getActivityDate() {
        return activityDate;
    }

    public int getNoOfHours() {
        return noOfHours;
    }

    public int getNoOfVolunteers() {
        return noOfVolunteers;
    }

    public int getBagsOfRubbish() {
        return bagsOfRubbish;
    }
}
