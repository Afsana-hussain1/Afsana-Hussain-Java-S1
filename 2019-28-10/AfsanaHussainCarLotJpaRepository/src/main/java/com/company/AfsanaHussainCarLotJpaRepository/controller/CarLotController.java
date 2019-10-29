package com.company.AfsanaHussainCarLotJpaRepository.controller;


import com.company.AfsanaHussainCarLotJpaRepository.dao.CarLotRepository;
import com.company.AfsanaHussainCarLotJpaRepository.dto.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.xml.ws.RequestWrapper;
import java.util.List;

@RestController
public class CarLotController {

    private CarLotRepository carLotRepo;

    @Autowired
    public CarLotController(CarLotRepository carLotRepo) {
        this.carLotRepo = carLotRepo;
    }

    @RequestMapping(value = "/car", method = RequestMethod.POST)
    public Car createCar(@RequestBody Car car) {
        carLotRepo.save(car);
        return car;
    }

    @RequestMapping(value = "/car/{id}", method = RequestMethod.GET)
    public Car getCarById(@PathVariable(name = "id") int id) {
        if (carLotRepo.findById(id).isPresent()) {
            return carLotRepo.findById(id).get();
        } else return null;
    }

    @RequestMapping(value = "/car", method = RequestMethod.DELETE)
    public void deleteCar(@PathVariable(name = "id") int id) {
        carLotRepo.deleteById(id);
    }

    @RequestMapping(value = "/car", method = RequestMethod.GET)
    public List<Car> getCars() {
        return carLotRepo.findAll();
    }

    @RequestMapping(value = "/cars", method = RequestMethod.GET)
    public List<Car> getAllCars() {
        return carLotRepo.findAll();
    }
}
