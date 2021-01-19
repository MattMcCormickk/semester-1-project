package com.clientproject.soms.wellbeing.repository;

import com.clientproject.soms.wellbeing.DTO.CustomActivityDTO;
import com.clientproject.soms.wellbeing.form.ActivityData;
import com.clientproject.soms.wellbeing.form.CreateActivity;
import com.clientproject.soms.wellbeing.form.CustomizeActivity;
import com.clientproject.soms.wellbeing.form.ReplyFromAdmin;

import java.text.ParseException;

public interface ActivityRepository {
    public Object findActivityByActivityName(String activityName);
    public Object findActivityByActivityID(String activityID);
    boolean addActivity(CreateActivity createActivity) throws ParseException;
    boolean addActivityData(ActivityData activityData) throws ParseException;
    public Object findAllActivity();
    boolean saveCustomizedActivity(CustomizeActivity customizeActivity);
    public CustomActivityDTO getCustomMetrics(String activityId);
    public Object findAllActivityBySerPro(int serProID);
    boolean updateActivity(CreateActivity createActivity) throws ParseException;
}
