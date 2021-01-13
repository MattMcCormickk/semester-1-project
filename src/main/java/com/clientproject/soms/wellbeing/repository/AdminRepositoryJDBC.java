package com.clientproject.soms.wellbeing.repository;

import com.clientproject.soms.wellbeing.DTO.ContactAdminDTO;
import com.clientproject.soms.wellbeing.DTO.ServiceProviderDTO;
import com.clientproject.soms.wellbeing.form.ContactAdmin;
import com.clientproject.soms.wellbeing.model.ContactAdminMapper;
import com.clientproject.soms.wellbeing.model.ServiceProviderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Types;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Repository
public class AdminRepositoryJDBC implements AdminRepository{
    JdbcTemplate template;

    @Autowired
    public AdminRepositoryJDBC(JdbcTemplate template) {
        this.template = template;
    }

    @Override
    public List<ServiceProviderDTO> findAllSerPro() {
        return template.query(
                "select (NAME, EMAIL, TELEPHONE, ADDRESS, POST_CODE, COMP_HSE_ID) from soms_wellbeing.service_provider",
                new ServiceProviderMapper()
        );
    }


    @Override
    public boolean messageAdmin(ContactAdmin contactAdmin) throws ParseException {
        int types[] = new int[] {
                Types.INTEGER,
                Types.VARCHAR,
                Types.VARCHAR,
                Types.VARCHAR,
                Types.DATE,
                Types.VARCHAR
        };

        /*  Added to convert String to Date format.
            This is needed because the activity date is being read as String from the input HTML form. */

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date date = format.parse(contactAdmin.getDate());

        int rows = template.update(
                "insert into CONTACT_ADMIN (SERV_PROV_ID, SERV_PROV_NAME, SERV_PROV_EMAIL, MESSAGE_TEXT, RECEIVED_DATE,PRIORITY) values(?,?,?,?,?,?)",
                new Object[]{1, contactAdmin.getName(),   contactAdmin.getEmail(), contactAdmin.getDescription(), date, "Medium"}, types);
        return rows>0;
    }

    @Override
    public List<ContactAdminDTO> findAllMessages() {
        return template.query(
                "select SERV_PROV_ID, SERV_PROV_NAME, MESSAGE_DATE, SERV_PROV_EMAIL, MESSAGE_TEXT) from soms_wellbeing.contact_admin",
                new ContactAdminMapper()
        );
    }

    /*
    @Override
    public boolean deleteMessage(ContactAdmin contactAdmin) throws ParseException{
        String sql = "DELETE FROM CONTACT_ADMIN WHERE contactAdmin = ?";
        Object[] args = new Object[] {contactAdmin};
        return template.update(sql, args) == 1;
    }

     */
}
