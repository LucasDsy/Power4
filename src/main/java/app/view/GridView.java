package app.view;

import javafx.geometry.Pos;
import javafx.scene.layout.GridPane;

public class GridView extends GridPane {
    private TokenView[][] tokenViewList;

    private int nbCols;
    private int nbRows;

    private double tokenSize;
    private double tokenRadius;
    private double tokenGap;

    public GridView(int nbCols, int nbRows) {
        super();

        this.nbCols = nbCols;
        this.nbRows = nbRows;

        tokenSize = (nbCols/nbRows)*100;
        tokenRadius = (tokenSize/2)*9/10;
        tokenGap = tokenSize/10;
        
        super.setPrefSize(nbCols*100, nbRows*100);
        super.setVgap(tokenGap);
        super.setHgap(tokenGap);
        super.setAlignment(Pos.CENTER);

        tokenViewList = new TokenView[nbCols][nbRows];
        initTokenView();
        
    }

    public void initTokenView() {
        for (int i = 0; i < nbCols; i++) {
            for (int j = 0; j < nbRows; j++) {
                TokenView tokenView = new TokenView(tokenRadius);
                tokenViewList[i][j] = tokenView;
                add(tokenView, i, j);
            }
        }
    }

    public Integer[] getTokenViewCoordinates(TokenView tokenView) {
        Integer[] coordinates = {
            GridPane.getColumnIndex(tokenView),
            GridPane.getRowIndex(tokenView)
        };

       return coordinates;
    }

    public TokenView[][] getTokenViewList() {
        return tokenViewList;
    }

    public TokenView getTokenView(int i, int j) {
        TokenView tokenView = null;
        
        if (i >= 0 && i < nbCols && j >= 0 && j < nbRows) {
            tokenView = tokenViewList[i][j];
        }

        return tokenView;
    }
}