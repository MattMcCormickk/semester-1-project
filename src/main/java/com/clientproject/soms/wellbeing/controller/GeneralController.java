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

    @RequestMapping("/CustomizableDataCapture")
    public String customizableDataCapture(){
        return "CustomizableDataCapture";
    }


}
