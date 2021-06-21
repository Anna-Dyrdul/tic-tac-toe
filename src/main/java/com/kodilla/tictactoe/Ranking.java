package com.kodilla.tictactoe;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Ranking {
    private static final File savedHashMaps = new File("ranking.ser");


    public static void saveMap(Map<Long, String> mapToSave) {
        try {
            ObjectOutputStream oos = new ObjectOutputStream (new FileOutputStream(savedHashMaps));
            oos.writeObject(mapToSave);
            System.out.println("Map saved");
            oos.close();
        } catch (Exception e) {
            System.out.println("Oh no! Something went wrong with saving! Error:" + e);
        }
    }

    public static Map<Long, String> loadMap() {
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(savedHashMaps));
            Object readMap = ois.readObject();
            if(readMap instanceof HashMap) {
                Map<Long, String> map = new HashMap<>((HashMap) readMap);
                System.out.println("Ranking load");
                return map;
            }
            ois.close();
        } catch (Exception e) {
            System.out.println("Oh no! Something went wrong with loading! Error:" + e);
        }
        return new HashMap<>();
    }


}
