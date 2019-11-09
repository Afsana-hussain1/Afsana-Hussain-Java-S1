package com.company.AfsanaHussainU1Capstone.dao;

import com.company.AfsanaHussainU1Capstone.models.Tshirts;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class TshirtDaoImpleTest {
    @Autowired
    private TshirtDao tshirtDao;

    @Before
    public void setUp() {
        tshirtDao.findAllTshirts().forEach(tshirts -> tshirtDao.deleteTshirtById(tshirts.getTShirtId()));
    }


    @Test
    public void ShouldAddGetDeleteTshirt() {
        Tshirts tshirts = new Tshirts();
        tshirts.setColor("red");
        tshirts.setDescription("tight fitted");
        tshirts.setPrice(new BigDecimal(13.99).setScale(2, RoundingMode.HALF_UP));
        tshirts.setQuantity(5);
        tshirts.setSize("medium");
        tshirts = tshirtDao.saveTshirt(tshirts);
        assertEquals(tshirts, tshirtDao.findTshirtById(tshirts.getTShirtId()));
        tshirtDao.deleteTshirtById(tshirts.getTShirtId());
        assertNull(tshirtDao.findTshirtById(tshirts.getTShirtId()));

    }

    @Test
    public void shouldUpdateTshirts() {
        Tshirts tshirts = new Tshirts();
        tshirts.setColor("red");
        tshirts.setDescription("tight fitted");
        tshirts.setPrice(new BigDecimal(13.99).setScale(2,RoundingMode.HALF_UP));
        tshirts.setQuantity(5);
        tshirts.setSize("medium");
        tshirts = tshirtDao.saveTshirt(tshirts);

        tshirts.setSize("Large");
        tshirtDao.updateTshirt(tshirts);
        assertEquals(tshirts, tshirtDao.findTshirtById(tshirts.getTShirtId()));


    }

    @Test
    public void shouldGetAllTshirts() {
        Tshirts tshirts = new Tshirts();
        tshirts.setColor("red");
        tshirts.setDescription("tight fitted");
        tshirts.setPrice(new BigDecimal(13.99).setScale(2,RoundingMode.HALF_UP));
        tshirts.setQuantity(5);
        tshirts.setSize("medium");
        tshirts = tshirtDao.saveTshirt(tshirts);
        tshirts.setColor("Blue");
        tshirts.setDescription("loose fitted");
        tshirts.setPrice(new BigDecimal(12.99).setScale(2,RoundingMode.HALF_UP));
        tshirts.setQuantity(2);
        tshirts.setSize("small");
        tshirts = tshirtDao.saveTshirt(tshirts);

        assertEquals(2, tshirtDao.findAllTshirts().size());
    }

    @Test
    public void shouldGetTshirtByColor() {
        Tshirts tshirts = new Tshirts();
        tshirts.setColor("red");
        tshirts.setDescription("tight fitted");
        tshirts.setPrice( new BigDecimal(13.99).setScale(2,RoundingMode.HALF_UP));
        tshirts.setQuantity(5);
        tshirts.setSize("medium");
        tshirts = tshirtDao.saveTshirt(tshirts);


        tshirts.setColor("red");
        tshirts.setDescription("tight fitted");
        tshirts.setPrice(new BigDecimal(13.99).setScale(2,RoundingMode.HALF_UP));
        tshirts.setQuantity(5);
        tshirts.setSize("medium");
        tshirts = tshirtDao.saveTshirt(tshirts);

        assertEquals(2,tshirtDao.findTShirtByColor("red").size());

    }

    @Test
    public void shouldGetTshirtBySize() {
        Tshirts tshirts = new Tshirts();
        tshirts.setColor("blue");
        tshirts.setDescription("tight fitted");
        tshirts.setPrice(new BigDecimal(13.99).setScale(2,RoundingMode.HALF_UP));
        tshirts.setQuantity(5);
        tshirts.setSize("medium");
        tshirts = tshirtDao.saveTshirt(tshirts);


        tshirts.setColor("red");
        tshirts.setDescription("tight fitted");
        tshirts.setPrice( new BigDecimal(13.99).setScale(2,RoundingMode.HALF_UP));
        tshirts.setQuantity(5);
        tshirts.setSize("medium");
        tshirts = tshirtDao.saveTshirt(tshirts);

        assertEquals(2,tshirtDao.findTShirtBySize("medium").size());

    }


}
