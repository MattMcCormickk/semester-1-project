package com.clientproject.soms.wellbeing.repository;

import com.clientproject.soms.wellbeing.form.CaptureUserActivity;

import java.text.ParseException;

public interface UserRepository {

    public Object findAllUsers();
    public boolean saveUserActvityData(CaptureUserActivity captureUserActivity) throws ParseException;

}
