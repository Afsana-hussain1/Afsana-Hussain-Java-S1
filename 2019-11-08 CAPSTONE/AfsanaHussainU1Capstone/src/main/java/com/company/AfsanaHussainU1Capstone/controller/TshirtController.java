package com.company.AfsanaHussainU1Capstone.controller;

import com.company.AfsanaHussainU1Capstone.exceptions.NotFoundException;
import com.company.AfsanaHussainU1Capstone.service.ServiceLayer;
import com.company.AfsanaHussainU1Capstone.viewmodel.TshirtViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
@RestController
@RequestMapping("/tshirt")
public class TshirtController {
    @Autowired
    ServiceLayer serviceLayer;

    @PostMapping//Another way to set the Rest API Post mapping
    @ResponseStatus(HttpStatus.CREATED)
    public TshirtViewModel createGame(@RequestBody @Valid TshirtViewModel tshirt) {
        return serviceLayer.saveTshirt(tshirt);
    }

    @GetMapping("/{id}")//Another way to set the Rest API Get mapping
    @ResponseStatus(HttpStatus.OK)
    public TshirtViewModel getTshirt(@PathVariable("id") int tshirtId) {
        TshirtViewModel tshirtViewModel = serviceLayer.findTshirtbyId(tshirtId);
        if (tshirtViewModel == null)
            throw new NotFoundException("tshirt could not be retrieved for id " + tshirtId);
        return tshirtViewModel;
    }

    @DeleteMapping("/{id}")//Another way to set the Rest API Delete mapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteTshirt(@PathVariable("id") int tshirtId) {
        serviceLayer.deleteTshirt(tshirtId);
    }

    @PutMapping("/{id}")//Another way to set the Rest API Put mapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateTshirt(@PathVariable("id") int tshirtId, @RequestBody @Valid TshirtViewModel tshirtViewModel) {
        if (tshirtViewModel.getTShirtId() == 0)
            tshirtViewModel.setTShirtId(tshirtId);
        if (tshirtId != tshirtViewModel.getTShirtId()) {
            throw new IllegalArgumentException("tshirt ID on path must match the ID ");
        }
        serviceLayer.updateTshirt(tshirtViewModel);
    }

}



