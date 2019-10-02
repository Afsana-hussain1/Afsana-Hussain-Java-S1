package com.company;

public class App {

    public TV createTV() {
        TV myTv = new TV("Zenith", "U2121H",83,"NBC",55, false);
        return myTv;
    }

    public Radio createRadio () {
        Radio myRadio = new Radio("Sony", "V32", 2,"WUNV",30,false);
        return myRadio;
    }

    public Microwave createMicrowave() {
        Microwave myMicrowave = new Microwave("Haier","X1200w", 45, "12:00", false);
        return  myMicrowave;

    }

    public CoffeeMaker createCoffeeMaker (){
        CoffeeMaker myCoffeeMaker = new CoffeeMaker ("Sunbeam","C12", 12, 8,true);
        return myCoffeeMaker;

    }

    public Car createCar () {
        Car myCar= new Car ("Honda", "Accord", "Sedan", "Blue","2.6L V6","CVT", -4,03.17,-25218);
        return myCar;
    }

    public ComputerMouse createComputerMouse (){
        ComputerMouse myComputerMouse = new ComputerMouse("Razer","Naga", -960, -540, new int[] {0, 0});
        return myComputerMouse;
    }

}
