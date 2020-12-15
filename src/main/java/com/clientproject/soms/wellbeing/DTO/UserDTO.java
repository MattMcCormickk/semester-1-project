package com.clientproject.soms.wellbeing.DTO;

public class UserDTO {
    private String userID;
    private String firstname;
    private String surname;
    private String dateOfBirth;
    private String email;
    private String telephone;
    private String address;
    private String postcode;
    private ActivityDTO[] activityDTO;

    public UserDTO(String userID, String firstname, String surname, String dateOfBirth, String email,
                       String telephone, String address, String postcode, ActivityDTO[] activityDTO){
        this.userID = userID;
        this.firstname = firstname;
        this.surname = surname;
        this.dateOfBirth = dateOfBirth;
        this.email = email;
        this.telephone = telephone;
        this.address = address;
        this.postcode = postcode;
        this.activityDTO = activityDTO;
    }

    public String getUserID() {
        return userID;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getSurname() {
        return surname;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public String getEmail() {return email;}

    public String getTelephone(){ return telephone;}

    public String getAddress() {return address;}

    public String getPostcode() {return postcode;}

    public ActivityDTO[] getActivityDTO() {return activityDTO;}
}
