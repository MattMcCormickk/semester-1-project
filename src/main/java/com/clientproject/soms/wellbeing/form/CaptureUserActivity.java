package com.clientproject.soms.wellbeing.form;

import java.util.Date;

public class CaptureUserActivity {

    private String userId;
    private String activityID;
    private String servProvId;
    private String activityDate;
    private int noOfHours;
    private int bagsOfRubbish;

    public CaptureUserActivity(String userId, String activityID, String servProvId, String activityDate, int noOfHours, int bagsOfRubbish) {
        this.userId = userId;
        this.activityID = activityID;
        this.servProvId = servProvId;
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

    public String getServProvId() {
        return servProvId;
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
