package com.clientproject.soms.wellbeing.model;

import com.clientproject.soms.wellbeing.DTO.ServiceProviderCountDTO;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ServiceProviderCountMapper implements RowMapper {

    @Override
    public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new ServiceProviderCountDTO(rs.getInt("count(*)"));
    }

}
