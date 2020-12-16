package com.clientproject.soms.wellbeing.model;

import com.clientproject.soms.wellbeing.DTO.UserDTO;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserMapper implements RowMapper {

    @Override
    public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new UserDTO(rs.getInt("USER_ID"),
                rs.getString("FIRST_NAME"),
                rs.getString("LAST_NAME"),
                rs.getDate("DATE_OF_BIRTH"),
                rs.getString("EMAIL"),
                rs.getString("TELEPHONE"),
                rs.getString("ADDRESS"),
                rs.getString("POST_CODE"));
    }
}
