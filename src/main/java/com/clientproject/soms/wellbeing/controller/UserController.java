package com.clientproject.soms.wellbeing.controller;

import com.clientproject.soms.wellbeing.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {

    private UserRepository userRepository;

    @Autowired
    public UserController(UserRepository uRepo){
        userRepository = uRepo;
    }

    @RequestMapping(path = "/AllUsers", method = RequestMethod.GET)
    public ModelAndView search(){
        ModelAndView mav = new ModelAndView();
        mav.addObject("allUsers", userRepository.findAllUsers());
        mav.setViewName("AllUsers");
        return mav;
    }
}
