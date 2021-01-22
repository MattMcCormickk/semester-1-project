package com.clientproject.soms.wellbeing;

import com.clientproject.soms.wellbeing.DTO.ServiceProviderDTO;
import com.clientproject.soms.wellbeing.controller.ServiceProviderController;
import com.clientproject.soms.wellbeing.repository.ServiceProviderRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ServiceProviderController.class)
public class ServiceProviderControllerTests {

    @Autowired
    private ServiceProviderController serviceProviderController;

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ServiceProviderRepository serviceProviderRepository;

    @Test
    public void getServiceProviderName() throws Exception {

        String servProvName = "Mercedes Benz";
        String email = "benz@company.com";

        ServiceProviderDTO serviceProviderDTO = new ServiceProviderDTO(servProvName, "01111333355", "Park Lane, London", "W1A 5PQ", "20");

        Mockito.when(serviceProviderRepository.findServiceProviderByEmail("benz@company.com")).thenReturn(serviceProviderDTO);
        String url = "/GetServiceProviderName";
        mockMvc.perform(get(url)
                .param("email", "benz@company.com"))
                .andExpect(status().isOk())
        .andExpect(content().string("Mercedes Benz"));

    }
}
