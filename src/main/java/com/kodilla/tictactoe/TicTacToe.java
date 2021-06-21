package com.kodilla.tictactoe;

import javafx.animation.PauseTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.util.ArrayList;
import java.util.List;

public class TicTacToe implements EventHandler<ActionEvent> {
    private List<Tiles> tilesList = new ArrayList<>();
    private final List<Button> buttonList = new ArrayList<>();
    private static GridPane grid;
    private final transient Stage windowGame = new Stage();
    private StateOfTheGame stateOfTheGame;
    private boolean continuing;
    private static String outcome = "";
    //private final ImageView imageX = new ImageView(new Image("file:src/main/resources/x.jpg"));
    //private final ImageView imageO = new ImageView(new Image("file:src/main/resources/o.jpg"));

    public void startGame(boolean continuing) {
        grid = new GridPane();

        this.continuing = continuing;

        windowGame.setOnCloseRequest(e -> {
            StateOfTheGame newStateOfTheGame = new StateOfTheGame();
            SaveLoadGame.saveGame(newStateOfTheGame);
        });

        createButtons();
        if(continuing && outcome == "")
            continueGame();
        else {
            outcome = "";
            CheckMove.loadList(tilesList);
            ComputerMove.loadList(tilesList);
        }

        Scene scene = new Scene(grid, 390, 370, Color.WHITE);

        windowGame.setTitle("TicTacToe");
        windowGame.setScene(scene);
        windowGame.show();

    }


    public void createButtons() {
        int k = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                tilesList.add(new Tiles(i,j));
                buttonList.add(new Button());
                grid.add(buttonList.get(k), i, j, 1, 1);
                //buttonList.get(k).setGraphic(new ImageView(new Image("file:src/main/resources/button.jpg")));
                buttonList.get(k).setFont(Font.font("Arial", FontWeight.BOLD, 40));
                buttonList.get(k).setPrefSize(150,150);
                buttonList.get(k).setOnAction(this);
                k++;
            }
        }
    }

    public void continueGame() {
        stateOfTheGame = SaveLoadGame.loadGame();
        CheckMove.setDifficulty(stateOfTheGame.getDifficulty());
        CheckMove.setHowManyMarked(stateOfTheGame.getHowManyMarked());
        tilesList = stateOfTheGame.getListOfTiles();
        CheckMove.setListOfTiles(tilesList);
        ComputerMove.loadList(tilesList);
        CheckMove.setRoundsWhichUserLost(stateOfTheGame.getRoundsWhichUserLost());
        CheckMove.setRoundsWhichUserWon(stateOfTheGame.getRoundsWhichUserWon());
        for(int i = 0; i<9; i++) {
            if(tilesList.get(i).getMark() == 'O')
                buttonList.get(i).setText("O");
            else if(tilesList.get(i).getMark() == 'X')
                buttonList.get(i).setText("X");
        }
    }

    @Override
    public void handle(ActionEvent event) {
        for(int i = 0; i<9; i++) {
            if(event.getSource() == buttonList.get(i)) {
                if (!tilesList.get(i).getMarked()) {
                    tilesList.get(i).markTileX();
                    //buttonList.get(i).setGraphic(imageX);
                    buttonList.get(i).setText("X");
                    if (CheckMove.areThreeInRow('X')) {
                        end("You won!");
                    } else if (CheckMove.howManyMovesWereMade() < 9) {
                        int index = ComputerMove.move();
                        tilesList.get(index).markTileO();
                        buttonList.get(index).setText("O");
                        //buttonList.get(index).setGraphic(imageO);
                        if (CheckMove.areThreeInRow('O')) {
                            end("You lost!");
                        }
                    } else {
                        end("Draw");
                    }
                }
            }
        }

    }


    public void end(String result) {
        outcome = result;
        PauseTransition delay = new PauseTransition(Duration.seconds(1));
        delay.setOnFinished(event -> windowGame.close());
        delay.play();
        CheckMove.setHowManyMarked();
        Ranking.saveMap(CheckMove.addToMap());
        Inform.endGame(result);
    }

}