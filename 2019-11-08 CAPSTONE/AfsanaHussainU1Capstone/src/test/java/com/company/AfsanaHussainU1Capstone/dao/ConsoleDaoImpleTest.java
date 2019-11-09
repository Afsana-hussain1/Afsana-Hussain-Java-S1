package com.company.AfsanaHussainU1Capstone.dao;


import com.company.AfsanaHussainU1Capstone.models.Consoles;
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

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class ConsoleDaoImpleTest {
    @Autowired
    private ConsoleDao consoleDao;

    @Before
    public void setUp() {
        consoleDao.findAllConsoles().forEach(consoles -> consoleDao.deleteConsoleById(consoles.getConsoleId()));

    }

    @Test
    public void ShouldAddgetDeleteConsole() {
        Consoles consoles = new Consoles();
        consoles.setManufacturer("XBOX");
        consoles.setMemoryAmount("8 gb");
        consoles.setModel("xbox 4");
        consoles.setPrice(new BigDecimal(299.99).setScale(2, RoundingMode.HALF_UP));
        consoles.setProccessor("gb1");
        consoles.setQuantity(2);
        consoles = consoleDao.saveConsole(consoles);
        assertEquals(consoles,consoleDao.findConsoleById(consoles.getConsoleId()));
        consoleDao.deleteConsoleById(consoles.getConsoleId());
        assertNull(consoleDao.findConsoleById(consoles.getConsoleId()));

    }

    @Test
    public void shouldUpdateConsoleById() {
        Consoles consoles = new Consoles();
        consoles.setManufacturer("XBOX");
        consoles.setMemoryAmount("8 gb");
        consoles.setModel("xbox 4");
        consoles.setPrice(new BigDecimal(299.99).setScale(2,RoundingMode.HALF_UP));
        consoles.setProccessor("gb1");
        consoles.setQuantity(2);
        consoles = consoleDao.saveConsole(consoles);


        consoles.setPrice(new BigDecimal(399.99).setScale(2,RoundingMode.HALF_UP));
        consoleDao.updateConsole(consoles);
        assertEquals(consoles, consoleDao.findConsoleById(consoles.getConsoleId()));

    }

    @Test
    public void shouldGetAllConsoles() {
        Consoles consoles = new Consoles();
        consoles.setManufacturer("XBOX");
        consoles.setMemoryAmount("8 gb");
        consoles.setModel("gb1");
        consoles.setPrice(new BigDecimal(299.99).setScale(2,RoundingMode.HALF_UP));
        consoles.setProccessor("gb1");
        consoles.setQuantity(2);
        consoles = consoleDao.saveConsole(consoles);


        consoles.setManufacturer("XBOX");
        consoles.setMemoryAmount("8 gb");
        consoles.setModel("gb1");
        consoles.setPrice(new BigDecimal(299.99).setScale(2,RoundingMode.HALF_UP));
        consoles.setProccessor("gb1");
        consoles.setQuantity(2);
        consoles = consoleDao.saveConsole(consoles);

        assertEquals(2,consoleDao.findAllConsoles().size());
    }

}
