package com.clientproject.soms.wellbeing.repository;

import com.clientproject.soms.wellbeing.DTO.UserDTO;
import com.clientproject.soms.wellbeing.form.CaptureUserActivity;
import com.clientproject.soms.wellbeing.model.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Types;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Repository
public class UserRepositoryJDBC implements UserRepository {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public UserRepositoryJDBC(JdbcTemplate template){
        jdbcTemplate = template;
    }

    // Method to query all the users from the database
    @Override
    public List<UserDTO> findAllUsers() {
        return jdbcTemplate.query(
                "SELECT USER_ID, FIRST_NAME, LAST_NAME, DATE_OF_BIRTH, EMAIL, TELEPHONE, ADDRESS, POST_CODE FROM USER",
                new UserMapper());
    }

    // Method to save the user activity data in the database
    @Override
    public boolean saveUserActvityData(CaptureUserActivity captureUserActivity) throws ParseException {
        int[] types = new int[] {
                Types.INTEGER,
                Types.INTEGER,
                Types.INTEGER,
                Types.DATE,
                Types.INTEGER
        };

        /*  Added to convert String to Date format.
            This is needed because the activity date is being read as String from the input HTML form. */
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date activityDt = format.parse(captureUserActivity.getActivityDate());

        int rowsActData = jdbcTemplate.update(
                "INSERT INTO ACTIVITY_DATA (ACTIVITY_ID, SERV_PROV_ID, USER_ID, ACTIVITY_DATE, NO_OF_HOURS) VALUES (?,?,?,?,?)",
                new Object[]{captureUserActivity.getActivityID(),
                        1,
                        captureUserActivity.getUserId(),
                        activityDt,
                        captureUserActivity.getNoOfHours()}, types);

        int rowsActOut = jdbcTemplate.update(
                "INSERT INTO ACTIVITY_OUTPUTS (ACTIVITY_ID, SERV_PROV_ID, USER_ID, ACTIVITY_DATE, NO_BAGS_RUBBISH) VALUES (?,?,?,?,?)",
                new Object[]{captureUserActivity.getActivityID(),
                        1,
                        captureUserActivity.getUserId(),
                        activityDt,
                        captureUserActivity.getBagsOfRubbish()}, types);
        return rowsActData > 0 && rowsActOut > 0;
    }
}
