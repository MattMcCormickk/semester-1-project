package com.clientproject.soms.wellbeing.DTO;

import java.sql.Date;

public class ActivityDTO {
    private String activityName;
    private int activityID;
    private String description;
    private String location;
    private Date date;
    private String keywords;
    private int serviceProviderID;



    public ActivityDTO(int activityID, String activityName, int serviceProviderID, Date date, String description, String location, String keywords) {
        this.activityName = activityName;
        this.activityID = activityID;
        this.description = description;
        this.location = location;
        this.date = date;
        this.serviceProviderID = serviceProviderID;
        this.keywords = keywords;
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

    public int getServiceProviderID(){return serviceProviderID;}

}
