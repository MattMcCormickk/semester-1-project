package com.clientproject.soms.wellbeing.controller;

import com.clientproject.soms.wellbeing.form.CaptureUserActivity;
import com.clientproject.soms.wellbeing.repository.UserRepository;
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
public class UserController {

    private UserRepository userRepository;

    @Autowired
    public UserController(UserRepository uRepo){
        userRepository = uRepo;
    }

    @RequestMapping(path = "/AllUsers", method = RequestMethod.GET)
    public ModelAndView search(){
        ModelAndView mav = new ModelAndView();
        mav.addObject("allUsers", userRepository.findAllUsers());
        mav.setViewName("AllUsers");
        return mav;
    }

    /*  The below route is invoked upon clicking 'Submit Activity'.
        This method saves the user activity metrics/outputs data in the database.
        Converted the below method to POST request instead of GET request.
        The browser makes an AJAX request to this method to save the user activity information in the database. */

    @RequestMapping(path="/SaveUserActivityData", method = RequestMethod.POST)
    public String saveUserActivity(@RequestParam(value="userId") String userId,
                                   @RequestParam(value = "activityId") String activityId,
                                   @RequestParam(value = "activityDate") String activityDate,
                                   @RequestParam(value = "noOfHours") String noOfHours,
                                   @RequestParam(value = "bagsOfRubbish") String bagsOfRubbish) throws ParseException {
        CaptureUserActivity captureUserActivity = new CaptureUserActivity(userId, activityId, "1", activityDate, Integer.parseInt(noOfHours), Integer.parseInt(bagsOfRubbish));
        String response = "";
        if(userRepository.saveUserActvityData(captureUserActivity)) {
            System.out.println("Saved User Activity Data");
            response = "Successfully saved the user activity data!!";
        }
        return response;
    }

}

