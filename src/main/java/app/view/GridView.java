package app.view;

import javafx.geometry.Pos;
import javafx.scene.layout.GridPane;

import java.util.ArrayList;
import java.util.List;

public class GridView extends GridPane {
    private List<TokenView> tokenViewList;

    public GridView(int nbCols, int nbRows) {
        super();

        double tokenSize = (nbCols/nbRows)*100;
        double tokenRadius = (tokenSize/2)*9/10;
        double tokenGap = tokenSize/10;
        
        super.setPrefSize(nbCols*100, nbRows*100);
        super.setVgap(tokenGap);
        super.setHgap(tokenGap);
        super.setAlignment(Pos.CENTER);

        this.tokenViewList = new ArrayList<TokenView>();

        for (int i = 0; i < nbCols; i++) {
            for (int j = 0; j < nbRows; j++) {
                TokenView tokenView = new TokenView(tokenRadius);
                this.tokenViewList.add(tokenView);
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

    public List<TokenView> getTokenViewList() {
        return this.tokenViewList;
    }
}