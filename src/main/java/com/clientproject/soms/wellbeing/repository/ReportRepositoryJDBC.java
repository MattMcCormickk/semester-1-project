package com.clientproject.soms.wellbeing.repository;

import com.clientproject.soms.wellbeing.DTO.ActivityDataDTO;
import com.clientproject.soms.wellbeing.model.ActivityDataMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Types;
import java.util.List;

@Repository
public class ReportRepositoryJDBC implements ReportRepository{
    JdbcTemplate jdbcTemplate;

    @Autowired
    public ReportRepositoryJDBC(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Object queryActivityByName(String aName) {
        return null;
    }

    @Override
    public List<ActivityDataDTO> queryActivityByID(int aID) {
       return jdbcTemplate.query("SELECT T3.ACTIVITY_ID,T1.NO_OF_HOURS,T3.ACTIVITY_NAME,T3.DESCRIPTION,T2.NO_BAGS_RUBBISH," +
               "T1.NO_OF_VOLUNTEERS,T1.USER_ID,T3.ACTIVITY_DATE " +
               "FROM soms_wellbeing.activity_data T1,soms_wellbeing.activity_outputs T2, soms_wellbeing.ACTIVITY T3 " +
               "WHERE T1.ACTIVITY_ID = T2.ACTIVITY_ID = T3.ACTIVITY_ID = ?",
               new Object[]{aID},new ActivityDataMapper());
    }


}
