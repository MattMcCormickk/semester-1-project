package com.clientproject.soms.wellbeing.model;

import com.clientproject.soms.wellbeing.DTO.ActivityDTO;
import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ActivityMapper implements RowMapper {

    @Override
    public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new ActivityDTO(rs.getString("activityName"),
                rs.getString("activityID"),
                rs.getString("Description"),
                rs.getString("location"),
                rs.getString("keywords"));
    }
}
