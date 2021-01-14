package com.clientproject.soms.wellbeing.repository;

import com.clientproject.soms.wellbeing.DTO.ActivityDTO;
import com.clientproject.soms.wellbeing.DTO.ContactAdminDTO;
import com.clientproject.soms.wellbeing.DTO.ServiceProviderDTO;
import com.clientproject.soms.wellbeing.form.ContactAdmin;
import com.clientproject.soms.wellbeing.form.ReplyFromAdmin;
import com.clientproject.soms.wellbeing.model.ActivityMapper;
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
                "insert into CONTACT_ADMIN (SERV_PROV_ID, SERV_PROV_NAME, SERV_PROV_EMAIL, MESSAGE, RECEIVED_DATE,PRIORITY) values(?,?,?,?,?,?)",
                new Object[]{1, contactAdmin.getName(),   contactAdmin.getEmail(), contactAdmin.getDescription(), date, "Medium"}, types);
        return rows>0;
    }

    @Override
    public List<ContactAdminDTO> findAllMessages() {
        return template.query(
                "select MESSAGE_ID, SERV_PROV_ID, SERV_PROV_NAME, SERV_PROV_EMAIL, MESSAGE, RECEIVED_DATE, PRIORITY, REPLY_MESSAGE, REPLIED_DATE, ADMIN_NAME, IS_REPLIED from soms_wellbeing.contact_admin",
                new ContactAdminMapper()
        );
    }


    @Override
    public boolean deleteMessage(ContactAdminDTO contactAdminDTO) {
        String sql = "DELETE FROM CONTACT_ADMIN WHERE contactAdminDTO = ?";
        Object[] args = new Object[] {contactAdminDTO};
        return template.update(sql, args) == 1;
    }


    @Override
    public boolean adminReply(ReplyFromAdmin replyFromAdmin) throws ParseException {
        int types[] = new int[] {
                Types.VARCHAR,
                Types.DATE,
                Types.VARCHAR,
                Types.BOOLEAN,
                Types.INTEGER

        };

        /*  Added to convert String to Date format.
            This is needed because the activity date is being read as String from the input HTML form. */
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date date = format.parse(replyFromAdmin.getReplyDate());

        int messageID = replyFromAdmin.getMessageID();

        int rows = template.update(
                "update soms_wellbeing.CONTACT_ADMIN SET REPLY_MESSAGE = ?, REPLIED_DATE = ?, ADMIN_NAME = ?, IS_REPLIED = ? where MESSAGE_ID = ?",

                new Object[]{replyFromAdmin.getReplyMessage(), date, replyFromAdmin.getAdminName(), true, messageID}, types);
        return rows > 0;

    }

    @Override
    public ContactAdminDTO findMessageByID(int messageID) {
        ContactAdminDTO contactAdminDTO=(ContactAdminDTO) template.queryForObject("Select SERV_PROV_NAME, RECEIVED_DATE," +
                        "SERV_PROV_EMAIL, MESSAGE, PRIORITY from soms_wellbeing.activity where CONTACT_ADMIN = ?",
                new Object[]{messageID}, new ContactAdminMapper());
        return contactAdminDTO;
    }


}