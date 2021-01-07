package com.clientproject.soms.wellbeing.repository;

import com.clientproject.soms.wellbeing.form.ActivityData;
import com.clientproject.soms.wellbeing.form.CreateActivity;

import java.text.ParseException;

public interface ActivityRepository {
    public Object findActivityByActivityName(String activityName);
    public Object findActivityByActivityID(String activityID);
    boolean addActivity(CreateActivity createActivity) throws ParseException;
    boolean addActivityData(ActivityData activityData) throws ParseException;
    public Object findAllActivity();
}
