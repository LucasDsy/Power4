package app.model;

import app.model.enums.State;

public class GridModel {
    private Token[][] tab;
    private int nbCols;
    private int nbRows;

    public GridModel(int nbCols, int nbRows) {

        this.nbCols = nbCols;
        this.nbRows = nbRows;

        this.tab = new Token[this.nbCols][this.nbRows];

        this.initToken();
    }

    public void initToken() {
        for (int i = 0; i < this.nbCols; i++) {
            for (int j = 0; j < this.nbRows; j++) {
                this.tab[i][j] = new Token();
            }
        }
    }

    public int stackTokens(int col) {
        int i = 5;
        int value = 1;
        while (i < this.nbCols && this.tab[col][i].getState().getNumber() != 0) {
            i--;
        }
        System.out.println(i);
        return i;
    }

    public Token getToken(int i, int j) {
        return this.tab[i][j];
    }

    public int getNbRows() {
        return this.nbRows;
    }

    public int getNbCols() {
        return this.nbCols;
    }

}