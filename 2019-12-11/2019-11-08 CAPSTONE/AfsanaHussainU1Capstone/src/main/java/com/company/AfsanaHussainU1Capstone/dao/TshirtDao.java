package com.company.AfsanaHussainU1Capstone.dao;

import com.company.AfsanaHussainU1Capstone.models.Tshirts;

import java.util.List;

public interface TshirtDao {

    Tshirts findTshirtById(int id);

    List<Tshirts>findTShirtByColor(String color);

    List<Tshirts>findTShirtBySize(String size);

    List<Tshirts> findAllTshirts();

    Tshirts saveTshirt( Tshirts tshirts);

    void deleteTshirtById( int id);

    void updateTshirt( Tshirts tshirts);

}
