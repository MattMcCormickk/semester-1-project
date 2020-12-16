
package com.clientproject.soms.wellbeing.controller;

import com.clientproject.soms.wellbeing.form.CreateActivity;
import com.clientproject.soms.wellbeing.repository.ActivityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ActivityController {

    private ActivityRepository activityRepo;

    @Autowired
    public ActivityController(ActivityRepository pRepo) {
        activityRepo = pRepo;
    }

    /*
    @RequestMapping(path="/Student", method = RequestMethod.GET)
    public ModelAndView search(@RequestParam(value="surname", defaultValue="null") String surnameString) {
        ModelAndView mav = new ModelAndView();
        mav.addObject(studentRepo.findStudentBySurname(surnameString));
        mav.setViewName("StudentDetails");
        return mav;
    }

     */

    @RequestMapping(path="/Activity", method = RequestMethod.POST)
    public ModelAndView addActivity(CreateActivity createActivity, BindingResult br) {
        ModelAndView mav = new ModelAndView();
        if (br.hasErrors()) {
            mav.setViewName("Home");
        } else {
            if (activityRepo.addActivity(createActivity)) {
                mav.addObject("activity", activityRepo.findAllActivities());
                mav.setViewName("redirect:/CreateActivity");
            }else{
                mav.setViewName("Home");
            }
        }
        return mav;
    }


}

