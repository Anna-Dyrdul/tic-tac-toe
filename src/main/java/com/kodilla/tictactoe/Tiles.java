package com.kodilla.tictactoe;


import java.io.Serializable;

public class Tiles implements Serializable {
    private boolean marked;
    private char mark;
    private final int positionX;
    private final int positionY;

    public Tiles(int positionX, int positionY) {
        this.positionX = positionX;
        this.positionY = positionY;
        marked = false;
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
    }

    public void markTileX() {
        mark = 'X';
        marked = true;
    }


}
