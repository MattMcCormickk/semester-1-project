package com.clientproject.soms.wellbeing;

import com.clientproject.soms.wellbeing.DTO.UserDTO;
import com.clientproject.soms.wellbeing.controller.UserController;

import com.clientproject.soms.wellbeing.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebMvcTest(UserController.class)
public class UserControllerTests {

    @Autowired
    private UserController userController;

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserRepository userRepository;

    @Test
    public void getUserNameByEmail() throws Exception {

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String dateStr = "1980-05-09";
        Date dateOfBirth = format.parse(dateStr);

        UserDTO userDTO = new UserDTO(1, "Jolene", "Murray",
                dateOfBirth, "jolene.murray@user.com", "02224446666", "Park Street London", "WC1 5DV");
        Mockito.when(userRepository.getUserByEmail("jolene.murray@user.com")).thenReturn(userDTO);
        String url = "/GetUserNameByEmail";
        mockMvc.perform(get(url)
                .param("email", "jolene.murray@user.com"))
                .andExpect(status().isOk())
                .andExpect(content().string("Jolene Murray"));

    }
}
