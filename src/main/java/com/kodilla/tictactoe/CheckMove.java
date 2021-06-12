package com.kodilla.tictactoe;

import java.util.List;

public class CheckMove {
    private static List<Tiles> listOfTiles;
    private static int roundsWhichUserWon = 0;
    private static int roundsWhichUserLost = 0;

    public static boolean areThreeOInRow(char mark) {
        int rowOne = 0;
        int rowTwo = 0;
        int rowThree = 0;
        int colOne = 0;
        int colTwo = 0;
        int colThree = 0;
        int acrossUp = 0;
        int acrossDown = 0;
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
            if(mark == 'X')
                roundsWhichUserWon++;
            else
                roundsWhichUserLost++;
            return true;
        }
        return false;
    }

    public static void loadList(List<Tiles> tilesList) {
        listOfTiles = tilesList;
    }
}
