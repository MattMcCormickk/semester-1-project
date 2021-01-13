package com.clientproject.soms.wellbeing.model;

import com.clientproject.soms.wellbeing.DTO.ServiceProviderDTO;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ServiceProviderMapper implements RowMapper {

    @Override
    public Object mapRow(ResultSet rs, int rowNum) throws SQLException{
        return new ServiceProviderDTO(
                rs.getInt("SERV_PROV_ID"),
                rs.getString("NAME"),
                rs.getString("EMAIL"),
                rs.getString("TELEPHONE"),
                rs.getString("ADDRESS"),
                rs.getString("POST_CODE"),
                rs.getString("COMP_HSE_ID")
        );
    }

}
