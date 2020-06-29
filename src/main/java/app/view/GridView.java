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

        this.tokenSize = (this.nbCols/this.nbRows)*100;
        this.tokenRadius = (this.tokenSize/2)*9/10;
        this.tokenGap = this.tokenSize/10;
        
        super.setPrefSize(nbCols*100, nbRows*100);
        super.setVgap(tokenGap);
        super.setHgap(tokenGap);
        super.setAlignment(Pos.CENTER);

        this.tokenViewList = new TokenView[nbCols][nbRows];
        this.initTokenView();
        
    }

    public void initTokenView() {
        for (int i = 0; i < this.nbCols; i++) {
            for (int j = 0; j < this.nbRows; j++) {
                TokenView tokenView = new TokenView(this.tokenRadius);
                this.tokenViewList[i][j] = tokenView;
                this.add(tokenView, i, j);
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
        return this.tokenViewList;
    }

    public TokenView getTokenView(int i, int j) {
        TokenView tokenView = null;
        
        if (i >= 0 && i < this.nbCols && j >= 0 && j < this.nbRows) {
            tokenView = tokenViewList[i][j];
        }

        return tokenView;
    }
}