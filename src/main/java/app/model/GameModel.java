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
        this.playerIterator = playerSet.iterator();

        currentPlayer = this.playerIterator.next();

        this.observers = new ArrayList<>();
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

    public Set<PlayerModel> getPlayers() {
        return this.playerSet;
    }

    @Override
    public void addObserver(Observer o) {
        this.observers.add(o);
    }

    @Override
    public void deleteObserver(Observer o) {
        this.observers.remove(o);
    }

    @Override
    public void notifyObservers() {
        for (Observer o : this.observers) {
            o.update();
        }
    }
}