package com.clientproject.soms.wellbeing.model;

import com.clientproject.soms.wellbeing.DTO.CustomActivityDTO;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;


public class CustomizeActivityCountMapper implements RowMapper {

    @Override
    public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Integer(rs.getInt("COUNT"));
    }
}
