package com.clientproject.soms.wellbeing.controller;

import com.clientproject.soms.wellbeing.DTO.ServiceProviderDTO;
import com.clientproject.soms.wellbeing.repository.ServiceProviderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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

        ServiceProviderDTO serviceProviderDTO = new ServiceProviderDTO(1, name, email, telephone, address, postcode, companiesHouseId);
        String response = "";
        if (serviceProviderRepository.addServiceProvider(serviceProviderDTO)) {
            System.out.println("added service provider");
            response = "Successfully registered the new service provider!!";
        }
        return response;
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


    @RequestMapping(path = "/UpdateProfile/{emailId}", method = RequestMethod.GET)
    public ModelAndView queryServiceProviderByEmail(@PathVariable("emailId") String email){
        ModelAndView mav = new ModelAndView();
        mav.addObject("ServiceProvider",serviceProviderRepository.findServiceProviderByEmail(email));
        mav.setViewName("UpdateProfile");
        return mav;
    }

    @RequestMapping(value="/UpdateInformation", method = RequestMethod.POST)
    public String updateInformation(@RequestParam(value = "name") String name,
                                    @RequestParam(value = "email") String email,
                                     @RequestParam(value = "telephone") String telephone,
                                     @RequestParam(value = "address") String address,
                                     @RequestParam(value = "postcode") String postcode,
                                     @RequestParam(value = "companiesHouseId") String companiesHouseId) throws ParseException {

        ServiceProviderDTO serviceProviderDTO = new ServiceProviderDTO(name, email, telephone, address, postcode, companiesHouseId);
        String response = "";
        if (serviceProviderRepository.updateServiceProviderByEmail(serviceProviderDTO)) {
            System.out.println("update service provider");
            response = "Successfully update the new service provider!!";
        }
        return response;
    }


}
