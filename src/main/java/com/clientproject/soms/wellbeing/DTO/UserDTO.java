package com.clientproject.soms.wellbeing.DTO;

import java.util.Date;

public class UserDTO {

    private int userId;
    private String firstName;
    private String lastName;
    private Date dateOfBirth;
    private String email;
    private String telephone;
    private String address;
    private String postcode;

    public UserDTO(int userId, String firstName, String lastName, Date dateOfBirth, String email,
                   String telephone, String address, String postcode){
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.email = email;
        this.telephone = telephone;
        this.address = address;
        this.postcode = postcode;
    }

    public int getUserId() {
        return userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public String getEmail() {
        return email;
    }

    public String getTelephone() {
        return telephone;
    }

    public String getAddress() {
        return address;
    }

    public String getPostcode() {
        return postcode;
    }
}
