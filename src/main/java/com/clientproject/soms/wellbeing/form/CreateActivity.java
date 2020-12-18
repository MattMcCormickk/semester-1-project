package com.clientproject.soms.wellbeing.form;

import java.util.Date;

public class CreateActivity {

        private String activityName;
        private String Description;
        private String Location;
        private String Keywords;
        private int serviceProviderID;
        private Date date;

        public CreateActivity(String activityName, int serviceProviderID, Date date, String description, String Location, String Keywords) {
            this.activityName = activityName;
            this.Description = description;
            this.Location = Location;
            this.Keywords = Keywords;
            this.serviceProviderID = serviceProviderID;
            this.date = date;
        }

        public String getActivityName() {
            return activityName;
        }

        public String getDescription() {
            return Description;
        }

        public String getLocation() {
            return Location;
        }

        public String getKeywords() {
            return Keywords;
        }

        public int getServiceProviderID(){return serviceProviderID;}

        public Date getActivityDate(){return date;}
    }

