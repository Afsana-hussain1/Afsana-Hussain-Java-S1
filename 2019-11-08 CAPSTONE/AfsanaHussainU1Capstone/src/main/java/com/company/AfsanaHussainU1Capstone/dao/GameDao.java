package com.company.AfsanaHussainU1Capstone.dao;

import com.company.AfsanaHussainU1Capstone.models.Games;

import java.util.List;

public interface GameDao {

  Games findGameById(int id);

  List<Games> findAllGames();

  List<Games> findGameByStudio(String studio);

  List<Games>findGameByRating(String esrbRating);

  List<Games>findGameByTitle(String title );

  Games saveGame( Games games);

  void deleteGameById(int id);

  void updateGame (Games games);
}
