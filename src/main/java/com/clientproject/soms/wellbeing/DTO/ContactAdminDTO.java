package com.clientproject.soms.wellbeing.DTO;

import java.sql.Date;

public class ContactAdminDTO {

    private String name;
    private Date date;
    private String email;
    private String description;
    private int serProID;

    public ContactAdminDTO(int serProID, String name, Date date, String email, String description) {
        this.name = name;
        this.date = date;
        this.email = email;
        this.description = description;
        this.serProID = serProID;
    }


    public String getName(){return name;}
    public Date getDate() {return date;}
    public String getEmail(){return email;}
    public String getDescription(){return description;}

}


