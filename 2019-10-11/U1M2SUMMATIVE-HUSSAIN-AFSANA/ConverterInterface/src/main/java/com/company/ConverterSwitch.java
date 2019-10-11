package com.company;

public class ConverterSwitch implements ConverterInterface {
    public String convertDay(int dayNum) {

        switch (dayNum) {
            case 1:
                return "Monday";
            case 2:
                return "tuesday";

            case 3:
                return "wednesday";

            case 4:
                return "thursday";
            case 5:
                return "friday";
            case 6:
                return "Saturday";
            case 7:
                return "Sunday;";
            default:
                return "you have entered and invalid choice";
        }
    }

    public String convertMonth(int monthNum) {


        switch (monthNum) {
            case 1:
                return "Jnauary";
            case 2:
                return "Febuary";

            case 3:
                return "March";

            case 4:
                return "April";
            case 5:
                return "May";
            case 6:
                return "June";
            case 7:
                return "July";
            case 8:
                return "August";
            case 9:
                return "September";
            case 10:
                return "october";
            case 11:
                return "November";
            case 12:
                return "December";
            default:
                return "you have entered invalid choice";

        }
    }
}
