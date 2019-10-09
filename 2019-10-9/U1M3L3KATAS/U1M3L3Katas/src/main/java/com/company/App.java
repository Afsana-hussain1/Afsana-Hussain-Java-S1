package com.company;

import java.util.*;

public class App {

    public void printKeys(Map<String, String> map) {
        Set<String> keySet = map.keySet();
        for(String value :keySet){
            System.out.println(value);
        }

    }

    public void printValues(Map<String, String> map) {
        Collection<String> valueSet = map.values();
        for (String value : valueSet) {
            System.out.println(value);
        }
    }

    public void printKeysAndValues(Map<String, String> map) {
        for (Map.Entry<String, String> entry : map.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }


    public Map<String, Integer> mapFun(Map<String, Integer> map) {

        map.put("Toyota Camry", 2012);
        map.put("Chevy Camaro", 1969);
        map.put("Hyundai Genesis", 2015);
        map.put("Jeep Wrangler", 2003);
        map.put("Honda Civic", 2018);
        map.put(" Toyota Supra ", 1995);
        map.put("Pontiac GTO  ", 1964);
        map.put("Ford explorer  ", 2012);
        map.put("Smart Fortwo", 2013);

        map.remove("Jeep Wrangler");
        return map;
    }
     //returning number of entries in map

    public Map<String, List<Car>> listCars(List<Car> cars) {

        List<Car> toyotaList = new ArrayList<>();

        List<Car> fordList = new ArrayList<>();

        List<Car> hondaList = new ArrayList<>();

        for (Car car: cars) {
            if (car.getMake().equals("Toyota")) toyotaList.add(car);
            if (car.getMake().equals("Ford"))fordList.add((car));
            if (car.getMake().equals("Honda"))hondaList.add(car);
        }

        Map<String, List<Car>> map = new HashMap<>();
        map.put("Toyota",toyotaList);
        map.put("Ford",fordList);
        map.put("Honda", hondaList);
        return map;

    }









    }
