package src.view;

import src.model.PlateauPuzzle;
import src.data.Config;

import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.geometry.*; //Insets, Pos

public class PanelNord extends HBox {

  private static Bouton boutonNouvellePartie, boutonChargerPartie, boutonRetourMenu;

  public PanelNord(Stage primaryStage, String titre, Scene sceneMenu, Scene scenePlateau, PlateauPuzzle plateau){
    boutonNouvellePartie = new Bouton("Nouvelle Partie");
    setMargin(boutonNouvellePartie, new Insets(10));
    boutonNouvellePartie.setOnAction(event -> new NouvellePartie(primaryStage, scenePlateau, titre, plateau));

    boutonChargerPartie = new Bouton("Charger une partie");
    setMargin(boutonChargerPartie, new Insets(10));
    boutonChargerPartie.setOnAction(event -> new ChargerPartie(primaryStage, titre, scenePlateau, plateau));

    boutonRetourMenu = new Bouton("Retour au Menu");
    setMargin(boutonRetourMenu, new Insets(10));
    boutonRetourMenu.setOnAction(event -> {
      primaryStage.setScene(sceneMenu);
      primaryStage.setFullScreen(Config.IS_FULLSCREEN);
    });

    this.getChildren().addAll(boutonNouvellePartie, boutonChargerPartie, boutonRetourMenu);
    //this.getChildren().addAll(boutonRetourMenu);
    this.setAlignment(Pos.TOP_CENTER);
  }

  public static void styleMisAJour(){
    boutonNouvellePartie.changerCouleur(Config.COLOR_TEXT, Config.COLOR_INTERFACE);
    boutonChargerPartie.changerCouleur(Config.COLOR_TEXT, Config.COLOR_INTERFACE);
    boutonRetourMenu.changerCouleur(Config.COLOR_TEXT, Config.COLOR_INTERFACE);
  }

}
