package app.controller;

import java.util.ArrayList;

import app.Observer;
import app.model.GameModel;
import app.model.PlayerModel;
import app.view.ScoreView;

public class ScoreController implements Observer {
    private GameModel gameModel;
    private ScoreView scoreView;

    public ScoreController(GameModel gameModel) {
        this.gameModel = gameModel;
        this.gameModel.addObserver(this);

        ArrayList<String> usernameList = new ArrayList<>();

        for (PlayerModel playerModel : gameModel.getPlayers()) {
            usernameList.add(playerModel.getUsername());
        }

        this.scoreView = new ScoreView(usernameList);
    }

    public ScoreView getScoreView() {
        return this.scoreView;
    }

    @Override
    public void update() {
        for (PlayerModel playerModel : this.gameModel.getPlayers()) {
            this.scoreView.refreshScore(playerModel.getUsername(), playerModel.getScore());
        }
    }
}