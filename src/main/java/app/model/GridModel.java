package app.model;

public class GridModel {
    private Token[][] tab;

    public GridModel(int nbCols, int nbRows) {
        tab = new Token[nbCols][nbRows];

        for (int i = 0; i < nbCols; i++) {
            for (int j = 0; j < nbRows; j++) {
                tab[i][j] = new Token();
            }
        }
    }

    public Token getToken(int i, int j) {
        return tab[i][j];
    }
}