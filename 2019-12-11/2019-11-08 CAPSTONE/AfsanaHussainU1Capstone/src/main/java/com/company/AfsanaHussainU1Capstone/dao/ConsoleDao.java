package com.company.AfsanaHussainU1Capstone.dao;

import com.company.AfsanaHussainU1Capstone.models.Consoles;

import java.util.List;

public interface ConsoleDao {

    Consoles findConsoleById(int id);

    List<Consoles> findAllConsoles();

    Consoles saveConsole(Consoles consoles);

    void deleteConsoleById(int id);

    void updateConsole(Consoles consoles);



}
