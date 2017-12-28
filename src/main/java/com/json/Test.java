package com.json;

import java.util.ArrayList;

public class Test {
    private ArrayList<content> discntItems;

    public ArrayList<content> getDiscntItems() {
        return discntItems;
    }

    public void setDiscntItems(ArrayList<content> discntItems) {
        this.discntItems = discntItems;
    }

    class content{
        private String discntLeft;
        private String discntType;
        private String discntRun;

        public String getDiscntLeft() {
            return discntLeft;
        }

        public void setDiscntLeft(String discntLeft) {
            this.discntLeft = discntLeft;
        }

        public String getDiscntType() {
            return discntType;
        }

        public void setDiscntType(String discntType) {
            this.discntType = discntType;
        }

        public String getDiscntRun() {
            return discntRun;
        }

        public void setDiscntRun(String discntRun) {
            this.discntRun = discntRun;
        }
    }
}
