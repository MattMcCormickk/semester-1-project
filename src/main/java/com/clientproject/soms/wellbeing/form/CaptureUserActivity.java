package com.clientproject.soms.wellbeing.form;

import java.util.Date;

public class CaptureUserActivity {

    private String userId;
    private String activityID;
    private String activityDate;
    private int noOfHours;
    private int bagsOfRubbish;

    public CaptureUserActivity(String userId, String activityID, String activityDate, int noOfHours, int bagsOfRubbish) {
        this.userId = userId;
        this.activityID = activityID;
        this.activityDate = activityDate;
        this.noOfHours = noOfHours;
        this.bagsOfRubbish = bagsOfRubbish;
    }

    public String getUserId() {
        return userId;
    }

    public String getActivityID() {
        return activityID;
    }

    public String getActivityDate() {
        return activityDate;
    }

    public int getNoOfHours() {
        return noOfHours;
    }

    public int getBagsOfRubbish() {
        return bagsOfRubbish;
    }
}
