package com.kodilla.tictactoe;

import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class Tiles {
    private boolean marked;
    private char mark;
    private int positionX;
    private int positionY;
    private Button button;
    private ImageView imageO = new ImageView(new Image("file:src/main/resources/o.jpg"));
    private ImageView imageX = new ImageView(new Image("file:src/main/resources/x.jpg"));

    public Tiles(int positionX, int positionY, Stage windowGame) {
        this.positionX = positionX;
        this.positionY = positionY;
        button = new Button();
        button.setGraphic(new ImageView(new Image("file:src/main/resources/button.jpg")));
        handleSettingAction(windowGame);
        marked = false;
    }

    public Button getButton() {
        return button;
    }

    public boolean getMarked() {
        return marked;
    }

    public int getPositionX() {
        return positionX;
    }

    public int getPositionY() {
        return positionY;
    }

    public char getMark() {
        return mark;
    }

    public void markTileO() {
        mark = 'O';
        marked = true;
        button.setGraphic(imageO);
    }

    public void handleSettingAction(Stage windowGame) {
        button.setOnAction(event -> {
            if(!marked) {
                mark = 'X';
                marked = true;
                button.setGraphic(imageX);
                if(CheckMove.areThreeOInRow(mark)) {
                    windowGame.close();
                    Inform.endGame(true);
                }
                else {
                    ComputerMove.move();
                    if(CheckMove.areThreeOInRow('O')) {
                        windowGame.close();
                        Inform.endGame(false);
                    }
                }
            }
        });
    }
}
