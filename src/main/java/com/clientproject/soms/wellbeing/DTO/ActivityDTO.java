package com.clientproject.soms.wellbeing.DTO;

import java.util.Date;

public class ActivityDTO {
    private int activityID;
    private String activityName;
    private int serviceProviderID;

    public int getActivityID() {
        return activityID;
    }

    public void setActivityID(int activityID) {
        this.activityID = activityID;
    }

    public String getActivityName() {
        return activityName;
    }

    public void setActivityName(String activityName) {
        this.activityName = activityName;
    }

    public int getServiceProviderID() {
        return serviceProviderID;
    }

    public void setServiceProviderID(int serviceProviderID) {
        this.serviceProviderID = serviceProviderID;
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

    public ActivityDTO(int activityID, String activityName, int serviceProviderID, Date date, String description, String location, String keywords) {
        this.activityID = activityID;
        this.activityName = activityName;
        this.serviceProviderID = serviceProviderID;
        this.date = date;
        Description = description;
        Location = location;
        Keywords = keywords;
    }

    private Date date;
    private String Description;
    private String Location;
    private String Keywords;


}
