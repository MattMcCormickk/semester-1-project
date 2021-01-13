package com.clientproject.soms.wellbeing.controller;

import com.clientproject.soms.wellbeing.form.ActivityData;
import com.clientproject.soms.wellbeing.form.CreateActivity;
import com.clientproject.soms.wellbeing.repository.ActivityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.text.ParseException;

@RestController
@Controller
public class ActivityController {

    private ActivityRepository activityRepository;

    @Autowired
    public ActivityController(ActivityRepository aRepo) {
        this.activityRepository = aRepo;
    }

    @RequestMapping(value = "ActivityData", method = RequestMethod.GET)
    public ModelAndView queryAllActivity() {
        ModelAndView mav = new ModelAndView();
        mav.addObject("allActivity", activityRepository.findAllActivity());
        mav.setViewName("ActivityDataCaptureList");
        return mav;
    }

    public ModelAndView queryActivityByName(@RequestParam(value = "activityName", defaultValue = "null") String activityName) {
        ModelAndView mav = new ModelAndView();
        mav.addObject(activityRepository.findActivityByActivityName(activityName));
        mav.setViewName("Dashboard");
        return mav;
    }

    /*  The below route is invoked upon clicking 'Register Activity'.
        This method registers the new activity in the database.
        Converted the below method to POST request instead of GET request.
        The browser makes an AJAX request to this method to register the new activity in the database. */

    @RequestMapping(value = "/AddActivity", method = RequestMethod.POST)
    public String addActivity(@RequestParam(value = "activityName") String activityName,
                              @RequestParam(value = "activityDate") String activityDate,
                              @RequestParam(value = "location") String location,
                              @RequestParam(value = "description") String description,
                              @RequestParam(value = "keywords") String keywords) throws ParseException {

        CreateActivity createActivity = new CreateActivity(activityName, activityDate, description, location, keywords);
        String response = "";
        if (activityRepository.addActivity(createActivity)) {
            System.out.println("added activity");
            response = "Successfully registered the new activity!!";
        }
        return response;
    }

    @RequestMapping(value = "/SubmitActivityData", method = RequestMethod.POST)
    public String addActivity(@RequestParam(value = "activityID") String activityID,
                              @RequestParam(value = "activityDate") String activityDate,
                              @RequestParam(value = "duration") int noOfHours,
                              @RequestParam(value = "noOfVolunteers") int noOfVolunteers,
                              @RequestParam(value = "rubbishCollected") int bagsOfRubbish) throws ParseException {

        ActivityData activityData = new ActivityData(activityID, "1", activityDate, noOfHours, noOfVolunteers, bagsOfRubbish);
        String response = "";
        if (activityRepository.addActivityData(activityData)) {
            System.out.println("added activity data");
            response = "Successfully submitted activity data!";
        }
        return response;
    }

    @RequestMapping(path = "/CustomizeActivity", method = RequestMethod.GET)
    public ModelAndView customizeActivity(@RequestParam(value = "activityId") String activityId,
                                          @RequestParam(value = "activityName") String activityName,
                                          @RequestParam(value = "activityDate") String activityDate,
                                          @RequestParam(value = "location") String location,
                                          @RequestParam(value = "description") String description) {
        ModelAndView mav = new ModelAndView();
        mav.addObject("activityId", activityId);
        mav.addObject("activityName", activityName);
        mav.addObject("activityDate", activityDate);
        mav.addObject("location", location);
        mav.addObject("description", description);
        mav.setViewName("CustomizeActivity");
        return mav;
    }

}
