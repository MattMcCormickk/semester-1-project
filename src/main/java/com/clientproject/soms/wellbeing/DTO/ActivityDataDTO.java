package com.clientproject.soms.wellbeing.DTO;

import java.util.Date;

public class ActivityDataDTO {
    private int activityID;
    private int serProID;
    private float duration;
    private int noBagsRubbish;
    private int noVolunteer;
    private Date activityDate;


    public ActivityDataDTO(int activityID, int serProID, java.sql.Date activityDate, int noVolunteer, float duration, int noBagsRubbish) {

        this.activityID = activityID;
        this.duration = duration;
        this.noBagsRubbish = noBagsRubbish;
        this.noVolunteer = noVolunteer;
        this.activityDate = activityDate;
        this.serProID = serProID;
    }

    public int getActivityID() {
        return activityID;
    }

    public float getHours() {
        return duration;
    }

    public int getNoBagsRubbish() {
        return noBagsRubbish;
    }

    public int getNoVolunteer() {
        return noVolunteer;
    }

    public Date getActivityDate() {
        return activityDate;
    }
}
