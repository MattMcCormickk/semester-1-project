package com.clientproject.soms.wellbeing.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class GeneralController {

    @RequestMapping (path="/")
    public ModelAndView home(){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("Home");
        return mav;
    }

    @RequestMapping (path="/Home")
    public ModelAndView home2(){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("Home");
        return mav;
    }

    @RequestMapping("/ActivityDataCapture")
    public String activityDataCapture(){
        return "ActivityDataCapture";
    }

    @RequestMapping("/CustomizableDataCapture")
    public String customizableDataCapture(){
        return "CustomizableDataCapture";
    }


    @RequestMapping("/Dashboard")
    public String dashboard(){
        return "Dashboard";
    }


    @RequestMapping("/ServiceProviderRegistration")
    public String serviceProviderRegistration(){
        return "ServiceProviderRegistration";
    }

    @RequestMapping("/UserDataCapture")
    public String UserDataCapture(){
        return "UserDataCapture";
    }

    @RequestMapping(path="/CreateActivity", method = RequestMethod.GET)
    public ModelAndView activityCreation(){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("CreateActivity");
        return mav;
    }
}
