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

    public int getTokenStack(int i) {
        int j = this.nbRows - 1;
        while (j < this.nbRows && this.tab[i][j].getState() != State.FREE) {
            j--;
        }
        return j;
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