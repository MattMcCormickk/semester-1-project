package com.clientproject.soms.wellbeing.controller;

import com.clientproject.soms.wellbeing.form.ContactAdmin;
import com.clientproject.soms.wellbeing.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.text.ParseException;

@RestController
@Controller
public class AdminController {

    private AdminRepository adminRepo;

    @Autowired
    public AdminController(AdminRepository adminRepo) {
        this.adminRepo = adminRepo;
    }

    @RequestMapping(value = "/AdminHome", method = RequestMethod.GET)
    public ModelAndView adminPage(){
        ModelAndView mav = new ModelAndView();
        mav.addObject("allMessages",adminRepo.findAllMessages());
        mav.setViewName("AdminHome");
        return mav;
    }

    @RequestMapping(value="/ContactAdmin", method = RequestMethod.GET)
    public ModelAndView contactAdmin() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("ContactAdmin");
        return mav;
    }

    @RequestMapping(value= "/AdminContact", method = RequestMethod.POST)
    public String messageAdmin(@RequestParam(value = "name") String name,
                               @RequestParam(value = "date") String date,
                               @RequestParam(value = "email") String email,
                               @RequestParam(value = "description") String description) throws ParseException {

    ContactAdmin contactAdmin = new ContactAdmin(name, date, email, description);
    String response = "";
    if (adminRepo.messageAdmin(contactAdmin)) {
        System.out.println("admin contacted");
        response = "Successfully contacted admin!";
    }
    return response;

    }
/*
    @RequestMapping(value="/DeleteMessage", method = RequestMethod.DELETE)
    public String deleteMessage(@RequestParam(value = "name") String name,
                                @RequestParam(value = "date") String date,
                                @RequestParam(value = "email") String email,
                                @RequestParam(value = "description") String description) throws ParseException {

        ContactAdmin contactAdmin = new ContactAdmin(name, date, email, description);
        String response = "";

        if (adminRepo.deleteMessage(contactAdmin)) {
            System.out.println("admin contacted");
            response = "deleted message!";
        }
        return response;
    }

 */

}
