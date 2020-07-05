package app.view.menu;

import javafx.scene.control.ColorPicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;

public class PlayerDetailsView extends BorderPane {
    private TextField usernameTextField;
    private ColorPicker colorPicker;
    
    public PlayerDetailsView() {
        super();

        usernameTextField = new TextField();
        colorPicker = new ColorPicker();

        super.setLeft(usernameTextField);
        super.setRight(colorPicker);
    }

    public TextField getTextField() {
        return usernameTextField;
    }

    public ColorPicker getColorPicker() {
        return colorPicker;
    }
}