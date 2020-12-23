package com.clientproject.soms.wellbeing.model;

import com.clientproject.soms.wellbeing.DTO.ActivityDataDTO;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ActivityDataMapper implements RowMapper {

    @Override
    public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new ActivityDataDTO(rs.getInt("ACTIVITY_ID"),
                rs.getFloat("NO_OF_HOURS"),
                rs.getString("ACTIVITY_NAME"),
                rs.getString("DESCRIPTION"),
                rs.getInt("NO_BAGS_RUBBISH"));

    }
}
