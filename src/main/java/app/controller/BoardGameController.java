package app.controller;

import app.model.GameModel;
import app.view.BoardGameView;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class BoardGameController extends Stage {
    private BoardGameView boardGameView;
    private GridController gridController;
    private ScoreController scoreController;

    public BoardGameController(GameModel gameModel) {
        super();

        scoreController = new ScoreController(gameModel);
        gridController = new GridController(gameModel);

        this.boardGameView = new BoardGameView(gridController.getGridView(), scoreController.getScoreView());

        super.setScene(new Scene(boardGameView));

        super.setTitle("Puissance 4");
        super.setResizable(false);
    }
}