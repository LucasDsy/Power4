package app.controller;

import app.Observer;
import app.model.FileManager;
import app.model.Score;
import app.view.history.HistoryView;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class HistoryController implements Observer {
    private HistoryView historyView;

    public HistoryController() {
        super();
        
        ObservableList<Score> scoreList = FXCollections.observableArrayList(FileManager.getInstance().getScoreList());

        historyView = new HistoryView(scoreList);

        FileManager.getInstance().addObserver(this);
    }

    public HistoryView getHistoryView() {
        return historyView;
    }

    @Override
    public void update() {
        System.out.println("Updating tableView...");
        historyView.getTableView().setItems(FXCollections.observableArrayList(FileManager.getInstance().getScoreList()));
    }
}