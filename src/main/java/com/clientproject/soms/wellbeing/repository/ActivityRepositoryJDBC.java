package com.clientproject.soms.wellbeing.repository;

import com.clientproject.soms.wellbeing.DTO.ActivityDTO;
import com.clientproject.soms.wellbeing.form.CreateActivity;
import com.clientproject.soms.wellbeing.model.ActivityMapper;
import org.springframework.stereotype.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

@Repository
public class ActivityRepositoryJDBC implements ActivityRepository{

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public ActivityRepositoryJDBC(JdbcTemplate aTemplate) {
        jdbcTemplate = aTemplate;
    }

    @Override
    public List<ActivityDTO> findAllActivities() {
        return jdbcTemplate.query(
                "select activityName, activityID,description, location, keywords",
                new ActivityMapper());
    }

    @Override
    public boolean addActivity(CreateActivity createActivity){
        int rows = jdbcTemplate.update(
                "insert into Activity (activityName, activityID, description, location, keywords) values(?,?,?,?,?)" ,
                new Object[]{createActivity.getActivityName(), createActivity.getActivityID(), createActivity.getDescription(),
                createActivity.getLocation(), createActivity.getKeywords() });
        return rows>0;
    }

    @Override
    public ActivityDTO findActivityByActivityName(String activityName){
        ActivityDTO activityDTO = (ActivityDTO) jdbcTemplate.queryForObject(
                "select activityName, activityID,description, location, keywords",
                new Object[]{activityName}, new ActivityMapper());
        return activityDTO;
    }

    @Override
    public ActivityDTO findActivityByActivityID(String activityID) {
        ActivityDTO activityDTO = (ActivityDTO) jdbcTemplate.queryForObject(
                "select activityName, activityID,description, location, keywords",
                new Object[]{activityID}, new ActivityMapper());
        return activityDTO;
    }
}
