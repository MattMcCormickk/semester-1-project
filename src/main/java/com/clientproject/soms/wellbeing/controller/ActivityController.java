package com.clientproject.soms.wellbeing.controller;

import com.clientproject.soms.wellbeing.form.CreateActivity;
import com.clientproject.soms.wellbeing.repository.ActivityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ActivityController {

    private ActivityRepository activityRepo;

    @Autowired
    public ActivityController(ActivityRepository pRepo) {
        activityRepo = pRepo;
    }

    @RequestMapping(path="/CreateActivity", method = RequestMethod.POST)
    public ModelAndView addActivity(CreateActivity createActivity, BindingResult br) {
        ModelAndView mav = new ModelAndView();
        if (br.hasErrors()) {
            mav.setViewName("Home");
        } else {
            if (activityRepo.addActivity(createActivity)) {
                System.out.println("saved activity");
                /**
                 * post back to page
                 */
                //mav.addObject("activities", activityRepo.findAllStudents());
                //mav.setViewName("AllStudentDetails");
            }else{
                mav.setViewName("Home");
            }
        }
        return mav;
    }


}
