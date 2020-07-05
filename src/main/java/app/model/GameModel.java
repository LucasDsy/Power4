package app.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import app.Observable;
import app.Observer;

public class GameModel implements Observable {
    private List<Observer> observers;
    private Set<PlayerModel> playerSet;
    private Iterator<PlayerModel> playerIterator;
    private PlayerModel currentPlayer;
    private int nbCols;
    private int nbRows;

    public GameModel(Set<PlayerModel> playerSet, int nbCols, int nbRows) {
        this.nbCols = nbCols;
        this.nbRows = nbRows;

        this.playerSet = playerSet;
        playerIterator = playerSet.iterator();

        currentPlayer = playerIterator.next();

        observers = new ArrayList<>();
    }

    public int getNbCols() {
        return nbCols;
    }

    public int getNbRows() {
        return nbRows;
    }

    public void nextPlayer() {
        if (!playerIterator.hasNext()) {
            playerIterator = playerSet.iterator();
        }

        currentPlayer = playerIterator.next();
    }

    public PlayerModel getCurrentPlayer() {
        return currentPlayer;
    }

    public Set<PlayerModel> getPlayers() {
        return playerSet;
    }

    @Override
    public void addObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void deleteObserver(Observer o) {
        observers.remove(o);
    }

    @Override
    public void notifyObservers() {
        for (Observer o : observers) {
            o.update();
        }
    }
}