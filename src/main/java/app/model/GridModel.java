package app.model;

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
        while (j < this.nbRows && this.tab[i][j].getState() == Token.State.TAKEN) {
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

    public boolean isWinning(Token.Player playerToCheck, int i, int j, int counter) {
        boolean isWinning = (counter <= 4);

        if (!isWinning && i >= 0 && i < this.tab.length && j >= 0 && j < this.tab[i].length) {
            Token currentToken = this.tab[i][j];
            
            if (currentToken.state == Token.State.TAKEN && currentToken.player == playerToCheck) {
                counter++;
            }

            isWinning = isWinning(playerToCheck, i+1, j, counter);
        }

        return isWinning;
    }

    public boolean parseGrid(int col, int row, Token.State tokenState, int number, int direction_y, int direction_x) {
        Token token;
        boolean rslt = false;

        if (row < this.nbRows && col < this.nbCols && row >= 0 && col >= 0) {
            token = this.getToken(col,row);
            if (number >= 5) {
                rslt = true;
            } else if (token.getState() == tokenState) {
                rslt = parseGrid(col + direction_y, row + direction_x, tokenState, number+1, direction_y, direction_x);
            }
        }
        
        return rslt;
    }

    public void checkNewTokenRows(int col, int row, Token.State state) {
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
            // this.endGame();
        }
    }
}