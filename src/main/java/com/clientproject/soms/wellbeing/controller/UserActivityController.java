package com.clientproject.soms.wellbeing.controller;

import com.clientproject.soms.wellbeing.repository.ActivityRepository;
import com.clientproject.soms.wellbeing.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserActivityController {

    private ActivityRepository activityRepository;
    private UserRepository userRepository;

    @Autowired
    public UserActivityController(ActivityRepository activityRepository, UserRepository userRepository) {
        this.activityRepository = activityRepository;
        this.userRepository = userRepository;
    }

    /*  Added a new route to navigate to activity selection page after selecting a user
        The user details are passed as parameters in the GET request from the previous page. */
    @RequestMapping(path = "/CaptureActivityForUser", method = RequestMethod.GET)
//    public ModelAndView captureActivityForUser(
//            @RequestParam(value="userId") String userId,
//            @RequestParam(value="userName") String userName,
//            @RequestParam(value="userEmail") String userEmail) {
    public ModelAndView captureActivityForUser() {
        ModelAndView mav = new ModelAndView();
//        mav.addObject("userId", userId);
//        mav.addObject("userName", userName);
//        mav.addObject("userEmail", userEmail);
        mav.addObject("allActivities", activityRepository.findAllActivity());
        mav.addObject("allUsers", userRepository.findAllUsers());
        mav.setViewName("CaptureActivityForUser");
        return mav;
    }
}
