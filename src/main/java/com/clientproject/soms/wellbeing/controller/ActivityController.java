package com.clientproject.soms.wellbeing.controller;

import com.clientproject.soms.wellbeing.repository.ActivityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ActivityController {

    private ActivityRepository activityRepository;

    @Autowired
    public ActivityController(ActivityRepository aRepo) {
        this.activityRepository = aRepo;
    }

    @GetMapping("ActivityDataCaptureList")
    public ModelAndView queryAllActivity(){
        ModelAndView mav = new ModelAndView();
        mav.addObject("allActivity",activityRepository.findAllActivity());
        mav.setViewName("ActivityDataCaptureList");
        return mav;
    }

    public ModelAndView queryActivityByName(@RequestParam(value = "activityName", defaultValue = "null") String activityName){
        ModelAndView mav = new ModelAndView();
        mav.addObject(activityRepository.findActivityByActivityName(activityName));
        mav.setViewName("Dashboard");
        return mav;
    }
}
