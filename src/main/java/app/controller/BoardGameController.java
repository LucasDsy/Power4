package app.controller;

import app.model.GameModel;
import app.view.BoardGameView;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class BoardGameController extends Stage {
    private static final int cols = 7;
    private static final int rows = 6;
    private GameModel gameModel;
    private BoardGameView boardGameView;
    private GridController gridController;

    public BoardGameController() {
        super();
        this.gameModel = new GameModel();

        gridController = new GridController(cols, rows, gameModel);
        // scoreController = new ScoreController(gameModel)

        this.boardGameView = new BoardGameView(gridController.getGridView());

        this.setScene(new Scene(boardGameView));

        this.setTitle("Puissance 4");
        this.setResizable(false);
    }
}