package com.clientproject.soms.wellbeing;

import com.clientproject.soms.wellbeing.form.ReplyFromAdmin;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class ReplyFromAdminTest {

    private ReplyFromAdmin replyFromAdmin;

    @Test
    public void constructorTest() {
        replyFromAdmin = new ReplyFromAdmin(2, "Admin","click customize button on activity page" , "12/12/2019", true, 5);
        assertThat(5, is(replyFromAdmin.getSerProID()));
        assertThat("Admin", is(replyFromAdmin.getAdminName()));
        assertThat("click customize button on activity page", is(replyFromAdmin.getReplyMessage()));
        assertThat("12/12/2019", is(replyFromAdmin.getReplyDate()));
        assertThat(2,  is(replyFromAdmin.getMessageID()));
        assertThat(true, is(replyFromAdmin.isReplied()));
    }

}
