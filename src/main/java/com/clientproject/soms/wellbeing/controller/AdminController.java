package com.clientproject.soms.wellbeing.controller;

import com.clientproject.soms.wellbeing.DTO.ContactAdminDTO;
import com.clientproject.soms.wellbeing.form.ContactAdmin;
import com.clientproject.soms.wellbeing.form.ReplyFromAdmin;
import com.clientproject.soms.wellbeing.repository.ActivityRepository;
import com.clientproject.soms.wellbeing.repository.AdminRepository;
import com.clientproject.soms.wellbeing.repository.ServiceProviderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.text.ParseException;

@RestController
@Controller
public class AdminController {

    private AdminRepository adminRepo;
    private ServiceProviderRepository SPrepo;
    private ActivityRepository actRepo;

    @Autowired
    public AdminController(AdminRepository adminRepo, ServiceProviderRepository SPrepo, ActivityRepository actRepo) {
        this.adminRepo = adminRepo;
        this.SPrepo = SPrepo;
        this.actRepo = actRepo;
    }

    @RequestMapping(value = "/AdminHome", method = RequestMethod.GET)
    public ModelAndView adminPage(){
        ModelAndView mav = new ModelAndView();
        mav.addObject("allMessages", adminRepo.findAllMessages());
        mav.addObject("allSerPro", SPrepo.findAllSerPro());
        //mav.addObject("allActivity", actRepo.findAllActivity());
        //mav.addObject("allActivityBySP", actRepo.findAllActivityBySerPro();
        mav.setViewName("AdminHome");
        return mav;
    }


    @RequestMapping(path = "/AdminAmendData", method = RequestMethod.GET)
    public ModelAndView getData(@RequestParam(value = "serProID") int serProID,
                                @RequestParam(value = "serProName") String name){
        ModelAndView mav = new ModelAndView();
        mav.addObject("serProID", serProID);
        mav.addObject("serProName", name);
        mav.addObject("allActivity", actRepo.findAllActivity());
        mav.setViewName("AdminAmendData");
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
                               @RequestParam(value = "description") String description,
                               @RequestParam(value = "priority") String priority) throws ParseException {

        ContactAdmin contactAdmin = new ContactAdmin(name, date, email, description, priority);
        String response = "";
        if (adminRepo.messageAdmin(contactAdmin)) {
            System.out.println("admin contacted");
            response = "Successfully contacted admin!";
        }
        return response;

    }

    @RequestMapping(value= "/AdminReply", method = RequestMethod.POST)
    public String messageAdmin(@RequestParam(value = "name") String adminName,
                               @RequestParam(value = "messageID") int messageID,
                               @RequestParam(value = "date") String replyDate,
                               @RequestParam(value = "reply") String replyMessage) throws ParseException {

        ReplyFromAdmin replyFromAdmin = new ReplyFromAdmin(messageID, adminName, replyMessage, replyDate, true);
        String response = "";
        if (adminRepo.adminReply(replyFromAdmin)) {
            System.out.println("admin replied");
            response = "replied to service provider";
        }
        return response;

    }

    @RequestMapping(path = "/message/reply/{id}/", method = RequestMethod.GET)
    public ModelAndView sendReply(@RequestParam(value = "messageRecipient") String name,
                                  @RequestParam(value = "messageid") int messageID,
                                  @RequestParam(value = "message") String description){
        ModelAndView mav = new ModelAndView();
        mav.addObject("message", description);
        mav.addObject("messageRecipient", name);
        mav.addObject("messageid", messageID);
        mav.setViewName("AdminReply");
        return mav;
    }

    @RequestMapping(value="/message/delete/{id}", method = RequestMethod.GET)
    public ModelAndView deleteMessage(@RequestParam("messageid") int messageID) {
        ModelAndView mav = new ModelAndView();
        ContactAdminDTO contactAdminDTO = adminRepo.findMessageByID(messageID);
        mav.addObject("deletedMessage", adminRepo.deleteMessage(contactAdminDTO));
        mav.addObject("allMessages", adminRepo.findAllMessages());
        mav.addObject("allSerPro", SPrepo.findAllSerPro());
        mav.setViewName("AdminHome");
        return mav;
    }

    @RequestMapping(path= "/checkIfAdmin", method= RequestMethod.POST)
    public String checkIfAdmin(@RequestParam(value="email") String email){
        String response = "";
        if(SPrepo.checkIfServiceProviderExists(email).get(0).getCount() == 0) {
            response = "Login is successful";
        } else {
        response = "Login failed";
    }
        System.out.println(response);
        return response;
    }



}

