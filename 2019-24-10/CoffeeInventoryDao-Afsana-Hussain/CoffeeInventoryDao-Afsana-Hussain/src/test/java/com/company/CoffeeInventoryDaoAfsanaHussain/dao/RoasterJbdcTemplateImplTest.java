package com.company.CoffeeInventoryDaoAfsanaHussain.dao;

import com.company.CoffeeInventoryDaoAfsanaHussain.models.Coffee;
import com.company.CoffeeInventoryDaoAfsanaHussain.models.Roaster;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class RoasterJbdcTemplateImplTest {

    @Autowired
    protected RoasterDao dao;
    @Before
    public void setUp() throws Exception {
        List<Roaster> cList = dao.getAllRoaster();
        cList.stream()
                .forEach(roaster-> dao.deleteRoaster(roaster.getId()));
    }

    @Test
    public void addGetDeleteRoaster() {
        Roaster roaster = new Roaster();
        roaster.setNote("yummy");
        roaster.setEmail("delicious@gmail.com");
        roaster.setName("useful ");
        roaster.setCity("Portland");
        roaster.setId(5);
        roaster.setPostal_code("1234");

        //Act--add the motorcycle to the DAO
        roaster= dao.addRoaster(roaster);
        //ALSO ACT -- RETRIEVE MOTOCYCLR FROM DAO

        Roaster roaster2 =dao.getRoaster(roaster.getId());

        //ASSERT- compare the orig moto obj with the one retrived from the datbase
        // make sure they are equal
        assertEquals(roaster, roaster2);

        //ACT DELETE THE MOTO FROM THE DAO
        dao.deleteRoaster(roaster.getId());
        //act retrieve moto from dao
        roaster2= dao.getRoaster(roaster.getId());
        //ASSERT -THAT MOTO IS NULL
        assertNull(roaster2);
    }

    @Test
    public void getAllRoaster() {
    }

    @Test
    public void updateRoaster() {
    }

    @Test
    public void getRoasterByType() {
    }
}