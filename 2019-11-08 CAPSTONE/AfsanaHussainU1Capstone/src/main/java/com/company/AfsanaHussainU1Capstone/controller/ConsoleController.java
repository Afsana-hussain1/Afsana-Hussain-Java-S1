package com.company.AfsanaHussainU1Capstone.controller;


import com.company.AfsanaHussainU1Capstone.exceptions.NotFoundException;
import com.company.AfsanaHussainU1Capstone.service.ServiceLayer;
import com.company.AfsanaHussainU1Capstone.viewmodel.ConsoleViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/console")
public class ConsoleController {
    @Autowired
    ServiceLayer serviceLayer;

    @PostMapping//Another way to set the Rest API Post mapping
    @ResponseStatus(HttpStatus.CREATED)
    public ConsoleViewModel createGame(@RequestBody @Valid ConsoleViewModel console) {
        return serviceLayer.saveConsole(console);
    }

    @GetMapping("/{id}")//Another way to set the Rest API Get mapping
    @ResponseStatus(HttpStatus.OK)
    public ConsoleViewModel getConsole(@PathVariable("id") int consoleId) {
        ConsoleViewModel consoleViewModel = serviceLayer.findConsolebyId(consoleId);
        if (consoleViewModel == null)
            throw new NotFoundException("console could not be retrieved for id " + consoleId);
        return consoleViewModel;
    }

    @DeleteMapping("/{id}")//Another way to set the Rest API Delete mapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteConsole(@PathVariable("id") int consoleId) {
        serviceLayer.deleteConsole(consoleId);
    }

    @PutMapping("/{id}")//Another way to set the Rest API Put mapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateConsole(@PathVariable("id") int consoleId, @RequestBody @Valid ConsoleViewModel consoleViewModel) {
        if (consoleViewModel.getConsoleId() == 0)
            consoleViewModel.setConsoleId(consoleId);
        if (consoleId != consoleViewModel.getConsoleId()) {
            throw new IllegalArgumentException("Customer ID on path must match the ID in the Customer object");
        }
        serviceLayer.updateConsole(consoleViewModel);
    }

}




