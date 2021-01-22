package com.clientproject.soms.wellbeing.repository;

import com.clientproject.soms.wellbeing.DTO.UserDTO;
import com.clientproject.soms.wellbeing.form.CaptureUserActivity;

import java.text.ParseException;
import java.util.List;

public interface UserRepository {

//    public Object findAllUsers();
    public List<UserDTO> findAllUsers();
    public boolean saveUserActvityData(CaptureUserActivity captureUserActivity) throws ParseException;
    public UserDTO getUserByEmail(String email);
}
