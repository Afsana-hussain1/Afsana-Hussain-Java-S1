package com.company;
import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;


public class InventoryTest {

    Inventory inventory;

    @Before
    public void setUp() {
        inventory = new Inventory();
        inventory.add(new Car("Honda", "Accord", 1995, "Red", 342343));
        inventory.add(new Car("Nissan", "Altima", 1999, "Red", 12314));
        inventory.add(new Car("Nissan", "Patrol", 2004, "Red", 35453446));
    }
    @Test
    public void shouldAddElementsToList() {
        inventory.add(new Car("Nissan", "Altima", 1999, "Red", 12314));
        assertEquals(4, Inventory.getCarDB().size());
        inventory.add(new Car("BMW", "X5", 2017, "White", 23540));
        inventory.add(new Car("Ford", "Mustang", 2003, "Blue", 8000000));
        assertEquals(6, Inventory.getCarDB().size());
        inventory.add(new Car("Mercedes", "EClass", 2007, "White", 1123540));
        inventory.add(new Car("VolksWagen", "Tiguan", 2019, "Grey", 1440));
        inventory.add(new Car("Nissan", "Patrol", 2004, "Red", 35453446));
        assertEquals(9, Inventory.getCarDB().size());
    }
    public void shouldRemoveElementsFromList(){
        inventory.add(new Car("Honda", "Accord", 1995, "Red", 342343));
        inventory.add(new Car("Nissan", "Altima", 1999, "Red", 12314));
        inventory.add(new Car("BMW", "X5", 2017, "White", 23540));
        inventory.add(new Car("Ford", "Mustang", 2003, "Blue", 8000000));
        inventory.remove(new Car("Nissan", "Altima", 1999, "Red", 12314));
        inventory.remove(new Car("BMW", "X5", 2017, "White", 23540));
        inventory.remove(new Car("Ford", "Mustang", 2003, "Blue", 8000000));
        assertEquals(1, Inventory.getCarDB().size());
    }
    @Test
    public void shouldReturnListOfCarsOfCertainMake(){
        List<Car> tester = new ArrayList<>();
        tester.add(new Car("Nissan", "Altima", 1999, "Red", 12314));
        tester.add(new Car("Nissan", "Patrol", 2004, "Red", 35453446));
        assertEquals(tester, inventory.filterByMake("Nissan"));
    }
}
