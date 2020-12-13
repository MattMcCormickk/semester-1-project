package com.clientproject.soms.wellbeing.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class GeneralController {

    @RequestMapping(path = "/")
    public String rootRedirect() {
        return "Fragments";
    }
}
