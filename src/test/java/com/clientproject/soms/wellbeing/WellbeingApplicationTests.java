package com.clientproject.soms.wellbeing;
import com.clientproject.soms.wellbeing.controller.ServiceProviderController;
import com.clientproject.soms.wellbeing.repository.ServiceProviderRepository;
import org.junit.jupiter.api.Test;

import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ServiceProviderController.class)
public class WellbeingApplicationTests {

//    @Test
//    void contextLoads() {
//    }

    @Autowired
    private ServiceProviderController serviceProviderController;

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ServiceProviderRepository serviceProviderRepository;

    @Test
    public void getServiceProviderId() throws Exception {

        Mockito.when(serviceProviderRepository.findServiceProviderIDByEmail("benz@company.com")).thenReturn(42);

        String url = "/GetServiceProviderId";
        mockMvc.perform(get(url)
                .param("email", "benz@company.com"))
                .andExpect(status().isOk())
                .andExpect(content().string("42"));

    }

}
