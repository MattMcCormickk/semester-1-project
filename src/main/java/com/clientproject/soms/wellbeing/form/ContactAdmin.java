package com.clientproject.soms.wellbeing.form;

public class ContactAdmin {

        private String name;
        private String date;
        private String email;
        private String description;

        public ContactAdmin(String name, String date, String email, String description) {
            this.name = name;
            this.date = date;
            this.email = email;
            this.description = description;
        }

        public String getName(){return name;}
        public String getDate() {return date;}
        public String getEmail(){return email;}
        public String getDescription(){return description;}

    }


