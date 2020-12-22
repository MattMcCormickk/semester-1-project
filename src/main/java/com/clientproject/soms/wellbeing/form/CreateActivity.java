package com.clientproject.soms.wellbeing.form;

import java.util.Date;

public class CreateActivity {


        private String activityName;
        private String activityDate;
        private String description;
        private String location;
        private String keywords;

        public CreateActivity(String activityName, String activityDate, String description, String location, String keywords) {
            this.activityName = activityName;
            this.activityDate = activityDate;
            this.description = description;
            this.location = location;
            this.keywords = keywords;
        }

        public String getActivityName() {
            return this.activityName;
        }

        public String getActivityDate() {
            return activityDate;
        }

        public String getDescription() {
            return description;
        }

        public String getLocation() {
            return location;
        }

        public String getKeywords() {
            return keywords;
        }
    }

