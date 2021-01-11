package com.clientproject.soms.wellbeing.repository;

import com.clientproject.soms.wellbeing.form.ContactAdmin;

import java.text.ParseException;

public interface AdminRepository {
    public Object findAllSerPro();
    boolean messageAdmin(ContactAdmin contactAdmin) throws ParseException;
    public Object findAllMessages();
    //boolean deleteMessage(ContactAdmin contactAdmin) throws ParseException;
}
