package src.view;

import javafx.scene.control.Button;
import src.data.Config;

public class Bouton extends Button {

    private String BUTTON_STYLE;
    private String HOVERED_BUTTON_STYLE;

    public Bouton(String nom){
        this.BUTTON_STYLE = "-fx-background-color: " + Config.COLOR_TEXT + "; -fx-background-radius: 30; -fx-text-fill: " + Config.COLOR_INTERFACE + ";";
        this.HOVERED_BUTTON_STYLE = "-fx-background-color: silver; -fx-background-radius: 30; -fx-text-fill: " + Config.COLOR_INTERFACE + ";";

        this.setText(nom);
        this.setStyle(this.BUTTON_STYLE);
        this.setOnMouseExited(e -> this.setStyle(this.BUTTON_STYLE));
        this.setOnMouseEntered(e -> this.setStyle(this.HOVERED_BUTTON_STYLE));
    }

    public void changerCouleur(String nouveauFond, String nouveauTexte){
        this.BUTTON_STYLE = "-fx-background-color: " + nouveauFond + "; -fx-background-radius: 30; -fx-text-fill: " + nouveauTexte + ";";
        this.HOVERED_BUTTON_STYLE = "-fx-background-color: silver; -fx-background-radius: 30; -fx-text-fill: " + nouveauTexte + ";";

        this.setStyle(this.BUTTON_STYLE);
        this.setOnMouseExited(e -> this.setStyle(this.BUTTON_STYLE));
        this.setOnMouseEntered(e -> this.setStyle(this.HOVERED_BUTTON_STYLE));
    }
}
