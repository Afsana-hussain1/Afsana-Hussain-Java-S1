package com.company;

public class ConverterIf implements ConverterInterface {
    private int day;
    private int month;

    public String convertDay(int day) {
        if ((day == 1)) {
            return "Monday";
        }
        if (day == 2) {
            return "Tuesday";
        }
        if (day == 3) {
            return "Wednesday";
        }
        if (day == 4) {
            return "Thursday";
        }
        if (day == 5) {
            return "Friday";
        } else if (day == 6) {
            return "Saturday";
        } else if (day == 7) {
            return "Sunday";
        } else {
            return "not a valid entry";
        }
    }

        public String convertMonth(int month){
            if (month == 1) {
                return "January";
            } else if (month == 2) {
                return "Febuary";
            } else if ((month == 3)) {
                return "March";
            } else if (month == 4) {
                return "April;";
            } else if (month == 5) {
                return "May";
            } else if (month == 6) {
                return "June";
            } else if (month == 7) {
                return "July";
            } else if (month == 8) {
                return "August";
            } else if (month == 9) {
                return "September";
            } else if (month == 10) {
                return "October";
            } else if (month == 11) {
                return "November";
            } else if (month == 12) {
                return "December";
            } else return "not a valid entry";
        }
    }


