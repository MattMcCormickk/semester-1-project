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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.text.ParseException;

@Controller
public class ServiceProviderController {

    private ServiceProviderRepository serviceProviderRepository;

    @Autowired
    public ServiceProviderController(ServiceProviderRepository aRepo){this.serviceProviderRepository = aRepo; }


    @RequestMapping(value="/ServiceProvider", method = RequestMethod.POST)
    public String addServiceProvider(@RequestParam(value = "name") String name,
                                     @RequestParam(value = "email") String email,
                                     @RequestParam(value = "telephone") String telephone,
                                     @RequestParam(value = "address") String address,
                                     @RequestParam(value = "postcode") String postcode,
                                     @RequestParam(value = "companiesHouseId") String companiesHouseId) throws ParseException {

        ServiceProviderDTO serviceProviderDTO = new ServiceProviderDTO(name, email, telephone, address, postcode, companiesHouseId);
        String response = "";
        if (serviceProviderRepository.addServiceProvider(serviceProviderDTO)) {
            System.out.println("added service provider");
            response = "Successfully registered the new service provider!!";
        }
        return response;
    }



//    @RequestMapping(path="/ServiceProvider", method = RequestMethod.GET)
//    public ModelAndView addServiceProvider(@Validated ServiceProviderDTO serviceProviderDTO, BindingResult br) {
//        ModelAndView mav = new ModelAndView();
//        if (br.hasErrors()) {
//            System.out.println(1);
//            mav.setViewName("Home");
//        } else {
//            System.out.println(2);
//            if (serviceProviderRepository.addServiceProvider(serviceProviderDTO)) {
//                System.out.println(3);
//                mav.setViewName("Home");
//            }else{
//                System.out.println(4);
//                mav.setViewName("Home");
//            }
//        }
//        return mav;
//    }

}
