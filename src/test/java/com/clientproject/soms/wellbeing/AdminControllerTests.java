package com.clientproject.soms.wellbeing;

import com.clientproject.soms.wellbeing.controller.AdminController;
import com.clientproject.soms.wellbeing.form.ContactAdmin;
import com.clientproject.soms.wellbeing.repository.AdminRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.text.ParseException;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


public class AdminControllerTests {

    @Autowired
    private AdminController adminController;

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AdminRepository adminRepository;

    @Test
    public void messageAdminTest() throws Exception {

        ContactAdmin contactAdmin = new ContactAdmin("serProName", 1, "10/10/2020", "serProEmail@Email", "messageText", "low");

        Mockito.when(adminRepository.messageAdmin(contactAdmin)).thenReturn(true);
        String url = "/AdminContact";
        mockMvc.perform(get(url)
                .param("name", "serProName")
                .param("id", String.valueOf(1))
                .param("date", "10/10/2020")
                .param("email", "serProEmail@Email")
                .param("description", "messageText")
                .param("priority", "low")
        )
                .andExpect(status().isOk())
                .andExpect(content().string("Successfully contacted admin!"));

    }

}
