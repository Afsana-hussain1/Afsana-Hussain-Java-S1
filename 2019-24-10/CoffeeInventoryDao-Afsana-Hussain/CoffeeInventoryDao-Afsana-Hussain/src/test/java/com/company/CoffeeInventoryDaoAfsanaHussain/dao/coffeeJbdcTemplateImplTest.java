package com.company.CoffeeInventoryDaoAfsanaHussain.dao;

import com.company.CoffeeInventoryDaoAfsanaHussain.models.Coffee;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest

public class coffeeJbdcTemplateImplTest {
    @Autowired

    protected CoffeeDao dao;

    @org.junit.Before
    public void setUp() throws Exception {
        List<Coffee> cList = dao.getAllCoffee();
        cList.stream()
                .forEach(coffee -> dao.deleteCoffee(coffee.getId()));
    }

    @org.junit.Test
    public void addGetDeleteCoffee() {

    Coffee coffee = new Coffee();
    coffee.setCount(1);
    coffee.setDescription("delicious");
    coffee.setName("liquid poop");
    coffee.setUnit_price(5.90);
    coffee.setType("colombian");

        //Act--add the motorcycle to the DAO
        coffee = dao.addCoffee(coffee);
        //ALSO ACT -- RETRIEVE MOTOCYCLR FROM DAO

        Coffee coffee2 =dao.getCoffee(coffee.getId());

        //ASSERT- compare the orig moto obj with the one retrived from the datbase
        // make sure they are equal
        assertEquals(coffee, coffee2);

        //ACT DELETE THE MOTO FROM THE DAO
        dao.deleteCoffee(coffee.getId());
        //act retrieve moto from dao
        coffee2= dao.getCoffee(coffee.getId());
        //ASSERT -THAT MOTO IS NULL
        assertNull(coffee2);


    }

    @org.junit.Test
    public void getAllCoffee() {
    }

    @org.junit.Test
    public void updateCoffee() {
    }

    @org.junit.Test
    public void getCoffeeByType() {


        Coffee coffee = new Coffee();
        coffee.setCount(1);
        coffee.setDescription("delicious");
        coffee.setName("liquid poop");
        coffee.setUnit_price(5.90);
        coffee.setType("colombian");

        coffee= new Coffee();
        coffee.setCount(3);
        coffee.setDescription("addictive");
        coffee.setName("brown gold ");
        coffee.setUnit_price(8.90);
        coffee.setType("arabica");


        List<Coffee>typeList = dao.getCoffeeByType(("arabica");

        assertSame(1,typeList.size());
    }
}