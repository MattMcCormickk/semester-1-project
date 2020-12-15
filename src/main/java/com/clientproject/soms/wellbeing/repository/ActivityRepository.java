package com.clientproject.soms.wellbeing.repository;

import com.clientproject.soms.wellbeing.DTO.ActivityDTO;
import com.clientproject.soms.wellbeing.form.CreateActivity;

import java.util.List;

public interface ActivityRepository {
    public Object findActivityByActivityName(String activityName);
    public Object findActivityByActivityID(String activityID);
    boolean addActivity(CreateActivity createActivity);

    List<ActivityDTO> findAllActivities();
}
