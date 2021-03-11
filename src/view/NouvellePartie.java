package src.view;

import src.data.Config;
import src.model.PlateauPuzzle;

import javafx.stage.*; //Stage, Modality
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.control.*; //Label, Spinner
import javafx.scene.paint.Color;
import javafx.geometry.*; //Insets, Pos

public class NouvellePartie extends Stage {
    public NouvellePartie(Stage primaryStage, Scene scenePlateau, String titre, PlateauPuzzle plateau){
        HBox hbox = new HBox();
        //-----------------
        Scene scene2 = new Scene(hbox);
        //-----------------
        Label label = new Label("Nombre de pièces :");
        HBox.setMargin(label, new Insets(10));
        label.setTextFill(Color.web(Config.COLOR_TEXT));
        //-----------------
        Spinner<Integer> spinner = new Spinner<>(2, 10, 5);
        HBox.setMargin(spinner, new Insets(10));
        spinner.setMaxWidth(75);
        //-----------------
        Bouton bouton = new Bouton("Valider");
        HBox.setMargin(bouton, new Insets(10));
        bouton.setOnAction(event -> {
            if(Fenetre.getVuePlateau() != null){
                Fenetre.getVuePlateau().buildGrid();
            }
            plateau.supprimeToutePieces();
            plateau.generationAlea(spinner.getValue());
            plateau.setName("");
            primaryStage.setScene(scenePlateau);
            primaryStage.setFullScreen(Config.IS_FULLSCREEN);
            this.close();
        });
        //-----------------
        hbox.getChildren().addAll(label,spinner,bouton);
        hbox.setStyle("-fx-background-color: " + Config.COLOR_INTERFACE + ";");
        hbox.setAlignment(Pos.CENTER);
        //-----------------
        this.setTitle(titre + " - Nouvelle partie");
        this.setScene(scene2);
        this.initModality(Modality.WINDOW_MODAL);
        this.setResizable(false);
        this.initOwner(primaryStage);
        this.show();
    }
}
