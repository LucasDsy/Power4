package app.view.menu;

import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

public class MenuView extends VBox {
    private PlayerNumberView playerNumberView;
    private SizeChooserView sizeChooserView;
    private VBox playerDetailsViews;
    private Button playButton;
    
    public MenuView() {
        super();

        this.playerNumberView = new PlayerNumberView();
        this.sizeChooserView = new SizeChooserView();
        this.playerDetailsViews = new VBox();
        this.playButton = new Button("Play");

        for (int i = 0; i < 4; i++) {
            playerDetailsViews.getChildren().add(new PlayerDetailsView());
        }

        super.getChildren().addAll(this.playerNumberView, this.sizeChooserView, this.playerDetailsViews, this.playButton);

        this.setStyle();
        this.updatePlayerDetailsViews();
    }

    /** Functions */
    public void updatePlayerDetailsViews() {
        int effectivePlayerDetailsViewsNumber = this.getEffectivePlayerDetailsViewsNumber(); // Nombre de playerDetailsViews activées
        int neededPlayerDetailsViewsNumber = this.playerNumberView.getPlayerNumber(); // Nombre de playerDetailsViews dont ont a besoin

        if (neededPlayerDetailsViewsNumber < effectivePlayerDetailsViewsNumber) { // Si le nombre de joueurs nécessités a baissé
            for (int i = neededPlayerDetailsViewsNumber; i < effectivePlayerDetailsViewsNumber; i++) {
                this.playerDetailsViews.getChildren().get(i).setDisable(true);
            }

        } else if (neededPlayerDetailsViewsNumber > effectivePlayerDetailsViewsNumber) { // Si le nombre de joueurs nécessités a augmenté
            for (int i = effectivePlayerDetailsViewsNumber-1; i < neededPlayerDetailsViewsNumber; i++) {
                playerDetailsViews.getChildren().get(i).setDisable(false);
            }
        }
    }

    private int getEffectivePlayerDetailsViewsNumber() {
        int effectivePlayerDetailsViewsNumber = 0;

        for (int i = 0; i < playerDetailsViews.getChildren().size(); i++) {
            if (!playerDetailsViews.getChildren().get(i).isDisabled())
                effectivePlayerDetailsViewsNumber++;
        }

        return effectivePlayerDetailsViewsNumber;
    }
    
    private void setStyle() {
        this.playerDetailsViews.setSpacing(10);
        super.setSpacing(20);
        super.setPadding(new Insets(30));
    }

    public PlayerNumberView getPlayerNumberView() {
        return this.playerNumberView;
    }

    public SizeChooserView getSizeChooserView() {
        return this.sizeChooserView;
    }

    public VBox getPlayerDetailsViews() {
        return this.playerDetailsViews;
    }

    public Button getPlayButton() {
        return this.playButton;
    }

    public PlayerDetailsView getPlayerDetailsView(int index) {
        PlayerDetailsView playerDetailsView = null;
        
        if (index >= 0 && index < this.playerDetailsViews.getChildren().size()) {
            playerDetailsView = (PlayerDetailsView) this.playerDetailsViews.getChildren().get(index);
        }

        return playerDetailsView;
    }
}