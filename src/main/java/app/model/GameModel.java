package app.model;

import app.model.enums.State;

public class GameModel {
    private State currentPlayer;

    private int cols = 7;
    private int rows = 6;

    public GameModel() {
        this.currentPlayer = State.P1;
    }

    public int getNbCols() {
        return this.cols;
    }

    public int getNbRows() {
        return this.rows;
    }

    public void nextPlayer() {
        this.currentPlayer = (currentPlayer == State.P1) ? State.P2 : State.P1;
    }

    public State getCurrentPlayer() {
        return this.currentPlayer;
    }
}