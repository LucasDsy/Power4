package app.view.menu;

import javafx.collections.FXCollections;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

public class PlayerNumberView extends HBox {
    private Label playerNumberLabel;
    private ChoiceBox<Integer> playerNumberChoiceBox;

    public PlayerNumberView() {
        super();

        playerNumberLabel = new Label("Combien de joueurs vont jouer ?");

        playerNumberChoiceBox = new ChoiceBox<>(FXCollections.observableArrayList(2,3,4));
        playerNumberChoiceBox.setValue(2);

        super.setSpacing(10);
        super.getChildren().addAll(playerNumberLabel, playerNumberChoiceBox);
    }

    public int getPlayerNumber() {
        return (int) playerNumberChoiceBox.getValue();
    }

    public ChoiceBox<Integer> getPlayerNumberChoiceBox() {
        return playerNumberChoiceBox;
    }
}