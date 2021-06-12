package com.kodilla.tictactoe;

import java.util.List;

public class ComputerMove {
    private static List<Tiles> listOfTiles;

    public static void move() {
        for(Tiles tiles : listOfTiles) {
            if(!tiles.getMarked()) {
                tiles.markTileO();
                break;
            }
        }
    }

    public static void loadList(List<Tiles> tilesList) {
        listOfTiles = tilesList;
    }
}
