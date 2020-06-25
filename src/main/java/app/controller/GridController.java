package app.controller;

import java.util.List;

import app.model.GameModel;
import app.model.GridModel;
import app.view.GridView;
import app.view.TokenView;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class GridController {
    private GridModel gridModel;
    private GridView gridView;
    private GameModel gameModel;

    public GridController(int nbCols, int nbRows, GameModel gameModel) {
        this.gridModel = new GridModel(nbCols, nbRows);
        this.gridView = new GridView(nbCols, nbRows);
        this.gameModel = gameModel;
        
        this.setListeners();
    }

    private void setOnMouseHoverListeners(final TokenView tokenView) {

        tokenView.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                Integer[] coordinates = gridView.getTokenViewCoordinates(tokenView);

                if (coordinates[0] != null || coordinates[1] != null) {
                    gridModel.getToken(coordinates[0], coordinates[1]).setState(gameModel.getCurrentPlayer());

                    switch (gameModel.getCurrentPlayer()) {
                        case P1:
                            tokenView.setRed();
                            break;

                        case P2:
                            tokenView.setYellow();
                            break;

                        case FREE:
                            break;
                    }

                    gameModel.nextPlayer();
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


    public GridView getGridView() {
        return this.gridView;
    }
}