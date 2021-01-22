package com.clientproject.soms.wellbeing.DTO;

import java.sql.Date;

public class ContactAdminDTO {

    private String SerProName;
    private Date recievedDate;
    private String serProEmail;
    private String message;
    private int serProID;
    private String priority;
    private String replyMessage;
    private Date replyDate;
    private String adminName;
    private boolean isReplied;
    private int messageID;

    public ContactAdminDTO(int messageID, int  serProID, String SerProName, String serProEmail,
                           String message, Date recievedDate, String priority, String replyMessage, Date replyDate, String adminName, boolean isReplied) {
        this.SerProName = SerProName;
        this.recievedDate = recievedDate;
        this.serProEmail = serProEmail;
        this.message = message;
        this.serProID = serProID;
        this.priority = priority;
        this.recievedDate = recievedDate;
        this.replyMessage = replyMessage;
        this.isReplied = isReplied;
        this.adminName = adminName;
        this.messageID = messageID;
        this.replyDate = replyDate;
    }

    public String getPriority() {
        return priority;
    }

    public String getSerProName() {
        return SerProName;
    }

    public Date getRecievedDate() {
        return recievedDate;
    }

    public String getSerProEmail() {
        return serProEmail;
    }

    public String getMessage() {
        return message;
    }

    public int getSerProID() {
        return serProID;
    }

    public String getReplyMessage() {
        return replyMessage;
    }

    public Date getReplyDate() {
        return replyDate;
    }

    public String getAdminName() {
        return adminName;
    }

    public boolean isReplied() {
        return isReplied;
    }

    public int getMessageID() {
        return messageID;
    }

    //parameters related to inputted data from ContactAdmin and ReplyFromAdmin Forms
}


