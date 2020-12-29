package com.clientproject.soms.wellbeing.controller;

import com.clientproject.soms.wellbeing.DTO.ServiceProviderDTO;
import com.clientproject.soms.wellbeing.form.CreateActivity;
import com.clientproject.soms.wellbeing.repository.ServiceProviderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ServiceProviderController {

    private ServiceProviderRepository serviceProviderRepository;

    @Autowired
    public ServiceProviderController(ServiceProviderRepository aRepo){this.serviceProviderRepository = aRepo; }

    @RequestMapping(path="/ServiceProvider", method = RequestMethod.GET)
    public ModelAndView addServiceProvider(@Validated ServiceProviderDTO serviceProviderDTO, BindingResult br) {
        ModelAndView mav = new ModelAndView();
        if (br.hasErrors()) {
            System.out.println(1);
            mav.setViewName("Home");
        } else {
            System.out.println(2);
            if (serviceProviderRepository.addServiceProvider(serviceProviderDTO)) {
                System.out.println(3);
                mav.setViewName("Home");
            }else{
                System.out.println(4);
                mav.setViewName("Home");
            }
        }
        return mav;
    }

}
