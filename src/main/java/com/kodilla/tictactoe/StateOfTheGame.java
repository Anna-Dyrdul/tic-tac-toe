package com.kodilla.tictactoe;

import java.io.Serializable;
import java.util.List;

public class StateOfTheGame implements Serializable {
    private List<Tiles> listOfTiles;
    private int roundsWhichUserWon;
    private int roundsWhichUserLost;
    private int howManyMarked;
    private int difficulty;

    public StateOfTheGame() {
        listOfTiles = CheckMove.getListOfTiles();
        System.out.println(listOfTiles);
        roundsWhichUserWon = CheckMove.getRoundsWhichUserWon();
        roundsWhichUserLost = CheckMove.getRoundsWhichUserLost();
        howManyMarked = CheckMove.getHowManyMarked();
        difficulty = CheckMove.getDifficulty();
    }

    public List<Tiles> getListOfTiles() {
        return listOfTiles;
    }

    public int getRoundsWhichUserWon() {
        return roundsWhichUserWon;
    }

    public int getRoundsWhichUserLost() {
        return roundsWhichUserLost;
    }

    public int getHowManyMarked() {
        return howManyMarked;
    }

    public int getDifficulty() {
        return difficulty;
    }
}
