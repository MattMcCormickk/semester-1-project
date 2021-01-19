package com.clientproject.soms.wellbeing.repository;

import com.clientproject.soms.wellbeing.DTO.ActivityDTO;
import com.clientproject.soms.wellbeing.form.ActivityData;
import com.clientproject.soms.wellbeing.form.CreateActivity;
import com.clientproject.soms.wellbeing.model.ActivityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Types;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
        ActivityDTO activityDTO=(ActivityDTO) template.queryForObject("Select ACTIVITY_NAME,ACTIVITY_ID,DESCRIPTION,LOCATION,ACTIVITY_DATE from soms_wellbeing.activity where ACTIVITY_NAME = ?",
              new Object[]{activityName},new ActivityMapper());
        return activityDTO;
    }

    @Override
    public Object findActivityByActivityID(String activityID) {
        return null;
    }

    @Override
    public boolean addActivity(CreateActivity createActivity) throws ParseException {
        int types[] = new int[] {
                Types.VARCHAR,
                Types.INTEGER,
                Types.DATE,
                Types.VARCHAR,
                Types.VARCHAR,
                Types.VARCHAR
        };

        /*  Added to convert String to Date format.
            This is needed because the activity date is being read as String from the input HTML form. */

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date activityDt = format.parse(createActivity.getActivityDate());

        int rows = template.update(
         "insert into ACTIVITY (ACTIVITY_NAME,SERV_PROV_ID, ACTIVITY_DATE, DESCRIPTION,LOCATION,KEYWORDS) values(?,?,?,?,?,?)",
                new Object[]{createActivity.getActivityName(), 1, activityDt,
                createActivity.getDescription(),createActivity.getLocation(),
                createActivity.getKeywords()}, types);
        return rows>0;
    }

    public boolean addActivityData(ActivityData activityData) throws ParseException {
        int[] types1 = new int[] {
                Types.INTEGER,
                Types.INTEGER,
                Types.DATE,
                Types.INTEGER,
                Types.FLOAT,
        };
        int[] types2 = new int[] {
                Types.INTEGER,
                Types.INTEGER,
                Types.DATE,
                Types.INTEGER,
        };

    /*  Added to convert String to Date format.
        This is needed because the activity date is being read as String from the input HTML form. */
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date activityDt = format.parse(activityData.getActivityDate());

        int rowsActData = template.update(
                "INSERT INTO ACTIVITY_DATA (ACTIVITY_ID, SERV_PROV_ID, ACTIVITY_DATE, NO_OF_VOLUNTEERS, NO_OF_HOURS) VALUES (?,?,?,?,?)",
                new Object[]{activityData.getActivityID(),
                        1,
                        activityDt,
                        activityData.getNoOfVolunteers(),
                        activityData.getNoOfHours()}, types1);

        int rowsActOut = template.update(
                "INSERT INTO ACTIVITY_OUTPUTS (ACTIVITY_ID, SERV_PROV_ID, ACTIVITY_DATE, NO_BAGS_RUBBISH) VALUES (?,?,?,?)",
                new Object[]{activityData.getActivityID(),
                        1,
                        activityDt,
                        activityData.getBagsOfRubbish()}, types2);
        return rowsActData > 0 && rowsActOut > 0;
    }

    //query all activity
    @Override
    public List<ActivityDTO> findAllActivity() {
        return template.query(
                "select ACTIVITY_NAME,ACTIVITY_ID,SERV_PROV_ID,DESCRIPTION,LOCATION,ACTIVITY_DATE,KEYWORDS from soms_wellbeing.activity",
                new ActivityMapper()
        );
    }


    @Override
    public List<ActivityDTO> findAllActivityBySerPro(int serProID){
        ActivityDTO activityDTO=(ActivityDTO) template.queryForObject("Select ACTIVITY_NAME,ACTIVITY_ID,DESCRIPTION,LOCATION,ACTIVITY_DATE from soms_wellbeing.activity where ACTIVITY_NAME = ?",
                new Object[]{serProID},new ActivityMapper());
        return (List<ActivityDTO>) activityDTO;
    }

    @Override
    public boolean updateActivity(CreateActivity createActivity) throws ParseException {
        int types[] = new int[] {
                Types.VARCHAR,
                Types.VARCHAR,
                Types.VARCHAR,
                Types.DATE,
                Types.INTEGER
        };

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date date = format.parse(createActivity.getActivityDate());

        int activityID = Integer.parseInt(createActivity.getKeywords());

        int rows = template.update(
                "update soms_wellbeing.ACTIVITY SET ACTIVITY_NAME = ?, DESCRIPTION = ?, LOCATION = ?, ACTIVITY_DATE = ? where ACTIVITY_ID = ?",

                new Object[]{createActivity.getActivityName(), createActivity.getDescription(), createActivity.getLocation(), date, activityID}, types);
        return rows > 0;
    }

}
