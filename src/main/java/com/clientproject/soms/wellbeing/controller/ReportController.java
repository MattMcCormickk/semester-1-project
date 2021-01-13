package com.clientproject.soms.wellbeing.controller;

import com.clientproject.soms.wellbeing.DTO.ActivityDataDTO;
import com.clientproject.soms.wellbeing.DTO.UserDTO;
import com.clientproject.soms.wellbeing.repository.ActivityRepository;
import com.clientproject.soms.wellbeing.repository.ReportRepository;
import com.clientproject.soms.wellbeing.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class ReportController {

    private ActivityRepository activityRepository;
    private ReportRepository reportRepository;
    private UserRepository userRepository;

    @Autowired
    public ReportController(ActivityRepository aRepo, ReportRepository rRepo,UserRepository userRepository) {
        this.activityRepository = aRepo;
        this.reportRepository = rRepo;
        this.userRepository = userRepository;
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
        ModelAndView mav = new ModelAndView();
        List activityDataList = (List) reportRepository.queryActivityByID(id);
        System.out.println(activityDataList.isEmpty());
        if(activityDataList.isEmpty()){
            mav.setViewName("NullActivityDetail");
        }else {
            ActivityDataDTO activityDataDTO = (ActivityDataDTO) activityDataList.get(1);
            int sumOfBag=0;
            float sumOfHours=0;
            for(int i=0;i<activityDataList.size();i++){
                ActivityDataDTO aDataDTO = (ActivityDataDTO) activityDataList.get(i);
                sumOfBag = sumOfBag + aDataDTO.getNoBagsRubbish();
                sumOfHours = sumOfHours + aDataDTO.getHours();
            }
            mav.addObject("averageBagPerUser",sumOfBag/activityDataList.size());
            mav.addObject("averageHoursPerUser",sumOfHours/activityDataList.size());
            mav.addObject("activityID",activityDataDTO.getActivityID());
            mav.addObject("activityName",activityDataDTO.getActivityName());
            mav.addObject("activityDescription",activityDataDTO.getDescription());
            mav.addObject("activityData",activityDataList);
            mav.setViewName("ActivityDetailList");
        }
        return mav;
    }

    @RequestMapping(value = "/selectByUser",method = RequestMethod.GET)
    public ModelAndView queryAllUser(){
        ModelAndView mav = new ModelAndView();
        mav.addObject("showAllUsers",userRepository.findAllUsers());
        mav.setViewName("SelectByUser");
        return mav;
    }
    @RequestMapping(value = "qActByUserID/{id}",method = RequestMethod.GET)
    public ModelAndView queryActivityDataByUserID(@PathVariable("id")int id){
        ModelAndView mav = new ModelAndView();
        mav.addObject("queryByID",reportRepository.queryActivityByUserID(id));
        mav.setViewName("ActivityData");
        return mav;
    }
}
