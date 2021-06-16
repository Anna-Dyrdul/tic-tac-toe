package com.kodilla.tictactoe;

import javafx.animation.PauseTransition;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.Serializable;

public class Tiles implements Serializable {
    private boolean marked;
    private char mark;
    private final int positionX;
    private final int positionY;
    private  Button button; //transient???
    private final ImageView imageO = new ImageView(new Image("file:src/main/resources/o.jpg"));
    private final ImageView imageX = new ImageView(new Image("file:src/main/resources/x.jpg"));
    private final Stage windowGame;

    public Tiles(int positionX, int positionY, Stage windowGame) {
        this.positionX = positionX;
        this.positionY = positionY;
        this.windowGame = windowGame;
        button = new Button();
        button.setGraphic(new ImageView(new Image("file:src/main/resources/button.jpg")));
        handleSettingAction();
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

    public void markTileX() {
        mark = 'X';
        marked = true;
        button.setGraphic(imageX);
    }

    public void handleSettingAction() {
        button.setOnAction(event -> {
            if(!marked) {
                markTileX();
                if(CheckMove.areThreeInRow(mark)) {
                    end("You won!");
                }
                else if(CheckMove.howManyMovesWereMade() < 9){
                    ComputerMove.move();
                    if(CheckMove.areThreeInRow('O')) {
                        end("You lost!");
                    }
                }
                else {
                    end("Draw");
                }
            }
        });
    }

    public void end(String result) {
        PauseTransition delay = new PauseTransition(Duration.seconds(1));
        delay.setOnFinished( event -> windowGame.close() );
        delay.play();
        CheckMove.setHowManyMarked();
        Inform.endGame(result);
    }
}
