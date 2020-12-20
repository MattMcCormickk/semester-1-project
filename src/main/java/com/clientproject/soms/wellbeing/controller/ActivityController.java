package com.clientproject.soms.wellbeing.controller;

import com.clientproject.soms.wellbeing.form.CreateActivity;
import com.clientproject.soms.wellbeing.repository.ActivityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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


    @RequestMapping(path="/CustomizableDataCapture/", method = RequestMethod.POST)
    public ModelAndView addActivity(CreateActivity createActivity, BindingResult br) {
        ModelAndView mav = new ModelAndView();
        if (br.hasErrors()) {
            mav.setViewName("Home");
        } else {
            if (activityRepository.addActivity(createActivity)) {
                System.out.println("added activity");
                mav.addObject("all_activity", activityRepository.findAllActivity());
                mav.setViewName("CustomizableDataCapture");
            }else{
                mav.setViewName("Home");
            }
        }
        return mav;
    }


    @RequestMapping(path = "/Activities", method = RequestMethod.GET)
    public ModelAndView search(){
        ModelAndView mav = new ModelAndView();
        mav.addObject("all_activity", activityRepository.findAllActivity());
        mav.setViewName("SavedActivities");
        return mav;
    }




}
