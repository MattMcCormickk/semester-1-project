package com.clientproject.soms.wellbeing.controller;

import com.clientproject.soms.wellbeing.DTO.ContactAdminDTO;
import com.clientproject.soms.wellbeing.DTO.ServiceProviderDTO;
import com.clientproject.soms.wellbeing.form.ContactAdmin;
import com.clientproject.soms.wellbeing.form.CreateActivity;
import com.clientproject.soms.wellbeing.form.ReplyFromAdmin;
import com.clientproject.soms.wellbeing.repository.ActivityRepository;
import com.clientproject.soms.wellbeing.repository.AdminRepository;
import com.clientproject.soms.wellbeing.repository.ServiceProviderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.text.ParseException;
import java.util.Map;

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

    //admin home page - displays all messages and all service providers
    @RequestMapping(value = "/AdminHome", method = RequestMethod.GET)
    public ModelAndView adminPage(){
        ModelAndView mav = new ModelAndView();
        mav.addObject("allMessages", adminRepo.findAllMessages());
        mav.addObject("allSerPro", SPrepo.findAllSerPro());
        mav.setViewName("AdminHome");
        return mav;
    }

    //loads service provider inbox page and displays all messages
    @RequestMapping(value = "/ServiceProviderInbox", method = RequestMethod.GET)
    public ModelAndView serProinbox() {
        ModelAndView mav = new ModelAndView();

        //retrieve ser pro ID through authentication
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = auth.getName();
        int serProID = SPrepo.findServiceProviderIDByEmail(currentPrincipalName);

        //displays messages linked to that particular ser pro's ID
        mav.addObject("allMessages", adminRepo.findAllMessages());
        mav.addObject("thisSerPro", serProID);
        System.out.println(currentPrincipalName);
        mav.setViewName("ServiceProviderInbox");
        return mav;
    }


    //Admin Amend Data Page - loads all activities r.e that service providers ID
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

    //Admin Edit Data Page - loads specific activity on click
    @RequestMapping(path = "/ActBySPID", method = RequestMethod.GET)
    public ModelAndView editActivityData(@RequestParam(value = "activityID") String activityID,
                                         @RequestParam(value = "activityName") String activityName,
                                         @RequestParam(value = "date") String activityDate,
                                         @RequestParam(value = "location") String location,
                                         @RequestParam(value = "description") String description) {
        ModelAndView mav = new ModelAndView();
        mav.addObject("activityID", activityID);
        mav.addObject("activityName", activityName);
        mav.addObject("activityDate", activityDate);
        mav.addObject("location", location);
        mav.addObject("description", description);
        mav.setViewName("AdminEditData");
        return mav;
    }

    //loads contact admin page
    @RequestMapping(value="/ContactAdmin", method = RequestMethod.GET)
    public ModelAndView contactAdmin() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("ContactAdmin");
        return mav;
    }

    //contact admin page - sends message to admin
    @RequestMapping(value= "/AdminContact", method = RequestMethod.POST)
    public String messageAdmin(@RequestParam(value = "name") String name,
                               @RequestParam(value = "id") int serProID,
                               @RequestParam(value = "date") String date,
                               @RequestParam(value = "email") String email,
                               @RequestParam(value = "description") String description,
                               @RequestParam(value = "priority") String priority) throws ParseException {

        ContactAdmin contactAdmin = new ContactAdmin(name, serProID, date, email, description, priority);
        String response = "";
        if (adminRepo.messageAdmin(contactAdmin)) {
            System.out.println("admin contacted");
            response = "Successfully contacted admin!";
        }
        return response;

    }
    //submitting form on admin reply page
    @RequestMapping(value= "/AdminReply", method = RequestMethod.POST)
    public String sendtoSPinbox(@RequestParam(value = "name") String adminName,
                                @RequestParam(value = "messageID") int messageID,
                                @RequestParam(value = "date") String replyDate,
                                @RequestParam(value = "reply") String replyMessage,
                                @RequestParam(value = "serProID") int serProID) throws ParseException {

        ReplyFromAdmin replyFromAdmin = new ReplyFromAdmin(messageID, adminName, replyMessage, replyDate, true, serProID);
        String response = "";
        if (adminRepo.adminReply(replyFromAdmin)) {
            System.out.println("admin replied");
            response = "replied to service provider";
        }
        return response;

    }

    //updates activity on admin edit data page
    @RequestMapping(value= "/ChangeValues", method = RequestMethod.POST)
    public String changeActivityValues(@RequestParam(value = "name") String activityName,
                                       @RequestParam(value = "date") String activityDate,
                                       @RequestParam(value = "location") String location,
                                       @RequestParam(value = "description") String description,
                                       @RequestParam(value = "activityID") String activityID) throws ParseException {

        CreateActivity createActivity = new CreateActivity(activityName, activityDate, description, location, activityID);
        String response = "";
        if (actRepo.updateActivity(createActivity)) {
            System.out.println("updated activity");
            response = "Successfully updated the activity!!";
        }
        return response;
    }

    //reply button click on admin home page
    @RequestMapping(path = "/message/reply/{id}/", method = RequestMethod.GET)
    public ModelAndView sendReply(@RequestParam(value = "messageRecipient") String name,
                                  @RequestParam(value = "messageid") int messageID,
                                  @RequestParam(value = "message") String description,
                                  @RequestParam(value = "messageRecipientID") int serProID){
        ModelAndView mav = new ModelAndView();
        mav.addObject("message", description);
        mav.addObject("messageRecipient", name);
        mav.addObject("messageid", messageID);
        mav.addObject("messageRecipientID", serProID);
        mav.setViewName("AdminReply");
        return mav;
    }

    //delete button on service provider inbox page
    @RequestMapping(value="/SPdelete/{id}", method = RequestMethod.DELETE)
    public ModelAndView SPdeletesMessage(@PathVariable int id) {
        ModelAndView mav = new ModelAndView();
        ContactAdminDTO contactAdminDTO = adminRepo.findMessageByID(id);
        if (adminRepo.deleteMessage(contactAdminDTO)) {
            System.out.println("deleted message");
            Authentication auth = SecurityContextHolder.getContext().getAuthentication();
            String currentPrincipalName = auth.getName();
            int serProID = SPrepo.findServiceProviderIDByEmail(currentPrincipalName);

            mav.addObject("allMessages", adminRepo.findAllMessages());
            mav.addObject("thisSerPro", serProID);
            mav.setViewName("ServiceProviderInbox");
            return mav;
        }return mav;
    }

    //delete button on admin home page
    @RequestMapping(value="/Admindelete/{id}", method = RequestMethod.DELETE)
    public ModelAndView AdmindeletesMessage(@PathVariable int id) {
        ModelAndView mav = new ModelAndView();
        ContactAdminDTO contactAdminDTO = adminRepo.findMessageByID(id);
        if (adminRepo.deleteMessage(contactAdminDTO)) {
            System.out.println("deleted message");
            mav.addObject("allMessages", adminRepo.findAllMessages());
            mav.addObject("allSerPro", SPrepo.findAllSerPro());
            mav.setViewName("AdminHome");
            return mav;
        }return mav;
    }


    //login functionality for admin email
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

