package com.company;

public class IceCreamFactory {
    private double costOfCream;
    private double costOfSugar;
    private double costOfLabor;
    private double costOfMachinesForProduction;
    private boolean hasCreamExpired;

    public double getCostOfCream() {
        return costOfCream;
    }

    public void setCostOfCream(double costOfCream) {
        this.costOfCream = costOfCream;
    }

    public double getCostOfSugar() {
        return costOfSugar;
    }

    public void setCostOfSugar(double costOfSugar) {
        this.costOfSugar = costOfSugar;
    }

    public double getCostOfLabor() {
        return costOfLabor;
    }

    public void setCostOfLabor(double costOfLabor) {
        this.costOfLabor = costOfLabor;
    }

    public double getCostOfMachinesForProduction() {
        return costOfMachinesForProduction;
    }

    public void setCostOfMachinesForProduction(double costOfMachinesForProduction) {
        this.costOfMachinesForProduction = costOfMachinesForProduction;
    }

    public boolean isHasCreamExpired() {
        return hasCreamExpired;
    }

    public void setHasCreamExpired(boolean hasCreamExpired) {
        this.hasCreamExpired = hasCreamExpired;
    }

    public IceCreamFactory(double costOfCream, double costOfSugar, double costOfLabor, double costOfMachinesForProduction, boolean hasCreamExpired) {
        this.costOfCream = costOfCream;
        this.costOfSugar = costOfSugar;
        this.costOfLabor = costOfLabor;
        this.costOfMachinesForProduction = costOfMachinesForProduction;
        this.hasCreamExpired = hasCreamExpired;


    }
}
