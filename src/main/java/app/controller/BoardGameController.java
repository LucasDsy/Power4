package app.controller;

import app.App;
import app.model.GameModel;
import app.view.BoardGameView;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class BoardGameController extends Stage {
    private BoardGameView boardGameView;
    private GridController gridController;
    private ScoreController scoreController;
    private HistoryController historyController;

    public BoardGameController(GameModel gameModel) {
        super();

        scoreController = new ScoreController(gameModel);
        gridController = new GridController(gameModel);
        historyController = new HistoryController();

        boardGameView = new BoardGameView(gridController.getGridView(), scoreController.getScoreView(), historyController.getHistoryView());

        setBackButtonViewListeners();

        super.setScene(new Scene(boardGameView));
        super.setTitle("Puissance 4");
        super.setResizable(false);
    }

    private void setBackButtonViewListeners() {
        boardGameView.getBackButtonView().setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                App.openMenuController();
            }
        });

        boardGameView.getBackButtonView().setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                boardGameView.getBackButtonView().setHoverColor();
            }
        });

        boardGameView.getBackButtonView().setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                boardGameView.getBackButtonView().setNormalColor();
            }
        });
    }
}