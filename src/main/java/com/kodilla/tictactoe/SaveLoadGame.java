package com.kodilla.tictactoe;

import java.io.*;

public class SaveLoadGame {

    private static File savedGame = new File("SavedGame.ser");

    public static void saveGame(StateOfTheGame stateOfTheGame) {
        try {
            ObjectOutputStream oos = new ObjectOutputStream (new FileOutputStream(savedGame));
            oos.writeObject(stateOfTheGame);
            oos.close();
            System.out.println("Saved!");
        } catch (Exception e) {
            System.out.println("Oh no! Something went wrong! Error:" + e);
        }
    }

    public static StateOfTheGame loadGame() {
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(savedGame));
            Object readObject = ois.readObject();
            if(savedGame.length() > 0) {
                return (StateOfTheGame) readObject;
            }
            ois.close();
            System.out.println("Load");
        } catch (Exception e) {
            System.out.println("Oh no! Something went wrong! Error:" + e);
        }

        return null;
    }
}
