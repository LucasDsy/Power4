package app.controller;

import app.model.GameModel;
import app.model.GridModel;
import app.model.Token;
import app.model.enums.State;
import app.view.GridView;
import app.view.TokenView;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class GridController {
    private GridModel gridModel;
    private GridView gridView;
    private GameModel gameModel;
    private ScoreController scoreController;
    private TokenView currentHoverTokenView;

    public GridController(int nbCols, int nbRows, GameModel gameModel, ScoreController scoreController) {
        this.gridModel = new GridModel(nbCols, nbRows);
        this.gridView = new GridView(nbCols, nbRows);
        this.scoreController = scoreController;
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
                    int row = gridModel.getTokenStack(coordinates[0]);

                    if (gridModel.getToken(coordinates[0], row).getState() == State.FREE) {
                    
                        gridModel.getToken(coordinates[0], row).setState(gameModel.getCurrentPlayer());
                        /* Define the TokenView who need to change color in function of the stack */
                        TokenView newTokenView = gridView.getTokenView(coordinates[0], row);
                        /** Check if new token get you a winning line **/
                        checkNewTokenRows(coordinates[0], row, gridModel.getToken(coordinates[0], row).getState());
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
                Integer[] coordinates = gridView.getTokenViewCoordinates(tokenView);

                if (coordinates[0] != null) {
                    int row = gridModel.getTokenStack(coordinates[0]);
                    
                    currentHoverTokenView = gridView.getTokenView(coordinates[0], row);
                    currentHoverTokenView.setHoverGrey();
                }
            }
        });


        tokenView.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if (currentHoverTokenView != null && !currentHoverTokenView.isAlreadyColored()) {
                    currentHoverTokenView.setGrey();
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

    public boolean parseGrid(int col, int row, State tokenState, int number, int direction_y, int direction_x) {

        Token token;
        boolean rslt = false;
        if(row < this.gridModel.getNbRows() && col < this.gridModel.getNbCols() && row >= 0 && col >= 0) {
            token = this.gridModel.getToken(col,row);
            if (number >= 5) {
                rslt = true;
            } else if (token.getState() == tokenState) {
                rslt = parseGrid(col + direction_y, row + direction_x, tokenState, number+1, direction_y, direction_x);
            }
        }
        
        return rslt;
    }

    public void checkNewTokenRows(int col, int row, State state) {
        boolean result = false;
        /* Check dans chaque direction */
        result = parseGrid(col, row, state, 1, 1, 0); /** Bas **/
        if(!result)
            result = parseGrid(col, row, state, 1,-1, 0); /** Haut **/
        if(!result)
            result = parseGrid(col, row, state, 1, 0, 1); /** Droite **/
        if(!result)
            result = parseGrid(col, row, state, 1, 0, 1); /** Gauche **/
        if(!result)
            result = parseGrid(col, row, state, 1, 1, 1); /** Diag 1 **/
        if(!result)
            result = parseGrid(col, row, state, 1,-1, 1); /** Diag 2 **/
        if(!result)
            result = parseGrid(col, row, state, 1, 1,-1); /** Diag 3 **/
        if(!result)
            result = parseGrid(col, row, state, 0,-1,-1); /** Diag 4 **/

        if(result) {
            this.endGame();
        }

    }
}