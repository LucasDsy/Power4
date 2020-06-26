package app.controller;

import java.util.List;

import app.controller.ScoreController;

import app.model.GameModel;
import app.model.GridModel;
import app.model.enums.State;
import app.model.Token;
import app.view.GridView;
import app.view.TokenView;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class GridController {
    private GridModel gridModel;
    private GridView gridView;
    private GameModel gameModel;
    private ScoreController scoreController;

    public GridController(int nbCols, int nbRows, GameModel gameModel, ScoreController scoreController) {
        this.gridModel = new GridModel(nbCols, nbRows);
        this.gridView = new GridView(nbCols, nbRows);
        this.scoreController = scoreController;
        this.gameModel = gameModel;
        
        this.setListeners();
    }

    public GridModel getGridModel() {
        return this.gridModel;
    }

    public GridView getGridView() {
        return this.gridView;
    }

    public void endGame() {
        System.out.println("Fin de la partie!");
        this.scoreController.updateScore();
        this.gridModel.initToken();
        this.gridView.initTokenView();
        this.setListeners();
    }

    private void setOnMouseHoverListeners(final TokenView tokenView) {

        tokenView.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                Integer[] coordinates = gridView.getTokenViewCoordinates(tokenView);

                if (coordinates[0] != null && coordinates[1] != null) {

                    /* Calculate the height of the stack */
                    int row = gridModel.stackTokens(coordinates[0]);

                    if (gridModel.getToken(coordinates[0], row).getState().getNumber() == 0) {
                    
                        gridModel.getToken(coordinates[0], row).setState(gameModel.getCurrentPlayer());
                        /* Define the TokenView who need to change color in function of the stack */
                        TokenView newTokenView = gridView.getTokenView(coordinates[0], row);
                        /** Check if new token get you a winning line **/
                        checkNewTokenRows(coordinates[0], row, gridModel.getToken(coordinates[0], row).getState().getNumber());
                        switch (gameModel.getCurrentPlayer()) {
                            case P1:
                                newTokenView.setRed();
                                break;

                            case P2:
                                newTokenView.setYellow();
                                break;

                            case FREE:
                                break;
                        }
            
                        gameModel.nextPlayer();
                    }
                }
            }
        });


        tokenView.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if (!tokenView.isAlreadyColored()) {
                    tokenView.setHoverGrey();
                }
            }
        });


        tokenView.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if (!tokenView.isAlreadyColored()) {
                    tokenView.setGrey();
                }
            }
        });
    }

    private void setListeners() {
        List<TokenView> tokenViewList = gridView.getTokenViewList();
        
        for (TokenView tokenView : tokenViewList) {
            setOnMouseHoverListeners(tokenView);
        }
    }

    public boolean parseGrid(int col, int row, int tokenType, int number, int direction_y, int direction_x) {

        Token token;
        boolean rslt = false;
        if(row < this.gridModel.getNbRows() && col < this.gridModel.getNbCols() && row >= 0 && col >= 0) {
            token = this.gridModel.getToken(col,row);
            if (number >= 5) {
                rslt = true;
            } else if (token.getState().getNumber() == tokenType) {
                rslt = parseGrid(col + direction_y, row + direction_x, tokenType, number+1, direction_y, direction_x);
            }
        }
        
        return rslt;
    }

    public void checkNewTokenRows(int col, int row, int currentPlayer) {
        boolean result = false;
        /* Check dans chaque direction */
        result = parseGrid(col, row, currentPlayer, 1, 1, 0); /** Bas **/
        if(!result)
            result = parseGrid(col, row, currentPlayer, 1,-1, 0); /** Haut **/
        if(!result)
            result = parseGrid(col, row, currentPlayer, 1, 0, 1); /** Droite **/
        if(!result)
            result = parseGrid(col, row, currentPlayer, 1, 0, 1); /** Gauche **/
        if(!result)
            result = parseGrid(col, row, currentPlayer, 1, 1, 1); /** Diag 1 **/
        if(!result)
            result = parseGrid(col, row, currentPlayer, 1,-1, 1); /** Diag 2 **/
        if(!result)
            result = parseGrid(col, row, currentPlayer, 1, 1,-1); /** Diag 3 **/
        if(!result)
            result = parseGrid(col, row, currentPlayer, 0,-1,-1); /** Diag 4 **/

        if(result) {
            this.endGame();
        }

    }
}