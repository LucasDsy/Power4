package app.controller;

import app.model.GameModel;
import app.model.GridModel;
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
        this.gridModel = new GridModel(gameModel.getNbCols(), gameModel.getNbRows());
        this.gridView = new GridView(gameModel.getNbCols(), gameModel.getNbRows());
        this.gameModel = gameModel;
        
        this.setListeners();

        this.currentHoverTokenView = null;
    }

    public GridModel getGridModel() {
        return this.gridModel;
    }

    public GridView getGridView() {
        return this.gridView;
    }

    public void endGame() {
        System.out.println("Fin de la partie!");
        // this.scoreModel.updateScore();
        this.gridModel.initToken();
        this.gridView.initTokenView();
        this.setListeners();
    }

    private void setOnMouseHoverListeners(final TokenView tokenView) {

        tokenView.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                Integer[] tokenCoordinates = gridView.getTokenViewCoordinates(tokenView);
                Token.Player currentPlayer = gameModel.getCurrentPlayer();

                setPlayerColorForToken(tokenView);

                if (tokenCoordinates[0] != null && tokenCoordinates[1] != null) {
                    
                    if (gridModel.isWinning(currentPlayer, tokenCoordinates[0], tokenCoordinates[1], 0)) {
                        endGame();
                    }
                }
    
                gameModel.nextPlayer();
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
        switch (this.gameModel.getCurrentPlayer()) {
            case P1:
                
                break;

            case P2:
                
                break;

            case P3:
                
                break;

            case P4:
                
                break;

            case NONE:
                break;
        }
    }
}