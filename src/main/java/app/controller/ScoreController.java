package app.controller;

import app.model.GameModel;
import app.view.ScoreView;

public class ScoreController {

    private GameModel gameModel;
    private ScoreView scoreView;

    public ScoreController(GameModel gameModel) {
        this.gameModel = gameModel;
        this.scoreView = new ScoreView();
    }

    public ScoreView getScoreView() {
        return this.scoreView;
    }
}