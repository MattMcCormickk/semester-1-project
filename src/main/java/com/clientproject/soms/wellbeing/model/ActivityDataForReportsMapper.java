package com.clientproject.soms.wellbeing.model;


import com.clientproject.soms.wellbeing.DTO.ActivityDataForReportsDTO;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ActivityDataForReportsMapper implements RowMapper {


    @Override
    public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new ActivityDataForReportsDTO(rs.getInt("ACTIVITY_ID"),
                rs.getInt("SERV_PROV_ID"),
                rs.getInt("USER_ID"),
                rs.getInt("NO_OF_VOLUNTEERS"),
                rs.getInt("NO_OF_HOURS"),
                rs.getInt("CUST_VALUE_1"),
                rs.getInt("CUST_VALUE_2"),
                rs.getString("CUST_METRIC_1"),
                rs.getString("CUST_METRIC_2"),
                rs.getDate("ACTIVITY_DATE"));
    }
}
