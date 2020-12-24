package com.clientproject.soms.wellbeing.controller;

import com.clientproject.soms.wellbeing.repository.ActivityRepository;
import com.clientproject.soms.wellbeing.repository.ReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ReportController {

    private ActivityRepository activityRepository;
    private ReportRepository reportRepository;

    @Autowired
    public ReportController(ActivityRepository aRepo, ReportRepository rRepo) {
        this.activityRepository = aRepo;
        this.reportRepository = rRepo;
    }

    @RequestMapping(value = "allActivities", method = RequestMethod.GET)
    public ModelAndView queryAllActivity(){
        ModelAndView mav = new ModelAndView();
        mav.addObject("allActivity",activityRepository.findAllActivity());
        mav.setViewName("AllActivity");
        return mav;
    }

    @RequestMapping(value = "qActByID/{id}", method = RequestMethod.GET)
    public ModelAndView queryActivityDataById(@PathVariable("id") int id){
        System.out.println(id);
        ModelAndView mav = new ModelAndView();
        mav.addObject("activityData",reportRepository.queryActivityByID(id));
        mav.setViewName("ActivityDetailList");
        return mav;
    }

}
