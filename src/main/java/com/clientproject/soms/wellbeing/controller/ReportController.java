package com.clientproject.soms.wellbeing.controller;

import com.clientproject.soms.wellbeing.repository.ActivityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ReportController {

    private ActivityRepository activityRepository;

    @Autowired
    public ReportController(ActivityRepository aRepo) {
        this.activityRepository = aRepo;
    }

    @RequestMapping(value = "allActivities", method = RequestMethod.GET)
    public ModelAndView queryAllActivity(){
        ModelAndView mav = new ModelAndView();
        mav.addObject("allActivity",activityRepository.findAllActivity());
        mav.setViewName("AllActivity");
        return mav;
    }

}
