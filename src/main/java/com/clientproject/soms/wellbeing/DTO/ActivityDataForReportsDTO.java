package com.clientproject.soms.wellbeing.DTO;

import java.util.Date;

public class ActivityDataForReportsDTO {
    private int activityID;
    private int servProID;
    private int userID;
    private int numOfVol;
    private int numOfHours;
    private int cusValueOne;
    private int cusValueTwo;
    private String cusMetricOne;
    private String cusMetricTwo;
    private Date date;

    public ActivityDataForReportsDTO(int activityID, int servProID, int userID, int numOfVol, int numOfHours, int cusValueOne, int cusValueTwo, String cusMetricOne, String cusMetricTwo, Date date) {
        this.activityID = activityID;
        this.servProID = servProID;
        this.userID = userID;
        this.numOfVol = numOfVol;
        this.numOfHours = numOfHours;
        this.cusValueOne = cusValueOne;
        this.cusValueTwo = cusValueTwo;
        this.cusMetricOne = cusMetricOne;
        this.cusMetricTwo = cusMetricTwo;
        this.date = date;
    }

    public int getActivityID() {
        return activityID;
    }

    public int getServProID() {
        return servProID;
    }

    public int getUserID() {
        return userID;
    }

    public int getNumOfVol() {
        return numOfVol;
    }

    public int getNumOfHours() {
        return numOfHours;
    }

    public int getCusValueOne() {
        return cusValueOne;
    }

    public int getCusValueTwo() {
        return cusValueTwo;
    }

    public String getCusMetricOne() {
        return cusMetricOne;
    }

    public String getCusMetricTwo() {
        return cusMetricTwo;
    }

    public Date getDate() {
        return date;
    }
}
