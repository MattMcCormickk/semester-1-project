package com.clientproject.soms.wellbeing.controller;

import com.clientproject.soms.wellbeing.repository.ActivityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserActivityController {

    private ActivityRepository activityRepository;

    @Autowired
    public UserActivityController(ActivityRepository activityRepository) {
        this.activityRepository = activityRepository;
    }

    @RequestMapping(path = "/CaptureActivityForUser", method = RequestMethod.GET)
    public ModelAndView captureActivityForUser(
            @RequestParam(value="userId") String userId,
            @RequestParam(value="userName") String userName,
            @RequestParam(value="userEmail") String userEmail) {
        ModelAndView mav = new ModelAndView();
        mav.addObject("userId", userId);
        mav.addObject("userName", userName);
        mav.addObject("userEmail", userEmail);
        mav.addObject("allActivities", activityRepository.findAllActivity());
        mav.setViewName("CaptureActivityForUser");
        return mav;
    }
}
