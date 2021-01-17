package com.clientproject.soms.wellbeing.form;

import java.sql.Date;

public class ReplyFromAdmin {
    private String replyMessage;
    private String replyDate;
    private boolean isReplied;
    private String adminName;
    private int messageID;
    private int serProID;


    public ReplyFromAdmin(int messageID, String adminName, String replyMessage, String replyDate,  boolean isReplied, int serProID) {
        this.replyMessage = replyMessage;
        this.replyDate = replyDate;
        this.isReplied = isReplied;
        this.adminName = adminName;
        this.messageID = messageID;
        this.serProID = serProID;
    }

    public String getReplyMessage() {
        return replyMessage;
    }

    public String getReplyDate() {
        return replyDate;
    }

    public boolean isReplied() {
        return isReplied;
    }

    public String getAdminName() {
        return adminName;
    }

    public int getMessageID() {
        return messageID;
    }

    public int getSerProID() {
        return serProID;
    }
}


