package app.controller;

import app.view.InterfaceView;
import app.view.GridView;
import app.view.TokenView;

import javafx.scene.input.MouseEvent;
import javafx.event.EventHandler;
import java.util.ArrayList;

public class BoardGameController {

    private String title;
    private InterfaceView my_interface;

    public BoardGameController(String title) {
        this.title = title;
        this.my_interface = new InterfaceView();
        this.my_interface.initInterface();
        this.addListeners();
    }

    private void setOnMouseHoverListeners(final TokenView tokenView) {
        tokenView.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                tokenView.setHoverGrey();
            }
        });

        tokenView.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                tokenView.setGrey();
            }
        });
    }

    private void addListeners() {
        ArrayList<TokenView> tokens = this.my_interface.getGrid().getTokens();
        tokens.forEach((t) -> setOnMouseHoverListeners(t)); 
    }
}