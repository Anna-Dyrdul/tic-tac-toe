package com.kodilla.tictactoe;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CheckMove {
    private static List<Tiles> listOfTiles;
    private static int roundsWhichUserWon = 0;
    private static int roundsWhichUserLost = 0;
    private static int howManyMarked = 0;
    private static int difficulty = 1;
    private static Map<LocalDate, String> map = new HashMap<>();

    public static boolean areThreeInRow(char mark) {
        howManyMarked++;
        int rowOne , rowTwo, rowThree, colOne, colTwo, colThree, acrossUp, acrossDown;
        rowOne = rowTwo = rowThree = colOne = colTwo = colThree = acrossUp = acrossDown = 0;
        for(Tiles tile : listOfTiles) {
            if(tile.getMark() == mark) {
                if((tile.getPositionX() == 1 && tile.getPositionY() == 1) || (tile.getPositionX() == 2 && tile.getPositionY() == 0) || (tile.getPositionX() == 0 && tile.getPositionY() == 2))
                    acrossUp++;
                if(tile.getPositionX() == tile.getPositionY())
                    acrossDown++;
                if(tile.getPositionX() == 0)
                    rowOne++;
                if(tile.getPositionX() == 1)
                    rowTwo++;
                if(tile.getPositionX() == 2)
                    rowThree++;
                if(tile.getPositionY() == 0)
                    colOne++;
                if(tile.getPositionY() == 1)
                    colTwo++;
                if(tile.getPositionY() == 2)
                    colThree++;

            }
        }
        if(rowOne == 3 || rowTwo == 3 || rowThree == 3 || colOne == 3|| colTwo == 3 || colThree == 3 || acrossUp == 3 || acrossDown ==3) {
            if(mark == 'X') {
                roundsWhichUserWon++;
            }

            else
                roundsWhichUserLost++;
            return true;
        }
        return false;
    }

    public static void loadList(List<Tiles> tilesList) {
        listOfTiles = tilesList;
    }

    public static int howManyMovesWereMade() {
        return howManyMarked;
    }

    public static void setHowManyMarked() {
        howManyMarked = 0;
    }

    public static void setDifficulty(int level) {
        difficulty = level;
    }

    public static Map<LocalDate, String> sendMap() {
        if(roundsWhichUserWon != 0 || roundsWhichUserLost != 0)
        map.put(LocalDate.now(), "User won: " + roundsWhichUserWon
                + " | User lost: "+ roundsWhichUserLost
                + "| Level of difficulty: "+ difficulty + "\n");
        return map;
    }
}
