package com.clientproject.soms.wellbeing.repository;

import com.clientproject.soms.wellbeing.DTO.ActivityDTO;
import com.clientproject.soms.wellbeing.form.CreateActivity;
import com.clientproject.soms.wellbeing.model.ActivityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ActivityRepositoryJDBC implements ActivityRepository{
    JdbcTemplate template;

    @Autowired
    public ActivityRepositoryJDBC(JdbcTemplate template) {
        this.template = template;
    }

    @Override
    public ActivityDTO findActivityByActivityName(String activityName) {
        ActivityDTO activityDTO=(ActivityDTO) template.queryForObject("ACTIVITY_NAME,ACTIVITY_ID,DESCRIPTION,LOCATION,ACTIVITY_DATE from soms_wellbeing.activity where ACTIVITY_NAME = ?",
              new Object[]{activityName},new ActivityMapper());
        return activityDTO;
    }

    @Override
    public Object findActivityByActivityID(String activityID) {
        return null;
    }

    @Override
    public boolean addActivity(CreateActivity createActivity) {
        int rows = template.update(
         "insert into ACTIVITY (ACTIVITY_ID, ACTIVITY_NAME, SERV_PROV_ID, ACTIVITY_DATE, DESCRIPTION,LOCATION,KEYWORDS) values(?,?,?,?,?, ?, ?)" ,
         new Object[]{ createActivity.getActivityName(), createActivity.getServiceProviderID(), createActivity.getActivityDate(),
                 createActivity.getDescription(),createActivity.getLocation(),
                 createActivity.getKeywords()}
        );
        return rows>0;
    }

    //query all activity
    @Override
    public List<ActivityDTO> findAllActivity() {
        return template.query(
                "select ACTIVITY_ID,ACTIVITY_NAME,SERV_PROV_ID,ACTIVITY_DATE,DESCRIPTION,LOCATION,KEYWORDS from ACTIVITY",
                new ActivityMapper()
        );
    }

}
