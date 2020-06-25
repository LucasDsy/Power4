package app.controller;

import app.model.ScoreModel;
import app.model.GameModel;
import app.view.ScoreView;

public class ScoreController {

    private GameModel gameModel;
    private ScoreModel scoreModel;
    private ScoreView scoreView;

    public ScoreController(GameModel gameModel) {
        this.gameModel = gameModel;
        this.scoreModel = new ScoreModel();
        this.scoreView = new ScoreView();
    }

    public ScoreView getScoreView() {
        return this.scoreView;
    }

    public void updateScore() {
        this.scoreModel.writeScore(this.gameModel.getCurrentPlayer());
        this.displayScore();
    }

    public void displayScore() {
        this.scoreView.refreshScores(this.scoreModel.getScoreP1(),this.scoreModel.getScoreP2());
    }

}