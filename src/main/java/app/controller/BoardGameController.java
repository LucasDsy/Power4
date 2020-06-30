package app.controller;

import java.util.HashSet;
import java.util.Set;

import app.model.GameModel;
import app.model.PlayerModel;
import app.model.Token.Player;
import app.view.BoardGameView;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class BoardGameController extends Stage {
    private BoardGameView boardGameView;
    private GridController gridController;
    private ScoreController scoreController;

    public BoardGameController(/*GameModel gameModel*/) {
        super();

        /* en attendant d'avoir un menu fonctionnel */
        Set<PlayerModel> playerSet = new HashSet<>();
        playerSet.add(new PlayerModel("Choups", Color.RED, Player.P1));
        playerSet.add(new PlayerModel("Cal", Color.YELLOW, Player.P2));

        GameModel gameModel = new GameModel(playerSet, 7, 6);

        scoreController = new ScoreController(gameModel);
        gridController = new GridController(gameModel);

        this.boardGameView = new BoardGameView(gridController.getGridView(),scoreController.getScoreView());

        this.setScene(new Scene(boardGameView));

        this.setTitle("Puissance 4");
        this.setResizable(false);
    }
}