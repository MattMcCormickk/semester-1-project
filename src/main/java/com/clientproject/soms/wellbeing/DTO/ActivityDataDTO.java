package com.clientproject.soms.wellbeing.DTO;

public class ActivityDataDTO {
    private int activityID;
    private float hours;
    private String activityName;
    private String description;
    private int noBagsRubbish;

    public ActivityDataDTO(int activityID, float hours, String activityName, String description, int noBagsRubbish) {
        this.activityID = activityID;
        this.hours = hours;
        this.activityName = activityName;
        this.description = description;
        this.noBagsRubbish = noBagsRubbish;
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
}
