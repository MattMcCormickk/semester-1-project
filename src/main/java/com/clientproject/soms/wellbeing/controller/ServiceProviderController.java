package com.clientproject.soms.wellbeing.controller;

import com.clientproject.soms.wellbeing.DTO.ServiceProviderDTO;
import com.clientproject.soms.wellbeing.form.CreateActivity;
import com.clientproject.soms.wellbeing.repository.ServiceProviderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.text.ParseException;

@RestController
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


    public ModelAndView queryServiceProviderByEmail(@RequestParam(value = "email", defaultValue = "null") String email){
        ModelAndView mav = new ModelAndView();
        mav.addObject(serviceProviderRepository.findServiceProviderByEmail(email));
        mav.setViewName("UpdateProfile");
        return mav;
    }



    // check if the service provider exists in the database using email id instead of name
    @RequestMapping(path = "/checkIfServiceProviderExists", method = RequestMethod.POST)
//    public String checkIfServiceProviderExists(@RequestParam(value="name") String name) {
    public String checkIfServiceProviderExists(@RequestParam(value="email") String email) {
        String response = "";
        if(serviceProviderRepository.checkIfServiceProviderExists(email).get(0).getCount() > 0) {
            System.out.println(serviceProviderRepository.checkIfServiceProviderExists(email).get(0).getCount());
            response = "Login is successful";
        } else {
            response = "Login failed";
        }
        System.out.println(response);
        return response;
    }
}
