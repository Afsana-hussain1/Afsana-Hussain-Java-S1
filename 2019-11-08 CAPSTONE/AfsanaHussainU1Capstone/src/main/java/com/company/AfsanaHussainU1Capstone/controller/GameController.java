package com.company.AfsanaHussainU1Capstone.controller;

import com.company.AfsanaHussainU1Capstone.exceptions.NotFoundException;
import com.company.AfsanaHussainU1Capstone.models.Games;
import com.company.AfsanaHussainU1Capstone.service.ServiceLayer;
import com.company.AfsanaHussainU1Capstone.viewmodel.GameViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/games")
public class GameController {

    @Autowired
    ServiceLayer  serviceLayer;

        @PostMapping//Another way to set the Rest API Post mapping
        @ResponseStatus(HttpStatus.CREATED)
        public GameViewModel createGame(@RequestBody @Valid GameViewModel games) {
            return serviceLayer.saveGame(games);
        }

        @GetMapping("/{id}")//Another way to set the Rest API Get mapping
        @ResponseStatus(HttpStatus.OK)
        public GameViewModel getGame(@PathVariable("id") int gameId) {
            GameViewModel gameViewModel = serviceLayer.findGameById(gameId);
            if (gameViewModel == null)
                throw new NotFoundException("game could not be retrieved for id " + gameId);
            return gameViewModel;
        }

        @DeleteMapping("/{id}")//Another way to set the Rest API Delete mapping
        @ResponseStatus(HttpStatus.NO_CONTENT)
        public void deleteGame(@PathVariable("id") int gameId) {
            serviceLayer.deleteGameBy(gameId);
        }

        @PutMapping("/{id}")//Another way to set the Rest API Put mapping
        @ResponseStatus(HttpStatus.NO_CONTENT)
        public void updateGame(@PathVariable("id") int gameId, @RequestBody @Valid GameViewModel gameViewModel) {
            if (gameViewModel.getGameId() == 0)
                gameViewModel.setGameId(gameId);
            if (gameId != gameViewModel.getGameId()) {
                throw new IllegalArgumentException("Customer ID on path must match the ID in the Customer object");
            }
           serviceLayer.updateGame(gameViewModel);
        }

    }


