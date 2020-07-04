package app.controller;

import java.util.HashSet;
import java.util.Set;

import app.App;
import app.model.GameModel;
import app.model.PlayerModel;
import app.model.Token.Player;
import app.view.menu.MenuView;
import app.view.menu.PlayerDetailsView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class MenuController extends Stage {
    private MenuView menuView;

    public MenuController() {
        this.menuView = new MenuView();

        this.setListeners();
        super.setScene(new Scene(menuView));
    }

    private void setListeners() {
        this.menuView.getPlayerNumberView().getPlayerNumberChoiceBox().setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
                menuView.updatePlayerDetailsViews();
			}
        });

        this.menuView.getPlayButton().setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {

                if (checkAll()) {
                    Set<PlayerModel> playerSet = new HashSet<>();

                    for (int i = 0; i < menuView.getPlayerNumberView().getPlayerNumber(); i++) {
                        PlayerDetailsView playerDetailsView = menuView.getPlayerDetailsView(i);
                        Color color = playerDetailsView.getColorPicker().getValue();
                        String username = playerDetailsView.getTextField().getText();

                        Player player = Player.NONE;

                        for (Player tmp : Player.values()) {
                            if (tmp.getNumber() == i+1) {
                                player = tmp;
                            }
                        }

                        playerSet.add(new PlayerModel(username, color, player));
                    }

                    int nbCols = menuView.getSizeChooserView().getColChoiceBox().getValue();
                    int nbRows = menuView.getSizeChooserView().getRowChoiceBox().getValue();

                    GameModel gameModel = new GameModel(playerSet, nbCols, nbRows);

                    App.openBoardController(gameModel);
                }
			}
        });
    }

    /**
     * Cette fonction vérifie que deux joueurs n'ont pas le même nom, pas la même couleur
     * (ce ne serait pas gênant de notre côté, mais un peu pour jouer...)
     * @return true si tout est bon, false sinon
     */
    private boolean checkAll() {
        boolean bool = true;
        int i = 0;
        Set<Color> colorSet = new HashSet<>();
        Set<String> usernameSet = new HashSet<>();
                
        while (i < this.menuView.getPlayerNumberView().getPlayerNumber() && bool) {
            PlayerDetailsView playerDetailsView = this.menuView.getPlayerDetailsView(i);

            bool = playerDetailsView != null && playerDetailsView.getTextField().getText() != "";

            if (bool) {
                Color color = playerDetailsView.getColorPicker().getValue();
                String username = playerDetailsView.getTextField().getText();
                
                bool = !colorSet.contains(color) && !usernameSet.contains(username);
                
                colorSet.add(color);
                usernameSet.add(username);
            }

            i++;
        }

        return bool;
    }
}