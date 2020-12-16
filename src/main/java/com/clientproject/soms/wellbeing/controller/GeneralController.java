package com.clientproject.soms.wellbeing.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class GeneralController {

    @RequestMapping(path = "/")
    public String rootRedirect() {
        return "Home";
    }

    @RequestMapping(path = "/Home")
    public String displayHome() {
        return "Home";
    }

    @RequestMapping("/ActivityDataCapture")
    public String activityDataCapture(){
        return "ActivityDataCapture";
    }

    @RequestMapping("/ActivityDataCaptureList")
    public String activityDataCaptureList(){
        return "ActivityDataCaptureList";
    }

    @RequestMapping("/CustomizableDataCapture")
    public String customizableDataCapture(){
        return "CustomizableDataCapture";
    }

    @RequestMapping("/Dashboard")
    public String dashboard(){
        return "Dashboard";
    }

    @RequestMapping("/CreateActivity")
    public String createActivity(){
        return "CreateActivity";
    }

    @RequestMapping("/ServiceProviderRegistration")
    public String serviceProviderRegistration(){
        return "ServiceProviderRegistration";
    }

    @RequestMapping("/UserDataCapture")
    public String UserDataCapture(){
        return "UserDataCapture";
    }

}
