package com.clientproject.soms.wellbeing.repository;

import com.clientproject.soms.wellbeing.DTO.ServiceProviderCountDTO;
import com.clientproject.soms.wellbeing.DTO.ServiceProviderDTO;
import com.clientproject.soms.wellbeing.model.ServiceProviderCountMapper;
import com.clientproject.soms.wellbeing.model.ServiceProviderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Types;
import java.util.List;

@Repository
public class ServiceProviderRepositoryJDBC implements ServiceProviderRepository {
    JdbcTemplate template;

    @Autowired
    public ServiceProviderRepositoryJDBC(JdbcTemplate template) { this.template = template; }

    @Override
    public boolean addServiceProvider(ServiceProviderDTO serviceProviderDTO) {

            int types[] = new int[] {
                    Types.VARCHAR,
                    Types.VARCHAR,
                    Types.VARCHAR,
                    Types.VARCHAR,
                    Types.VARCHAR,
                    Types.VARCHAR
            };

        int rows = template.update(
                "insert into SERVICE_PROVIDER(NAME, EMAIL,TELEPHONE,ADDRESS,POST_CODE,COMP_HSE_ID) values (?,?,?,?,?,?)",
                new Object[]{serviceProviderDTO.getName(), serviceProviderDTO.getEmail(),
                        serviceProviderDTO.getTelephone(), serviceProviderDTO.getAddress(),
                        serviceProviderDTO.getPostcode(), serviceProviderDTO.getCompaniesHouseId()},types
        ) ;
        return rows>0;
    }

    //  check if the service provider exists in the database using email id instead of name
    @Override
    public List<ServiceProviderCountDTO> checkIfServiceProviderExists(String email) {
        return template.query(
//                "SELECT COUNT(*) FROM SERVICE_PROVIDER WHERE NAME = ?",
                "SELECT COUNT(*) FROM SERVICE_PROVIDER WHERE EMAIL = ?",
                new Object[]{email}, new ServiceProviderCountMapper());
    }

    @Override
    public List<ServiceProviderDTO> findAllSerPro() {
        return template.query(
                "select SERV_PROV_ID, NAME, EMAIL,TELEPHONE,ADDRESS,POST_CODE,COMP_HSE_ID from soms_wellbeing.service_provider",
                new ServiceProviderMapper()
        );
    }

}

