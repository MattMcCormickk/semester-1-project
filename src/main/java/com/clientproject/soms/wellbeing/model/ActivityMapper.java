package com.clientproject.soms.wellbeing.model;


import com.clientproject.soms.wellbeing.DTO.ActivityDTO;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ActivityMapper implements RowMapper<ActivityDTO> {

    //`ACTIVITY_NAME`, ACTIVITY_ID,  `DESCRIPTION`, `LOCATION`, DATE

    @Override
    public ActivityDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new ActivityDTO(rs.getString("ACTIVITY_NAME"),
                rs.getInt("ACTIVITY_ID"),
                rs.getString("DESCRIPTION"),
                rs.getString("LOCATION"),
                rs.getString("DATE"));
    }
}
