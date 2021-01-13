package com.clientproject.soms.wellbeing.repository;

import com.clientproject.soms.wellbeing.DTO.ServiceProviderCountDTO;
import com.clientproject.soms.wellbeing.DTO.ServiceProviderDTO;

import java.util.List;

public interface ServiceProviderRepository {
    boolean addServiceProvider(ServiceProviderDTO serviceProviderDTO);
    public List<ServiceProviderCountDTO> checkIfServiceProviderExists(String name);
}
