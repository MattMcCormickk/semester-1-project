package com.clientproject.soms.wellbeing.form;

public class ContactAdmin {

        private String name;
        private String date;
        private String email;
        private String description;
        private String priority;

        public ContactAdmin(String name, String date, String email, String description, String priority) {
            this.name = name;
            this.date = date;
            this.email = email;
            this.description = description;
            this.priority=priority;
        }

        public String getName(){return name;}
        public String getDate() {return date;}
        public String getEmail(){return email;}
        public String getDescription(){return description;}

    public String getPriority() {
        return priority;
    }
}


