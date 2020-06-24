package app.view;

import javafx.scene.layout.GridPane;

import java.util.ArrayList;
import java.util.List;

public class GridView extends GridPane {
    private List<TokenView> tokenViewList;

    public GridView(int nbCols, int nbRows, int tokenSize) {
        super();

        int tokenRadius = (tokenSize/2)*9/10;
        int tokenGap = tokenSize/10;
        
        this.setVgap(tokenGap);
        this.setHgap(tokenGap);

        tokenViewList = new ArrayList<TokenView>();

        for (int i = 0; i < nbCols; i++) {
            for (int j = 0; j < nbRows; j++) {
                TokenView tokenView = new TokenView(tokenRadius);
                tokenViewList.add(tokenView);
                this.add(tokenView, i, j);
            }
        }
    }

    public List<TokenView> getTokenViewList() {
        return this.tokenViewList;
    }
}