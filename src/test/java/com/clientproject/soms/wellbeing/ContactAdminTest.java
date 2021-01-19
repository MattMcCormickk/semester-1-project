package com.clientproject.soms.wellbeing;

import com.clientproject.soms.wellbeing.form.ContactAdmin;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class ContactAdminTest {

    private ContactAdmin contactAdmin;

    @Test
    public void constructorTest() {
        contactAdmin = new ContactAdmin("LitterHeroes", 5, "12/12/2018", "litterheroes@charity.com", "how can I add activity metrics?", "low");
        assertThat(5, is(contactAdmin.getSerProID()));
        assertThat("LitterHeroes", is(contactAdmin.getName()));
        assertThat("litterheroes@charity.com", is(contactAdmin.getEmail()));
        assertThat("12/12/2018", is(contactAdmin.getDate()));
        assertThat("how can I add activity metrics?", is(contactAdmin.getDescription()));
        assertThat("low", is(contactAdmin.getPriority()));
    }


}
