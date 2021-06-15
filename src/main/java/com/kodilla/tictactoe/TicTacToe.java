package com.kodilla.tictactoe;

import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class TicTacToe implements Serializable {
    private final List<Tiles> tilesList = new ArrayList<>();
    private static GridPane grid;
    private final transient Stage windowGame = new Stage();


    public void startGame() {
        grid = new GridPane();

        CheckMove.loadList(tilesList);
        ComputerMove.loadList(tilesList);
        createButtons();

        Scene scene = new Scene(grid, 390, 370, Color.WHITE);

        windowGame.setTitle("TicTacToe");
        windowGame.setScene(scene);
        windowGame.show();

    }

    public void createButtons() {
        int k = 0;
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                tilesList.add(new Tiles(i, j, windowGame));
                grid.add(tilesList.get(k).getButton(), i, j, 1, 1);
                k++;
            }
        }
    }

    public List<Tiles> getTilesList() {
        return tilesList;
    }

}
