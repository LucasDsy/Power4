package app.view.history;

import java.util.ArrayList;
import java.util.Collection;

import app.model.Score;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.layout.Pane;
import javafx.util.Callback;

public class HistoryView extends Pane {
    private TableView<Score> tableView;
    
    public HistoryView(ObservableList<Score> list) {
        super();
        
        configureTableView(list);
        
        tableView.setMinWidth(200);
        tableView.setPrefHeight(600);
        super.getChildren().add(tableView);
    }

    private void configureTableView(ObservableList<Score> list) {
        ObservableList<Score> scores = list;

        tableView = new TableView<>(scores);

        TableColumn<Score, String> usernameColumn = new TableColumn<>("Username");
        TableColumn<Score, Integer> scoreColumn = new TableColumn<>("Best Score");

        usernameColumn.setCellValueFactory(new Callback<CellDataFeatures<Score,String>,ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(CellDataFeatures<Score, String> param) {
                return param.getValue().usernameProperty();
            }
        });

        scoreColumn.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Score,Integer>,ObservableValue<Integer>>() {
            @Override
            public ObservableValue<Integer> call(CellDataFeatures<Score, Integer> param) {
                return param.getValue().scoreProperty().asObject();
            }
        });

        Collection<TableColumn<Score, ?>> tableColumns = new ArrayList<>();
        tableColumns.add(usernameColumn);
        tableColumns.add(scoreColumn);

        tableView.getColumns().setAll(tableColumns);
    }

    public TableView<Score> getTableView() {
        return tableView;
    }
}