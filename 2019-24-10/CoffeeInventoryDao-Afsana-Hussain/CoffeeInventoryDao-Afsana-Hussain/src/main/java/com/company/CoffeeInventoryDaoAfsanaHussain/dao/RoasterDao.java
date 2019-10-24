package com.company.CoffeeInventoryDaoAfsanaHussain.dao;

import com.company.CoffeeInventoryDaoAfsanaHussain.models.Coffee;
import com.company.CoffeeInventoryDaoAfsanaHussain.models.Roaster;

import java.util.List;

public interface RoasterDao {
    Coffee getRoaster(int id);
    List<Roaster> getAllRoaster();
    Coffee addRoaster(Coffee coffee);
    void updateRoaster(Coffee coffee);
    void deleteRoaster(int id);
    List<Roaster> getRoasterByType(String type);
}
