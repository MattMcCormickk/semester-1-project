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

    //finds all ser pro's in SERVICE_PROVIDER table
    @Override
    public List<ServiceProviderDTO> findAllSerPro() {
        return template.query(
                "select (NAME, EMAIL, TELEPHONE, ADDRESS, POST_CODE, COMP_HSE_ID) from soms_wellbeing.service_provider",
                new ServiceProviderMapper()
        );
    }

    //inserts ContactAdmin Form data into CONTACT_ADMIN table
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
                new Object[]{contactAdmin.getSerProID(), contactAdmin.getName(),   contactAdmin.getEmail(), contactAdmin.getDescription(), date, contactAdmin.getPriority()}, types);
        return rows>0;
    }

    //finds all messages from CONTACT_ADMIN table
    @Override
    public List<ContactAdminDTO> findAllMessages() {
        return template.query(
                "select MESSAGE_ID, SERV_PROV_ID, SERV_PROV_NAME, SERV_PROV_EMAIL, MESSAGE, RECEIVED_DATE, PRIORITY, REPLY_MESSAGE, REPLIED_DATE, ADMIN_NAME, IS_REPLIED from soms_wellbeing.contact_admin",
                new ContactAdminMapper()
        );
    }

    //deletes a message from CONTACT_ADMIN table based on message ID
    @Override
    public boolean deleteMessage(ContactAdminDTO contactAdminDTO){
        int messageID = contactAdminDTO.getMessageID();
        String sql = "DELETE FROM soms_wellbeing.CONTACT_ADMIN WHERE MESSAGE_ID = ?";
        Object[] args = new Object[]{messageID};
        return template.update(sql, args) == 1;
    }

    //updates CONTACT_ADMIN table with ReplyFromAdmin Form data based on MessageID
    @Override
    public boolean adminReply(ReplyFromAdmin replyFromAdmin) throws ParseException {
        int types[] = new int[] {
                Types.VARCHAR,
                Types.DATE,
                Types.VARCHAR,
                Types.BOOLEAN,
                Types.INTEGER,
                Types.INTEGER

        };

        /*  Added to convert String to Date format.
            This is needed because the activity date is being read as String from the input HTML form. */
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date date = format.parse(replyFromAdmin.getReplyDate());

        int messageID = replyFromAdmin.getMessageID();

        int rows = template.update(
                "update soms_wellbeing.CONTACT_ADMIN SET REPLY_MESSAGE = ?, REPLIED_DATE = ?, ADMIN_NAME = ?, IS_REPLIED = ?, SERV_PROV_ID = ? where MESSAGE_ID = ?",

                new Object[]{replyFromAdmin.getReplyMessage(), date, replyFromAdmin.getAdminName(), true, replyFromAdmin.getSerProID(), messageID}, types);
        return rows > 0;

    }

    //finds a message in CONTACT_ADMIN table based on messageID
    @Override
    public ContactAdminDTO findMessageByID(int messageID) {
        ContactAdminDTO contactAdminDTO=(ContactAdminDTO) template.queryForObject("Select MESSAGE_ID, SERV_PROV_ID, SERV_PROV_NAME, SERV_PROV_EMAIL, MESSAGE, " +
                        "RECEIVED_DATE, PRIORITY, REPLY_MESSAGE, REPLIED_DATE, ADMIN_NAME, IS_REPLIED from soms_wellbeing.CONTACT_ADMIN where MESSAGE_ID = ?",
                new Object[]{messageID}, new ContactAdminMapper());
        return contactAdminDTO;
    }

}