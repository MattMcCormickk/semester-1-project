package com.clientproject.soms.wellbeing.model;

import com.clientproject.soms.wellbeing.DTO.CustomActivityDTO;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomizeActivityMapper implements RowMapper {

    @Override
    public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new CustomActivityDTO(rs.getString("CUST_METRIC_1"),
                rs.getString("CUST_METRIC_2"),
                rs.getString("CUST_METRIC_3"),
                rs.getString("CUST_METRIC_4"),
                rs.getString("CUST_METRIC_5"),
                rs.getString("CUST_METRIC_6"),
                rs.getString("CUST_OUTPUT_1"),
                rs.getString("CUST_OUTPUT_2"),
                rs.getString("CUST_OUTPUT_3"),
                rs.getString("CUST_OUTPUT_4"),
                rs.getString("CUST_OUTPUT_5"),
                rs.getString("CUST_OUTPUT_6"));
    }
}
