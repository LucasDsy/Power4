package app.controller;

import app.model.GameModel;
import app.view.BoardGameView;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class BoardGameController extends Stage {
    
    private GameModel gameModel;
    private BoardGameView boardGameView;
    private GridController gridController;
    private ScoreController scoreController;

    public BoardGameController() {
        super();
        this.gameModel = new GameModel();

        scoreController = new ScoreController(gameModel);
        gridController = new GridController(gameModel.getNbCols(), gameModel.getNbRows(), gameModel, scoreController);

        this.boardGameView = new BoardGameView(gridController.getGridView(),scoreController.getScoreView());

        this.setScene(new Scene(boardGameView));

        this.setTitle("Puissance 4");
        this.setResizable(false);
    }
}