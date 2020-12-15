package com.clientproject.soms.wellbeing.form;

public class CreateActivity {

        private String activityName;
        private String activityID;
        private String Description;
        private String Location;
        private String Keywords;

        public CreateActivity(String activityName, String activityID, String Description, String Location, String Keywords) {
            this.activityName = activityName;
            this.activityID = activityID;
            this.Description = Description;
            this.Location = Location;
            this.Keywords = Keywords;
        }

        public String getActivityName() {
            return activityName;
        }

        public String getActivityID() {
            return activityID;
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

