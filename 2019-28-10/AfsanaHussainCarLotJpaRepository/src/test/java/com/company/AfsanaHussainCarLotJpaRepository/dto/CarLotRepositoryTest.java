package com.company.AfsanaHussainCarLotJpaRepository.dto;

import com.company.AfsanaHussainCarLotJpaRepository.dao.CarLotRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;


@RunWith(SpringRunner.class)
@SpringBootTest
public class CarLotRepositoryTest {

    @Autowired
    CarLotRepository carLotRepository;

    @Test
    public void createTest() {
        carLotRepository.deleteAll();

        Car car = new Car();
        car.setColor("Blue");
        car.setMake("Honda");
        car.setModel("Accord");
        car.setYear("2012");
        carLotRepository.save(car);

        List<Car> carList = carLotRepository.findAll();
        assertEquals(1, carList.size());
    }

    @Test
    public void deleteTest() {
        carLotRepository.deleteAll();

        Car car = new Car();
        car.setColor("Blue");
        car.setMake("Honda");
        car.setModel("Accord");
        car.setYear("2012");
        carLotRepository.save(car);

        Car car2 = new Car();
        car.setColor("green");
        car.setMake("suzuki");
        car.setModel("b500");
        car.setYear("2020");
        carLotRepository.save(car);

        carLotRepository.delete(car2);

        List<Car> carList = carLotRepository.findAll();
        assertEquals(1, carList.size());
    }

    @Test
    public void getCarsByMakeTest() {
        carLotRepository.deleteAll();

        Car car = new Car();
        car.setColor("Blue");
        car.setMake("Honda");
        car.setModel("Accord");
        car.setYear("2012");
        carLotRepository.save(car);

        Car car2 = new Car();
        car.setColor("green");
        car.setMake("suzuki");
        car.setModel("b500");
        car.setYear("2020");
        carLotRepository.save(car2);

        Car car3 = new Car();
        car.setColor("pink");
        car.setMake("Honda");
        car.setModel("Accord");
        car.setYear("2013");
        carLotRepository.save(car3);

        List<Car> hondaList = carLotRepository.findByMake("Honda");
        assertEquals(2, hondaList.size());
    }

    @Test
    public void getCarsByColorTest() {
        carLotRepository.deleteAll();

        Car car = new Car();
        car.setColor("Blue");
        car.setMake("Honda");
        car.setModel("Accord");
        car.setYear("2012");
        carLotRepository.save(car);

        Car car2 = new Car();
        car.setColor("Red");
        car.setMake("suzuki");
        car.setModel("b500");
        car.setYear("2020");
        carLotRepository.save(car2);

        Car car3 = new Car();
        car.setColor("Red");
        car.setMake("Honda");
        car.setModel("Accord");
        car.setYear("2013");
        carLotRepository.save(car3);

    List<Car> colorList = carLotRepository.findByColor("red");
    assertEquals(2, colorList.size());
    }

}