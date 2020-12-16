package com.clientproject.soms.wellbeing.repository;

import com.clientproject.soms.wellbeing.DTO.UserDTO;
import com.clientproject.soms.wellbeing.model.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepositoryJDBC implements UserRepository {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public UserRepositoryJDBC(JdbcTemplate template){
        jdbcTemplate = template;
    }

    @Override
    public List<UserDTO> findAllUsers() {
        return jdbcTemplate.query(
                "SELECT USER_ID, FIRST_NAME, LAST_NAME, DATE_OF_BIRTH, EMAIL, TELEPHONE, ADDRESS, POST_CODE FROM USER",
                new UserMapper());
    }
}
