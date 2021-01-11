package com.clientproject.soms.wellbeing.repository;

public interface ReportRepository {
    public Object queryActivityByName(String aName);
    public Object queryActivityByID(int aID);
    public Object queryActivityByUserID(int uID);
}
