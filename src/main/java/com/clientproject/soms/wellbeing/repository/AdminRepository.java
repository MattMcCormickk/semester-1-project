package com.clientproject.soms.wellbeing.repository;

import com.clientproject.soms.wellbeing.DTO.ContactAdminDTO;
import com.clientproject.soms.wellbeing.form.ContactAdmin;
import com.clientproject.soms.wellbeing.form.ReplyFromAdmin;

import java.text.ParseException;

public interface AdminRepository {
    public Object findAllSerPro();
    boolean messageAdmin(ContactAdmin contactAdmin) throws ParseException;
    boolean adminReply(ReplyFromAdmin replyFromAdmin) throws ParseException;
    public Object findAllMessages();
    boolean deleteMessage(ContactAdminDTO contactAdminDTO);
    public ContactAdminDTO findMessageByID(int MessageID);
    //public ContactAdminDTO addReplyToDto(ReplyFromAdmin replyFromAdmin);
}

