package com.clientproject.soms.wellbeing.controller;

import com.clientproject.soms.wellbeing.DTO.CustomActivityDTO;
import com.clientproject.soms.wellbeing.form.ActivityData;
import com.clientproject.soms.wellbeing.form.CreateActivity;
import com.clientproject.soms.wellbeing.form.CustomizeActivity;
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

    @RequestMapping(path = "/SubmitCustomizedActivity", method = RequestMethod.POST)
    public String submitCustomizedActivity(@RequestParam(value = "activityId") String activityId,
                                    @RequestParam(value = "serviceProvId") String serviceProvId,
                                    @RequestParam(value = "custMetric1") String custMetric1,
                                    @RequestParam(value = "custMetric2") String custMetric2,
                                    @RequestParam(value = "custMetric3") String custMetric3,
                                    @RequestParam(value = "custMetric4") String custMetric4,
                                    @RequestParam(value = "custMetric5") String custMetric5,
                                    @RequestParam(value = "custMetric6") String custMetric6,
                                    @RequestParam(value = "custOutput1") String custOutput1,
                                    @RequestParam(value = "custOutput2") String custOutput2,
                                    @RequestParam(value = "custOutput3") String custOutput3,
                                    @RequestParam(value = "custOutput4") String custOutput4,
                                    @RequestParam(value = "custOutput5") String custOutput5,
                                    @RequestParam(value = "custOutput6") String custOutput6) {
        CustomizeActivity customizeActivity = new CustomizeActivity(activityId, serviceProvId, custMetric1, custMetric2, custMetric3, custMetric4, custMetric5, custMetric6, custOutput1, custOutput2, custOutput3, custOutput4, custOutput5, custOutput6);
        String response = "";
        if (activityRepository.saveCustomizedActivity(customizeActivity)) {
            System.out.println("added activity data");
            response = "Successfully customized the activity!";
        }
        return response;
    }

    @RequestMapping(path = "/getCustomizedActivity", method = RequestMethod.GET)
    public String getCustomizedActivity(@RequestParam(value = "activityId") String activityId) {
        CustomActivityDTO customActivityDTO = activityRepository.getCustomMetrics(activityId);
//        System.out.println(customActivityDTO.getCustMetric1());
        String allMetrics = customActivityDTO.getCustMetric1() + "|" + customActivityDTO.getCustMetric2() + "|" +
                            customActivityDTO.getCustMetric3() + "|" + customActivityDTO.getCustMetric4() + "|" +
                            customActivityDTO.getCustMetric5() + "|" + customActivityDTO.getCustMetric6() + "|" +
                            customActivityDTO.getCustOutput1() + "|" + customActivityDTO.getCustOutput2() + "|" +
                            customActivityDTO.getCustOutput3() + "|" + customActivityDTO.getCustOutput4() + "|" +
                            customActivityDTO.getCustOutput5() + "|" + customActivityDTO.getCustOutput6();

        return allMetrics;
    }

}
