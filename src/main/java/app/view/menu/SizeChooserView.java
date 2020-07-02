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
        this.colBox = new HBox();
        this.rowBox = new HBox();

        this.colLabel = new Label("Taille horizontale : ");
        this.rowLabel = new Label("Taille verticale : ");

        this.colChoiceBox = new ChoiceBox<>(FXCollections.observableArrayList(7, 8, 9, 10, 11, 12));
        this.rowChoiceBox = new ChoiceBox<>(FXCollections.observableArrayList(6, 7, 8, 9, 10));
        this.colChoiceBox.setValue(7);
        this.rowChoiceBox.setValue(6);

        this.colBox.getChildren().addAll(colLabel, colChoiceBox);
        this.rowBox.getChildren().addAll(rowLabel, rowChoiceBox);

        super.getChildren().addAll(this.colBox, this.rowBox);
    }

    public ChoiceBox<Integer> getColChoiceBox() {
        return colChoiceBox;
    }

    public ChoiceBox<Integer> getRowChoiceBox() {
        return rowChoiceBox;
    }
}