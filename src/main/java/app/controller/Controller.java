package controller;

import model;

public class Controller {
    private int matrice[][];

    public Controller() {
        matrice = GameManager.getInstance().matrice;
        GameManager.controlWin();
    }
}