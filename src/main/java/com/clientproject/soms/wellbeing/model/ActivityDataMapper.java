package com.clientproject.soms.wellbeing.model;

import com.clientproject.soms.wellbeing.DTO.ActivityDataDTO;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ActivityDataMapper implements RowMapper{

    @Override
    public ActivityDataDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new ActivityDataDTO(rs.getInt("ACTIVITY_ID"),
                rs.getInt("SER_PRO_ID"),
                rs.getDate("ACTIVITY_DATE"),
                rs.getInt("NO_OF_VOLUNTEERS"),
                rs.getFloat("DURATION"),
                rs.getInt("RUBBISH_COLLECTED")
        );

    }
}
