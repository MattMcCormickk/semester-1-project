package com.clientproject.soms.wellbeing;

import com.clientproject.soms.wellbeing.controller.ServiceProviderController;
import com.clientproject.soms.wellbeing.repository.ServiceProviderRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ServiceProviderController.class)
public class ServiceProviderControllerTests {

    @Autowired
    private ServiceProviderController serviceProviderController;

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ServiceProviderRepository serviceProviderRepository;

//    @Test
//    public void checkIfServiceProviderExists() throws Exception {
//        Mockito.when(serviceProviderRepository.checkIfServiceProviderExists("benz@company.com").get(0).getCount()).thenReturn(1);
//        String url = "/checkIfServiceProviderExists";
//        mockMvc.perform(post(url)
//                .param("email", "benz@company.com"))
//                .andExpect(status().isOk());
//
//    }
}
