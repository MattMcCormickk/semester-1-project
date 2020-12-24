package com.clientproject.soms.wellbeing.repository;

import org.springframework.stereotype.Repository;

@Repository
public class ReportRepositoryJDBC implements ReportRepository{

    @Override
    public Object queryActivityByName(String aName) {
        return null;
    }

    @Override
    public Object queryActivityByID(int aID) {
        return null;
    }
}
