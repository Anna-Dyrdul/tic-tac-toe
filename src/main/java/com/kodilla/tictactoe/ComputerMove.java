package com.kodilla.tictactoe;

import javafx.scene.control.Button;

import java.util.List;
import java.util.Random;

public class ComputerMove {
    private static List<Tiles> listOfTiles;
    private static int levelOfDifficulty = 1;

    public static int move() {
        if(levelOfDifficulty == 1)
            return moveLevelOne();
        else
            return moveLevelTwo();

    }

    public static int moveLevelOne() {
        Random generator = new Random();
        boolean moved = false;
        int index;

        do {
            index = generator.nextInt(9);
            if(!listOfTiles.get(index).getMarked()) {
                listOfTiles.get(index).markTileO();
                moved = true;
            }

        } while (!moved);
        return index;
    }

    public static int moveLevelTwo() {
        boolean moved = false;
        int result = 10;
        for(int i = 0; i < 9; i += 2) {
            if(!listOfTiles.get(i).getMarked()) {
                listOfTiles.get(i).markTileO();
                moved = true;
                result = i;
                break;
            }
        }
        if(!moved) {
            for(int i = 1; i < 9; i += 2) {
                if(!listOfTiles.get(i).getMarked()) {
                    listOfTiles.get(i).markTileO();
                    result = i;
                    break;
                }
            }
        }
        return result;
    }


    public static void loadDifficulty(int level) {
        levelOfDifficulty = level;
    }

    public static void loadList(List<Tiles> tilesList) {
        listOfTiles = tilesList;
    }
}
