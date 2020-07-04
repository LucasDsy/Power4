package app.model;

import java.util.Iterator;
import java.util.Set;

public class GameModel {
    private Set<PlayerModel> playerSet;
    private Iterator<PlayerModel> playerIterator;
    private PlayerModel currentPlayer;
    private int nbCols;
    private int nbRows;

    public GameModel(Set<PlayerModel> playerSet, int nbCols, int nbRows) {
        this.nbCols = nbCols;
        this.nbRows = nbRows;

        this.playerSet = playerSet;
        this.playerIterator = playerSet.iterator();

        currentPlayer = this.playerIterator.next();
    }

    public int getNbCols() {
        return this.nbCols;
    }

    public int getNbRows() {
        return this.nbRows;
    }

    public void nextPlayer() {
        if (!this.playerIterator.hasNext()) {
            this.playerIterator = playerSet.iterator();
        }

        currentPlayer = playerIterator.next();
    }

    public PlayerModel getCurrentPlayer() {
        return this.currentPlayer;
    }
}