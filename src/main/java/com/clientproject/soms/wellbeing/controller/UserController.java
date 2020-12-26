package com.clientproject.soms.wellbeing.controller;

import com.clientproject.soms.wellbeing.form.CaptureUserActivity;
import com.clientproject.soms.wellbeing.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.text.ParseException;

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

    /*  The below route is invoked upon clicking 'Submit Activity'.
        This method saves the user activity metrics/outputs data in the database. */
    @RequestMapping(path="/SaveUserActivityData", method = RequestMethod.GET)
    public ModelAndView saveUserActivity(CaptureUserActivity captureUserActivity, BindingResult br) throws ParseException {
        ModelAndView mav = new ModelAndView();
        if(br.hasErrors()) {
            mav.setViewName("AllUsers");
        } else {
            if(userRepository.saveUserActvityData(captureUserActivity)) {
                System.out.println("Saved User Activity Data");
                mav.addObject("allUsers", userRepository.findAllUsers());
                mav.setViewName("AllUsers");
            }
        }
        return mav;
    }

}

