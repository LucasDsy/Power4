package app.controller;

import app.model.Direction;
import app.model.FileManager;
import app.model.GameModel;
import app.model.GridModel;
import app.model.PlayerModel;
import app.model.Token;
import app.view.GridView;
import app.view.TokenView;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class GridController {
    private GridModel gridModel;
    private GridView gridView;
    private GameModel gameModel;
    private TokenView currentHoverTokenView;

    public GridController(GameModel gameModel) {
        gridModel = new GridModel(gameModel.getNbCols(), gameModel.getNbRows());
        gridView = new GridView(gameModel.getNbCols(), gameModel.getNbRows());
        this.gameModel = gameModel;
        
        setListeners();

        currentHoverTokenView = null;
    }

    public GridModel getGridModel() {
        return gridModel;
    }

    public GridView getGridView() {
        return gridView;
    }

    public void endGame() {
        gameModel.getCurrentPlayer().increaseScore();
        gameModel.notifyObservers();
        
        for (PlayerModel playerModel : gameModel.getPlayers()) {
            if (playerModel.getScore() > 0)
                FileManager.getInstance().addScore(playerModel.getUsername(), playerModel.getScore());
        }
        
        gridModel.initTokens();
        gridView.initTokenView();
        setListeners();
    }

    private void setOnMouseHoverListeners(final TokenView tokenView) {

        tokenView.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                Integer[] tokenCoordinates = gridView.getTokenViewCoordinates(tokenView);

                if (tokenCoordinates[0] != null && tokenCoordinates[1] != null) {
                    tokenCoordinates[1] = gridModel.getTokenStack(tokenCoordinates[0]);

                    Token.Player currentPlayer = gameModel.getCurrentPlayer().getAttributedNumber();
                    System.out.println(gameModel.getCurrentPlayer().getAttributedNumber());
                    gridModel.setToken(tokenCoordinates[0], tokenCoordinates[1], currentPlayer);

                    TokenView actualTokenView = gridView.getTokenView(tokenCoordinates[0], tokenCoordinates[1]);
                    setPlayerColorForToken(actualTokenView);

                    if (gridModel.isWinning(currentPlayer, tokenCoordinates[0], tokenCoordinates[1], 0, Direction.NONE) || gridModel.isFull()) {
                        endGame();
                    }

                    gameModel.nextPlayer();
                }
            }
        });


        tokenView.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                Integer[] tokenCoordinates = gridView.getTokenViewCoordinates(tokenView);

                if (tokenCoordinates[0] != null) {
                    int row = gridModel.getTokenStack(tokenCoordinates[0]);
                    
                    currentHoverTokenView = gridView.getTokenView(tokenCoordinates[0], row);
                    currentHoverTokenView.setHoverColor();
                }
            }
        });


        tokenView.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if (currentHoverTokenView != null && !currentHoverTokenView.isAlreadyColored()) {
                    currentHoverTokenView.setNormalColor();
                    currentHoverTokenView = null;
                }
            }
        });
    }

    private void setListeners() {
        for (TokenView[] tokenViewSubList : gridView.getTokenViewList()) {
            for (TokenView tokenView : tokenViewSubList) {
                setOnMouseHoverListeners(tokenView);
            }
        }
    }

    private void setPlayerColorForToken(TokenView tokenView) {
        tokenView.setColor(gameModel.getCurrentPlayer().getColor());
    }
}