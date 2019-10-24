package com.company.CarLotDaoAfsanaHussain.dao;

import com.company.CarLotDaoAfsanaHussain.model.Car;

import java.util.List;

public interface CarLotDao {

        Car getCar(int id);
        List<Car> getAllCars();
        Car addCar(Car car);
        void updateCar(Car car);
        void deleteCar(int id);
        List<Car> getCarsByMake(String make);
        List<Car> getCarsByColor (String color);


}
