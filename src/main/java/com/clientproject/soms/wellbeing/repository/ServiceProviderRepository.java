package com.clientproject.soms.wellbeing.repository;

import com.clientproject.soms.wellbeing.DTO.ServiceProviderDTO;

public interface ServiceProviderRepository {
    boolean addServiceProvider(ServiceProviderDTO serviceProviderDTO);
}
