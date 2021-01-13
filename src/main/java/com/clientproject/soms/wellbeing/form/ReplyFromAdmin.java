package com.clientproject.soms.wellbeing.form;

import java.sql.Date;

public class ReplyFromAdmin {
    private String replyMessage;
    private Date replyDate;
    private String adminEmail;
    private boolean isReplied;
    private int messageID;

    public ReplyFromAdmin(String replyMessage, Date replyDate, String adminEmail, boolean isReplied, int messageID) {
        this.replyMessage = replyMessage;
        this.replyDate = replyDate;
        this.adminEmail = adminEmail;
        this.isReplied = isReplied;
        this.messageID=messageID;
    }

}


