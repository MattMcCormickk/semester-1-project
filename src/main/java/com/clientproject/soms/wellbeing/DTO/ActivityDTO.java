package com.clientproject.soms.wellbeing.DTO;

public class ActivityDTO {
    private String activityName;
    private String activityID;
    private String Description;
    private String Location;
    private String Keywords;
    private String userID;
    private String metric1;
    private String metric2;
    private String metric3;

    public ActivityDTO(String activityName, String activityID, String Description, String Location, String Keywords,
                       String userID, String metric1, String metric2, String metric3){
        this.activityName = activityName;
        this.activityID = activityID;
        this.Description = Description;
        this.Location = Location;
        this.Keywords = Keywords;
        this.userID = userID;
        this.metric1 = metric1;
        this.metric2 = metric2;
        this.metric3 = metric3;
    }

    public String getActivityName() {
        return activityName;
    }

    public String getActivityID() {
        return activityID;
    }

    public String getDescription() {
        return Description;
    }

    public String getLocation() {
        return Location;
    }

    public String getKeywords() {
        return Keywords;
    }

    public String getUserID(){ return userID;}

    public String getMetric1() {return metric1;}

    public String getMetric2() {return metric2;}

    public String getMetric3() {return metric3;}
}
