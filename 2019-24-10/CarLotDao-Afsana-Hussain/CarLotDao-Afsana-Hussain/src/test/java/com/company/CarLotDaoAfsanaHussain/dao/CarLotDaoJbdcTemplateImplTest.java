package com.company.CarLotDaoAfsanaHussain.dao;

import com.company.CarLotDaoAfsanaHussain.model.Car;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class CarLotDaoJbdcTemplateImplTest {

    @Autowired
    protected  CarLotDao dao;


    @org.junit.Before
    public void setUp() throws Exception {
        // clean out the test Database
        List<Car> cList = dao.getAllCars();
        cList.stream()
                .forEach(car -> dao.deleteCar(car.getId()));


    }

    @org.junit.Test
    public void addGetDeleteCar() {
        //Arrange -- create a new motorcycle
        Car car = new Car();
        car.setMake("Honda");
        car.setModel("Accord");
        car.setYear("2019");
        car.setColor("black");

        //Act--add the motorcycle to the DAO
        car = dao.addCar(car);
        //ALSO ACT -- RETRIEVE MOTOCYCLR FROM DAO

        Car car2 =dao.getCar(car.getId());

        //ASSERT- compare the orig moto obj with the one retrived from the datbase
        // make sure they are equal
        assertEquals(car, car2);

        //ACT DELETE THE MOTO FROM THE DAO
        dao.deleteCar(car.getId());
        //act retrieve moto from dao
        car2= dao.getCar(car.getId());
        //ASSERT -THAT MOTO IS NULL
        assertNull(car2);

    @org.junit.Test
    public void getAllCars() {
            //ARRANGE CREATE A NEW MOTOCYCLE
            Car car = new Car();
            car.setMake("Honda");
            car.setModel("ACB300");
            car.setYear("2019");
            car.setColor("RED");
            dao.addCar(car);

            dao.addCar(car);
            car = new Car();
            car.setMake("suzuki");
            car.setModel("B300");
            car.setYear("2020");
            car.setColor("blue");
            dao.addCar(car);

            //ACT GET ALL MOTOS FROM DAO
            List<Car>carList = dao.getAllCars();

            //ASSETS DOA IS EQUAL TO 2
            assertEquals(2, carList.size());
        }
    }

    @org.junit.Test
    public void getCarsByColor() {
        Car car = new Car();
        car.setMake("Honda");
        car.setModel("ACB300");
        car.setYear("2019");
        car.setColor("RED");
        dao.addCar(car);

        dao.addCar(car);
        car = new Car();
        car.setMake("suzuki");
        car.setModel("B300");
        car.setYear("2020");
        car.setColor("blue");
        dao.addCar(car);

        List<Car>blueList = dao.getCarsByColor("blue");

        assertSame(1,blueList.size());
    }

    @org.junit.Test
    public void getCarsByMake() {
        Car car = new Car();
        car.setMake("Honda");
        car.setModel("ACB300");
        car.setYear("2019");
        car.setColor("RED");
        dao.addCar(car);

        dao.addCar(car);
        car = new Car();
        car.setMake("suzuki");
        car.setModel("B300");
        car.setYear("2020");
        car.setColor("blue");
        dao.addCar(car);


        List<Car>SuzukiList = dao.getCarsByMake("Suzuki");

        assertSame(1,SuzukiList.size());
    }
}