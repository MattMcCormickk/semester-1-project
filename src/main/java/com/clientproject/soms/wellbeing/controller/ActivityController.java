package com.clientproject.soms.wellbeing.controller;

import com.clientproject.soms.wellbeing.form.CreateActivity;
import com.clientproject.soms.wellbeing.repository.ActivityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.text.ParseException;

@Controller
public class ActivityController {

    private ActivityRepository activityRepository;

    @Autowired
    public ActivityController(ActivityRepository aRepo) {
        this.activityRepository = aRepo;
    }

    @RequestMapping(value = "ActivityData", method = RequestMethod.GET)
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

    @RequestMapping(value="/AddActivity", method = RequestMethod.GET)
    public ModelAndView addActivity(@Validated CreateActivity createActivity, BindingResult br) throws ParseException {
        ModelAndView mav = new ModelAndView();
        if (br.hasErrors()) {
            mav.setViewName("Home");
        }else {
            if (activityRepository.addActivity(createActivity)) {
                System.out.println("added activity");
                mav.addObject("allActivity", activityRepository.findAllActivity());
                mav.setViewName("ActivityDataCaptureList");
            } else {
                mav.setViewName("Home");
            }
        }
        return mav;
    }

}
