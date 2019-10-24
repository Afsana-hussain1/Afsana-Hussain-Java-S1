package com.company.CoffeeInventoryDaoAfsanaHussain.dao;

import com.company.CoffeeInventoryDaoAfsanaHussain.models.Coffee;

import java.util.List;

public interface CoffeeDao {

        Coffee getCoffee(int id);
        List<Coffee> getAllCoffee();
        Coffee addCoffee(Coffee coffee);
        void updateCoffee(Coffee coffee);
        void deleteCoffee(int id);
        List<Coffee> getCoffeeByType(String type);

    }

