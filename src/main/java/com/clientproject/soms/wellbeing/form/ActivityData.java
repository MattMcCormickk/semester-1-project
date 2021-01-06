package com.clientproject.soms.wellbeing.form;




public class ActivityData {
    private int activityID;
    private String activityName;
    private String activityDate;
    private int noVolunteers;
    private float duration;
    private int noOfRubbish;
    private int serProID;


    public ActivityData(int activityID, String activityName, String activityDate, int noVolunteers, int noOfRubbish,  float duration) {

        this.activityName = activityName;
        this.activityDate = activityDate;
        this.activityID = activityID;
        this.duration = duration;
        this.noVolunteers = noVolunteers;
        this.noOfRubbish = noOfRubbish;
        this.serProID = serProID;
    }

    public String getActivityDate() {
        return activityDate;
    }

    public int getActivityID(){return activityID; }

    public float getDuration(){return duration; }


    public int getNoVolunteers(){
    return noVolunteers;}

    public int getRubbishCollected(){return noOfRubbish;}
}

