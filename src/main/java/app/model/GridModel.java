package app.model;

import app.model.Token.Player;
import app.model.Token.State;

public class GridModel {
    private Token[][] matrix;
    private int nbCols;
    private int nbRows;

    public GridModel(int nbCols, int nbRows) {
        this.nbCols = nbCols;
        this.nbRows = nbRows;

        matrix = new Token[nbCols][nbRows];

        initTokens();
    }

    public void initTokens() {
        for (int i = 0; i < nbCols; i++) {
            for (int j = 0; j < nbRows; j++) {
                matrix[i][j] = new Token();
            }
        }
    }

    public void setToken(int i, int j, Player player) {
        matrix[i][j].state = State.TAKEN;
        matrix[i][j].player = player;
    }

    public int getTokenStack(int i) {
        int j = nbRows - 1;
        while (j < nbRows && matrix[i][j].getState() == Token.State.TAKEN) {
            j--;
        }
        return j;
    }

    public Token getToken(int i, int j) {
        return matrix[i][j];
    }

    public int getNbRows() {
        return nbRows;
    }

    public int getNbCols() {
        return nbCols;
    }

    public boolean isWinning(Token.Player playerToCheck, int i, int j, int counter, Direction direction) {
        boolean isWinning = (counter >= 4);

        if (!isWinning && i >= 0 && i < matrix.length && j >= 0 && j < matrix[i].length) {
            
            if (matrix[i][j].state == State.TAKEN && matrix[i][j].player == playerToCheck) {
                
                switch(direction) {
                    case UP:
                        isWinning = isWinning(playerToCheck, i, j+1, counter+1, Direction.UP);
                        break;

                    case DOWN:
                        isWinning = isWinning(playerToCheck, i, j-1, counter+1, Direction.DOWN);
                        break;

                    case LEFT:
                        isWinning = isWinning(playerToCheck, i-1, j, counter+1, Direction.LEFT);
                        break;

                    case RIGHT:
                        isWinning = isWinning(playerToCheck, i+1, j, counter+1, Direction.RIGHT);
                        break;

                    case UPLEFT:
                        isWinning = isWinning(playerToCheck, i-1, j+1, counter+1, Direction.UPLEFT);
                        break;

                    case UPRIGHT:
                        isWinning = isWinning(playerToCheck, i+1, j+1, counter+1, Direction.UPRIGHT);
                        break;

                    case DOWNLEFT:
                        isWinning = isWinning(playerToCheck, i-1, j-1, counter+1, Direction.DOWNLEFT);
                        break;

                    case DOWNRIGHT:
                        isWinning = isWinning(playerToCheck, i+1, j-1, counter+1, Direction.DOWNRIGHT);
                        break;
                    
                    case NONE: // première itération : on lance une récursivité dans chaque direction
                        isWinning = isWinning(playerToCheck, i, j, counter, Direction.UP) ||
                                    isWinning(playerToCheck, i, j, counter, Direction.DOWN) ||
                                    isWinning(playerToCheck, i, j, counter, Direction.LEFT) ||
                                    isWinning(playerToCheck, i, j, counter, Direction.RIGHT) ||
                                    isWinning(playerToCheck, i, j, counter, Direction.UPLEFT) ||
                                    isWinning(playerToCheck, i, j, counter, Direction.UPRIGHT) ||
                                    isWinning(playerToCheck, i, j, counter, Direction.DOWNLEFT) ||
                                    isWinning(playerToCheck, i, j, counter, Direction.DOWNRIGHT);
                }
            }
        }

        return isWinning;
    }

    public boolean isFull() {
        int i = 0, j = 0;
        boolean isFull = true;

        while (i < matrix.length && isFull) {
            
            while (j < matrix[i].length && isFull) {
                isFull = (matrix[i][j].state == State.TAKEN);
                j++;
            }

            i++;
        }

        return isFull;
    }
}