package com.clientproject.soms.wellbeing.repository;

import com.clientproject.soms.wellbeing.DTO.ServiceProviderDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Types;

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
/*
    public boolean addActivity(CreateActivity createActivity) throws ParseException {
        int types[] = new int[] {
                Types.VARCHAR,
                Types.INTEGER,
                Types.DATE,
                Types.VARCHAR,
                Types.VARCHAR,
                Types.VARCHAR
        };

    *//*  Added to convert String to Date format.
        This is needed because the activity date is being read as String from the input HTML form. *//*

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date activityDt = format.parse(createActivity.getActivityDate());

        int rows = template.update(
                "insert into ACTIVITY (ACTIVITY_NAME,SERV_PROV_ID, ACTIVITY_DATE, DESCRIPTION,LOCATION,KEYWORDS) values(?,?,?,?,?,?)",
                new Object[]{createActivity.getActivityName(), 1, activityDt,
                        createActivity.getDescription(),createActivity.getLocation(),
                        createActivity.getKeywords()}, types);
        return rows>0;
    }*/


}
