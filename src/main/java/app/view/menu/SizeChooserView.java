package app.view.menu;

import javafx.collections.FXCollections;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class SizeChooserView extends VBox {
    private HBox colBox;
    private HBox rowBox;
    private Label colLabel;
    private ChoiceBox<Integer> colChoiceBox;
    private Label rowLabel;
    private ChoiceBox<Integer> rowChoiceBox;

    public SizeChooserView() {
        colBox = new HBox();
        rowBox = new HBox();

        colLabel = new Label("Taille horizontale : ");
        rowLabel = new Label("Taille verticale : ");

        colChoiceBox = new ChoiceBox<>(FXCollections.observableArrayList(7, 8, 9, 10));
        rowChoiceBox = new ChoiceBox<>(FXCollections.observableArrayList(6));
        colChoiceBox.setValue(7);
        rowChoiceBox.setValue(6);

        colBox.getChildren().addAll(colLabel, colChoiceBox);
        rowBox.getChildren().addAll(rowLabel, rowChoiceBox);

        super.getChildren().addAll(colBox, rowBox);
    }

    public ChoiceBox<Integer> getColChoiceBox() {
        return colChoiceBox;
    }

    public ChoiceBox<Integer> getRowChoiceBox() {
        return rowChoiceBox;
    }
}