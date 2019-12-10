package com.company.AfsanaHussainU1Capstone.dao;


import com.company.AfsanaHussainU1Capstone.models.Games;
import com.company.AfsanaHussainU1Capstone.models.Tshirts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


@Repository
public class GameDaoImple implements GameDao {

    private static final String FIND_GAME_BY_ID = " SELECT  * FROM game where game_id =?";
    private static final String FIND_ALL_GAMES = "SELECT * FROM game";
    private static final String FIND_GAME_BY_STUDIO = "SELECT * FROM game WHERE studio =?";
    private static final String FIND_GAME_BY_ESRB_RATING = "SELECT * FROM game WHERE esrb_rating =?";
    private static final String FIND_GAME_BY_TITLE = "SELECT *FROM game WHERE title =?";
    private static final String SAVE_GAME = "INSERT INTO game (title, esrb_rating,description, price, studio, quantity) VALUES(?,?,?,?,?,?)";
    private static final String DELETE_GAME = "DELETE FROM game WHERE game_id = ?";
    private static final String UPDATE_GAME = "UPDATE game SET title = ?, esrb_rating=?,description =?, price= ?, studio =?, quantity =?";
    private static final String SELECT_LAST_INSERT_ID = "SELECT LAST_INSERT_ID()";


    @Autowired
    private JdbcTemplate jdbcTemplate;


    @Override
    public Games findGameById(int id) {
        try {
            return jdbcTemplate.queryForObject(FIND_GAME_BY_ID, this::mapper, id);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    @Override
    public List<Games> findAllGames() {
        return jdbcTemplate.query(FIND_ALL_GAMES, this::mapper);
    }

    @Override
    public List<Games> findGameByStudio(String studio) {
        return jdbcTemplate.query(FIND_GAME_BY_STUDIO, this::mapper, studio);
    }

    @Override
    public List<Games> findGameByRating(String esrbRating) {
        return jdbcTemplate.query(FIND_GAME_BY_ESRB_RATING, this::mapper, esrbRating);
    }

    @Override
    public List<Games> findGameByTitle(String title) {
        return jdbcTemplate.query(FIND_GAME_BY_TITLE, this::mapper, title);
    }


    @Override
    public Games saveGame(Games games) {
        jdbcTemplate.update(SAVE_GAME,
                games.getTitle(),
                games.getEsrbRating(),
                games.getDescription(),
                games.getPrice(),
                games.getStudio(),
                games.getQuantity()
        );

        int id = jdbcTemplate.queryForObject(SELECT_LAST_INSERT_ID, Integer.class);
        games.setGameId(id);
        return games;
    }


    @Override
    public void deleteGameById(int id) {
        jdbcTemplate.update(DELETE_GAME, id);
    }

    @Override
    public void updateGame(Games games) {
        jdbcTemplate.update(UPDATE_GAME,
                games.getTitle(),
                games.getEsrbRating(),
                games.getDescription(),
                games.getPrice(),
                games.getStudio(),
                games.getQuantity());


         }
        // Helper Method
        private Games mapper (ResultSet rs, int rowNum) throws SQLException {
            Games games = new Games();
            games.setTitle(rs.getString("title"));
            games.setDescription(rs.getString("description"));
            games.setEsrbRating(rs.getString("esrb_rating"));
            games.setPrice(rs.getBigDecimal("price"));
            games.setStudio(rs.getString("studio"));
            games.setQuantity(rs.getInt("quantity"));

            games.setGameId(rs.getInt("game_id"));
            return games;
        }


    }



