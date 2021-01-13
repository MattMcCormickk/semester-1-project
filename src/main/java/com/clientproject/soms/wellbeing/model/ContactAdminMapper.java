package com.clientproject.soms.wellbeing.model;

import com.clientproject.soms.wellbeing.DTO.ContactAdminDTO;

import javax.swing.tree.TreePath;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

public class ContactAdminMapper implements RowMapper {

    public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new ContactAdminDTO(rs.getInt("MESSAGE_ID"),
                rs.getInt("SERV_PROV_ID"),
                rs.getString("SERV_PROV_NAME"),
                rs.getString("SERV_PROV_EMAIL"),
                rs.getString("MESSAGE"),
                rs.getDate("RECEIVED_DATE"),
                rs.getString("PRIORITY"),
                rs.getString("REPLY_MESSAGE"),
                rs.getDate("REPLIED_DATE"),
                rs.getString("ADMIN_EMAIL"),
                rs.getBoolean("IS_REPLIED"));
    }
}

