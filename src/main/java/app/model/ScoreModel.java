package app.model;

import app.model.enums.State;

public class ScoreModel {

    private int scoreP1;
    private int scoreP2;

    public ScoreModel() {
        this.scoreP1 = 0;
        this.scoreP2 = 0;
    }

    public void writeScore(State currentPlayer) {
         switch (currentPlayer) {
                case P1:
                    this.scoreP1++;
                    break;

                case P2:
                    this.scoreP2++;
                    break;

                case FREE:
                    break;
        }
    }

    public int getScoreP1() {
        return this.scoreP1;
    }

    public int getScoreP2() {
        return this.scoreP2;
    }

}