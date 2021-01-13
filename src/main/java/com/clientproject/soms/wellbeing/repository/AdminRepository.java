package com.clientproject.soms.wellbeing.repository;

import com.clientproject.soms.wellbeing.DTO.ContactAdminDTO;
import com.clientproject.soms.wellbeing.form.ContactAdmin;

import java.text.ParseException;

public interface AdminRepository {
    public Object findAllSerPro();
    boolean messageAdmin(ContactAdmin contactAdmin) throws ParseException;
    public Object findAllMessages();
    //boolean deleteMessage(ContactAdmin contactAdmin) throws ParseException;
   // public Object findMessageByID(int MessageID);
   // boolean replyToMessage(ContactAdmin contactAdmin) throws ParseException;

}

