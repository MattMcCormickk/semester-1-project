package com.clientproject.soms.wellbeing.model;


import com.clientproject.soms.wellbeing.DTO.ActivityDTO;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ActivityMapper implements RowMapper {

    @Override
    public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new ActivityDTO(rs.getInt("ACTIVITY_ID"),
                rs.getString("ACTIVITY_NAME"),
                rs.getInt("SERV_PROV_ID"),
                rs.getDate("ACTIVITY_DATE"),
                rs.getString("DESCRIPTION"),
                rs.getString("LOCATION"),
                rs.getString("KEYWORDS"));
    }
}
