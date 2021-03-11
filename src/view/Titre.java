package src.view;

import src.model.PlateauPuzzle;
import src.data.*; //PartiePuzzle, PartieScore, Config

import javafx.stage.*; //Stage, Modality
import javafx.scene.*; //Scene, Node
import javafx.scene.layout.*; //VBox, HBox
import javafx.scene.text.*; //Text, TextAlignment, Font, FontPosture
import javafx.scene.paint.Color;
import javafx.geometry.*; //Insets, Pos

public class Titre extends VBox {

    public static PlateauPuzzle plateau;
    private static Text textTitre;
    private static Bouton boutonNouvPartie, boutonChargerPartie, boutonScores, boutonConfig, boutonCredits, boutonQuitter;

    public Titre(Stage primaryStage, Scene scenePlateau, Scene sceneScore, Scene sceneOptions, Scene sceneCredits, String titre, PlateauPuzzle plateau){
        textTitre = new Text(titre);
        textTitre.setFill(Color.web(Config.COLOR_TEXT));
        textTitre.setFont(Font.loadFont(Config.PATH_TITLE_FONT, 70));
        setMargin(textTitre, new Insets(0,0,100,0));

        boutonNouvPartie = new Bouton("Nouvelle Partie");
        setMargin(boutonNouvPartie, new Insets(10));
        boutonNouvPartie.setOnAction(event -> new NouvellePartie(primaryStage, scenePlateau, titre, plateau));

        boutonChargerPartie = new Bouton("Charger une Partie");
        setMargin(boutonChargerPartie, new Insets(10));
        boutonChargerPartie.setOnAction(event -> new ChargerPartie(primaryStage, titre, scenePlateau, plateau));

        boutonScores = new Bouton("Tableau des Scores");
        setMargin(boutonScores, new Insets(10));
        boutonScores.setOnAction(event -> {
            primaryStage.setScene(sceneScore);
            primaryStage.setFullScreen(Config.IS_FULLSCREEN);
        });

        boutonConfig = new Bouton("Options");
        setMargin(boutonConfig, new Insets(10));
        boutonConfig.setOnAction(event -> {
            primaryStage.setScene(sceneOptions);
            primaryStage.setFullScreen(Config.IS_FULLSCREEN);
        });

        boutonCredits = new Bouton("Crédits");
        setMargin(boutonCredits, new Insets(10));
        boutonCredits.setOnAction(event -> {
            primaryStage.setScene(sceneCredits);
            primaryStage.setFullScreen(Config.IS_FULLSCREEN);
        });

        boutonQuitter = new Bouton("Quitter");
        setMargin(boutonQuitter, new Insets(10));
        boutonQuitter.setOnAction(event -> primaryStage.close());

        this.getChildren().addAll(textTitre, boutonNouvPartie, boutonChargerPartie, boutonScores, boutonConfig, boutonCredits, boutonQuitter);
        this.setAlignment(Pos.CENTER);
        this.setStyle("-fx-padding: 5; -fx-background-color: " + Config.COLOR_INTERFACE + ";");
    }

    public static void styleMisAJour(){
        textTitre.setFill(Color.web(Config.COLOR_TEXT));

        boutonNouvPartie.changerCouleur(Config.COLOR_TEXT, Config.COLOR_INTERFACE);
        boutonChargerPartie.changerCouleur(Config.COLOR_TEXT, Config.COLOR_INTERFACE);
        boutonScores.changerCouleur(Config.COLOR_TEXT, Config.COLOR_INTERFACE);
        boutonConfig.changerCouleur(Config.COLOR_TEXT, Config.COLOR_INTERFACE);
        boutonCredits.changerCouleur(Config.COLOR_TEXT, Config.COLOR_INTERFACE);
        boutonQuitter.changerCouleur(Config.COLOR_TEXT, Config.COLOR_INTERFACE);
    }

    public void setVuePlateau() {
    }

    public static void setPlateau(PlateauPuzzle nouveauPlateau) {
        plateau = nouveauPlateau;
    }
}
