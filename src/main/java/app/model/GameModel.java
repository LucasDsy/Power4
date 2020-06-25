package app.model;

import app.model.enums.State;

public class GameModel {
    private State currentPlayer;

    public GameModel() {
        this.currentPlayer = State.P1;
    }

    public void nextPlayer() {
        this.currentPlayer = (currentPlayer == State.P1) ? State.P2 : State.P1;
    }

    public State getCurrentPlayer() {
        return this.currentPlayer;
    }
}