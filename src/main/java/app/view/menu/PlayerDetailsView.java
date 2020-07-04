package app.view.menu;

import javafx.scene.control.ColorPicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;

public class PlayerDetailsView extends BorderPane {
    private TextField usernameTextField;
    private ColorPicker colorPicker;
    
    public PlayerDetailsView() {
        super();

        this.usernameTextField = new TextField();
        this.colorPicker = new ColorPicker();

        super.setLeft(this.usernameTextField);
        super.setRight(this.colorPicker);
    }

    public TextField getTextField() {
        return this.usernameTextField;
    }

    public ColorPicker getColorPicker() {
        return this.colorPicker;
    }
}