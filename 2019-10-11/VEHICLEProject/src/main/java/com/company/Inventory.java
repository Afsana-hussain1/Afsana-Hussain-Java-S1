package com.company;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
public class Inventory {
    private static List<Car> carDB = new ArrayList<>();
    public void addAll(List<Car> addList) {
        carDB.addAll(addList);
    }
    public void removeAll(List<Car> removeList) {
        carDB.removeAll(removeList);
    }
    public void add(Car car) {
        carDB.add(car);
    }
    public void remove(Car car) {
        carDB.remove(car);
    }
    public static List<Car> getCarDB() {
        return carDB;
    }
    public void printFullList(){
        for( int i = 0 ; i < carDB.size() ; i++){
            if(carDB.size() == 0){
                System.out.println("DataBase Empty");
                break;
            }
            System.out.println((i+1) + ".)" + carDB.get(i));
        }
    }
    public void printFullList(List<Car> carList){
        for( int i = 0 ; i < carList.size() ; i++) {
            if (carList.size() == 0) {
                System.out.println("DataBase Empty");
                break;
            }
            System.out.println((i + 1) + ".)" + carList.get(i));
        }
    }
    public List<Car> filterByMake(String make) {
        return carDB.stream().filter(c -> c.getMake().equals(make)).collect(Collectors.toList());
    }
    public List<Car> filterByMake(String make, List<Car> carList) {
        return carList.stream().filter(c -> c.getMake().equals(make)).collect(Collectors.toList());
    }
    public List<Car> filterByModel(String model) {
        return carDB.stream().filter(c -> c.getMake().equals(model)).collect(Collectors.toList());
    }
    public List<Car> filterByModel(String model, List<Car> carList) {
        return carList.stream().filter(c -> c.getMake().equals(model)).collect(Collectors.toList());
    }
    public List<Car> filterByYear(int year) {
        return carDB.stream().filter(c -> c.getYear() == year).collect(Collectors.toList());
    }
    public List<Car> filterByYear(int year, List<Car> carList) {
        return carList.stream().filter(c -> c.getYear() == year).collect(Collectors.toList());
    }
    public List<Car> filterByColor(String color) {
        return carDB.stream().filter(c -> c.getMake().equals(color)).collect(Collectors.toList());
    }
    public List<Car> filterByColor(String color, List<Car> carList) {
        return carList.stream().filter(c -> c.getMake().equals(color)).collect(Collectors.toList());
    }
    public List<Car> filterByMilesLessThanInput(int mileInput) {
        return carDB.stream().filter(c -> c.getMilesOnOdometer() < mileInput).collect(Collectors.toList());
    }
    public List<Car> filterByMilesLessThanInput(int mileInput, List<Car> carList) {
        return carList.stream().filter(c -> c.getMilesOnOdometer() < mileInput).collect(Collectors.toList());
    }
    public List<Car> sortCars(List<Car> unsortedList) {
        Comparator<Car> sorted = Comparator.comparing(Car::getMilesOnOdometer).thenComparing(Car::getMake)
                .thenComparing(Car::getModel).thenComparing(Car::getColor).thenComparing(Car::getYear);
        return unsortedList.stream().sorted(sorted).collect(Collectors.toList());
    }
    public void printList(List<Car> carList){
        for(int i = 0 ; i < carList.size() ; i++){
            if(carList.size() == 0 ){
                System.out.println("DataBase Empty!");
                break;


            }

        }
    }


}