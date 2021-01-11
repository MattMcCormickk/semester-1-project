package com.clientproject.soms.wellbeing.repository;

import com.clientproject.soms.wellbeing.DTO.ActivityDTO;
import com.clientproject.soms.wellbeing.form.ActivityData;
import com.clientproject.soms.wellbeing.form.CreateActivity;
import com.clientproject.soms.wellbeing.form.CustomizeActivity;
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

    public boolean saveCustomizedActivity(CustomizeActivity customizeActivity) {
        int[] types = new int[] {
                Types.INTEGER,
                Types.INTEGER,
                Types.VARCHAR,
                Types.VARCHAR,
                Types.VARCHAR,
                Types.VARCHAR,
                Types.VARCHAR,
                Types.VARCHAR,
                Types.VARCHAR,
                Types.VARCHAR,
                Types.VARCHAR,
                Types.VARCHAR,
                Types.VARCHAR,
                Types.VARCHAR
        };

        int rows = template.update(
                "INSERT INTO ACTIVITY_CUSTOM (ACTIVITY_ID, SERV_PROV_ID, CUST_METRIC_1, CUST_METRIC_2, CUST_METRIC_3, CUST_METRIC_4, CUST_METRIC_5, CUST_METRIC_6, " +
                        "CUST_OUTPUT_1, CUST_OUTPUT_2, CUST_OUTPUT_3, CUST_OUTPUT_4, CUST_OUTPUT_5, CUST_OUTPUT_6) " +
                        "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)",
                new Object[]{customizeActivity.getActivityId(),
                        1,
                        customizeActivity.getCustMetric1(),
                        customizeActivity.getCustMetric2(),
                        customizeActivity.getCustMetric3(),
                        customizeActivity.getCustMetric4(),
                        customizeActivity.getCustMetric5(),
                        customizeActivity.getCustMetric6(),
                        customizeActivity.getCustOutput1(),
                        customizeActivity.getCustOutput2(),
                        customizeActivity.getCustOutput3(),
                        customizeActivity.getCustOutput4(),
                        customizeActivity.getCustOutput5(),
                        customizeActivity.getCustOutput6()}, types);

        return rows > 0;
    }

}
