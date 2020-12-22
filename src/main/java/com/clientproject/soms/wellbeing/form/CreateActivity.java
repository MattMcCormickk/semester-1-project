package com.clientproject.soms.wellbeing.form;

import java.util.Date;

public class CreateActivity {

        private String activityName;
        private Date activityDate;
        private String Description;
        private String Location;
        private String Keywords;

        public CreateActivity(String activityName, Date activityDate, String Description, String Location, String Keywords) {
            this.activityName = activityName;
            this.activityDate = activityDate;
            this.Description = Description;
            this.Location = Location;
            this.Keywords = Keywords;
        }

        public String getActivityName() {
            return activityName;
        }

        public Date getActivityDate() {
            return activityDate;
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
    }

