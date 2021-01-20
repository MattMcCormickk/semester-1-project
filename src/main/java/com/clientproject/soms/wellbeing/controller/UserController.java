package com.clientproject.soms.wellbeing.controller;

import com.clientproject.soms.wellbeing.DTO.UserDTO;
import com.clientproject.soms.wellbeing.form.CaptureUserActivity;
import com.clientproject.soms.wellbeing.repository.UserRepository;
import com.opencsv.CSVWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.util.List;


// Important - added RestController so that SaveUserActivity method is working!!
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
    public String saveUserActivity(@RequestParam(value = "userId") String userId,
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

    @RequestMapping(path="/GetUserNameByEmail", method = RequestMethod.GET)
    public String getUserNameByEmail(@RequestParam(value = "email") String email) {
        String userName = userRepository.getUserByEmail(email).getFirstName() + " " + userRepository.getUserByEmail(email).getLastName();
        return userName;
    }


    // Route to export all the users in the table as a CSV file
    @GetMapping("/export/AllUsers")
    public void exportCSV(HttpServletResponse response) throws IOException {

        response.setContentType("text/csv");
        response.setHeader("Content-Disposition", "attachment; filename=AllUsers.csv");

        try {
            List<UserDTO> allUsers = userRepository.findAllUsers();
            CSVWriter writer = new CSVWriter(response.getWriter());

            String[] csvTitle = {"User Id", "First Name", "Last Name", "Date of Birth", "Email", "Telephone", "Address", "Postcode"};
            writer.writeNext(csvTitle);

            for (int i = 0; i < allUsers.size(); i++) {

                String[] eachUser = {String.valueOf(allUsers.get(i).getUserId()),
                        allUsers.get(i).getFirstName(),
                        allUsers.get(i).getLastName(),
                        allUsers.get(i).getDateOfBirth().toString(),
                        allUsers.get(i).getEmail(),
                        allUsers.get(i).getTelephone(),
                        allUsers.get(i).getAddress(),
                        allUsers.get(i).getPostcode()};

                writer.writeNext(eachUser);

            }
            writer.close();
            System.out.println("Successfully exported All Users as a CSV file!");

        } catch (Exception e) {
            System.out.println("Caught exception while writing the CSV file " + e.getMessage());
        }
    }

}

