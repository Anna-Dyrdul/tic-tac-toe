package com.kodilla.tictactoe;

import java.util.List;
import java.util.Random;

public class ComputerMove {
    private static List<Tiles> listOfTiles;
    private static int levelOfDifficulty = 1;

    public static void move() {
        if(levelOfDifficulty == 1)
            moveLevelOne();
        else
            moveLevelTwo();

    }

    public static void moveLevelOne() {
        Random generator = new Random();
        boolean moved = false;

        do {
            int index = generator.nextInt(9);
            if(!listOfTiles.get(index).getMarked()) {
                listOfTiles.get(index).markTileO();
                moved = true;
            }

        } while (!moved);
    }

    public static void moveLevelTwo() {
        boolean moved = false;
        for(int i = 0; i < 9; i += 2) {
            if(!listOfTiles.get(i).getMarked()) {
                listOfTiles.get(i).markTileO();
                moved = true;
                break;
            }
        }
        if(!moved) {
            for(int i = 1; i < 9; i += 2) {
                if(!listOfTiles.get(i).getMarked()) {
                    listOfTiles.get(i).markTileO();
                    break;
                }
            }
        }
    }


    public static void loadDifficulty(int level) {
        levelOfDifficulty = level;
    }

    public static void loadList(List<Tiles> tilesList) {
        listOfTiles = tilesList;
    }
}
