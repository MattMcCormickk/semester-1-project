package com.clientproject.soms.wellbeing.controller;

import com.clientproject.soms.wellbeing.repository.ActivityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class GeneralController {

    private ActivityRepository activityRepository;

    @Autowired
    public GeneralController(ActivityRepository aRepo) {
        this.activityRepository = aRepo;
    }

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

    @RequestMapping(path="/CreateActivity", method = RequestMethod.GET)
    public ModelAndView createActivity(){
        ModelAndView mav = new ModelAndView();
        mav.addObject("allActivities", activityRepository.findAllActivity());
        mav.setViewName("CreateActivity");
        return mav;
    }

    @RequestMapping("/ServiceProviderRegistration")
    public String serviceProviderRegistration(){
        return "ServiceProviderRegistration";
    }

    @RequestMapping("/UserDataCapture")
    public String UserDataCapture(){
        return "UserDataCapture";
    }

    @RequestMapping("/UpdateProfile")
    public String UpdateProfile(){
        return "UpdateProfile";
    }

    @GetMapping("/login")
    public String displayLogin() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if(authentication == null || authentication instanceof AnonymousAuthenticationToken) {
            return "login";
        }
        return "redirect:/";
    }
}
