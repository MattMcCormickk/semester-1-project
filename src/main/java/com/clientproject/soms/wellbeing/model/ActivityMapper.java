package com.clientproject.soms.wellbeing.model;


import com.clientproject.soms.wellbeing.DTO.ActivityDTO;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ActivityMapper implements RowMapper {

    //`ACTIVITY_ID`, `ACTIVITY_NAME`, `SERV_PROV_ID`, `ACTIVITY_DATE`, `DESCRIPTION`, `LOCATION`

    @Override
    public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new ActivityDTO(rs.getString("ACTIVITY_NAME"),
                rs.getInt("ACTIVITY_ID"),
                rs.getString("DESCRIPTION"),
                rs.getString("LOCATION"),
                rs.getString("ACTIV ITY_DATE")
                );
    }
}
