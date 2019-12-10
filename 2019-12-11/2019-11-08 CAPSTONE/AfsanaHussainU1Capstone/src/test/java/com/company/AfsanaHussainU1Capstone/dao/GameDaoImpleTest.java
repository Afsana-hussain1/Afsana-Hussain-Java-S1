package com.company.AfsanaHussainU1Capstone.dao;

import com.company.AfsanaHussainU1Capstone.models.Games;
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
public class GameDaoImpleTest {

    @Autowired
    GameDao gameDao;

    @Before
    public void setUp() {
        gameDao.findAllGames().forEach(games -> gameDao.deleteGameById(games.getGameId()));
    }

    @Test
    public void shouldAddGetDelete() {
        Games games = new Games();
        games.setTitle("risk of rain");
        games.setEsrbRating("m");
        games.setDescription("Adventure");
        games.setPrice(new BigDecimal(39.99).setScale(2, RoundingMode.HALF_UP));
        games.setStudio("studio deen");
        games.setQuantity(3);
        games = gameDao.saveGame(games);
        assertEquals(games, gameDao.findGameById(games.getGameId()));
        gameDao.deleteGameById(games.getGameId());
        assertNull(gameDao.findGameById(games.getGameId()));


    }

    @Test
    public void shouldUpdateGame() {
        Games games = new Games();
        games.setTitle("risk of rain");
        games.setEsrbRating("m");
        games.setDescription("Adventure");
        games.setPrice( new BigDecimal(39.99).setScale(2,RoundingMode.HALF_UP));
        games.setStudio("studio deen");
        games.setQuantity(3);
        games = gameDao.saveGame(games);

        games.setQuantity(6);
        gameDao.updateGame(games);
        assertEquals(games, gameDao.findGameById(games.getGameId()));
    }

    @Test
    public void shouldGetAllGames() {
        Games games = new Games();
        games.setTitle("risk of rain");
        games.setEsrbRating("m");
        games.setDescription("Adventure");
        games.setPrice( new BigDecimal(39.99).setScale(2,RoundingMode.HALF_UP));
        games.setStudio("studio deen");
        games.setQuantity(3);
        games = gameDao.saveGame(games);

        games.setTitle("metal gear solid");
        games.setEsrbRating("m");
        games.setDescription("espionage");
        games.setPrice(new BigDecimal(69.99).setScale(2,RoundingMode.HALF_UP));
        games.setStudio("studio deen");
        games.setQuantity(2);
        games = gameDao.saveGame(games);

        assertEquals(2,gameDao.findAllGames().size());
    }
    @Test
    public void shouldSearchForGameByStudio(){
        Games games = new Games();
        games.setTitle("risk of rain");
        games.setEsrbRating("m");
        games.setDescription("Adventure");
        games.setPrice(new BigDecimal(39.99).setScale(2,RoundingMode.HALF_UP));
        games.setStudio("studio deen");
        games.setQuantity(3);
        games = gameDao.saveGame(games);

        games.setTitle("metal gear solid");
        games.setEsrbRating("m");
        games.setDescription("espionage");
        games.setPrice(new BigDecimal(69.99).setScale(2,RoundingMode.HALF_UP));
        games.setStudio("studio deen");
        games.setQuantity(2);
        games = gameDao.saveGame(games);

        assertEquals(2,gameDao.findGameByStudio("studio deen").size());
    }
    @Test
    public void shouldSearchForGameByTitle() {
        Games games = new Games();
        games.setTitle("risk of rain");
        games.setEsrbRating("m");
        games.setDescription("Adventure");
        games.setPrice(new BigDecimal(39.99).setScale(2,RoundingMode.HALF_UP));
        games.setStudio("studio deen");
        games.setQuantity(3);
        games = gameDao.saveGame(games);

        games.setTitle("metal gear solid");
        games.setEsrbRating("m");
        games.setDescription("espionage");
        games.setPrice(new BigDecimal(69.99).setScale(2,RoundingMode.HALF_UP));
        games.setStudio("studio deen");
        games.setQuantity(2);
        games = gameDao.saveGame(games);

        assertEquals(1,gameDao.findGameByTitle("risk of rain").size());
    }
        @Test

        public void shouldSearchForGameByRating(){
            Games games = new Games();
            games.setTitle("risk of rain");
            games.setEsrbRating("m");
            games.setDescription("Adventure");
            games.setPrice(new BigDecimal(39.99).setScale(2,RoundingMode.HALF_UP));
            games.setStudio("studio deen");
            games.setQuantity(3);
            games = gameDao.saveGame(games);

            games.setTitle("metal gear solid");
            games.setEsrbRating("m");
            games.setDescription("espionage");
            games.setPrice(new BigDecimal(69.99).setScale(2,RoundingMode.HALF_UP));
            games.setStudio("studio deen");
            games.setQuantity(2);
            games = gameDao.saveGame(games);
            assertEquals(2,gameDao.findGameByRating("m").size());


        }
    }

