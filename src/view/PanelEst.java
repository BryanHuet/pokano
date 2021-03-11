package src.view;

import src.data.*; //Config, EcritureParties, LectureParties, PartiePuzzle
import src.model.*; //ModeleEcoutable, PlateauPuzzle
import src.model.ecouteur.EcouteurModele;

import javafx.stage.*; //Stage, Modality
import javafx.scene.Scene;
import javafx.scene.layout.*; //VBox, GridPane
import javafx.scene.control.*; //Label, Textfield
import javafx.scene.paint.Color;
import javafx.geometry.*; //Insets, Pos

public class PanelEst extends VBox implements EcouteurModele {

  private final PlateauPuzzle plateauPuzzle;
  private static Label scoreJoueur, labelScore;
  private static Bouton buttonSauv, buttonScore;
  private Score score;

  public PanelEst(PlateauPuzzle plateauPuzzle, Stage primaryStage, String titre){
    this.plateauPuzzle = plateauPuzzle;
    this.plateauPuzzle.ajoutEcouteur(this);

    labelScore = new Label("Score Actuel :");
    setMargin(labelScore, new Insets(10));
    labelScore.setTextFill(Color.web(Config.COLOR_TEXT));

    scoreJoueur = new Label("" + plateauPuzzle.espaceOccupe());
    setMargin(scoreJoueur, new Insets(10));
    scoreJoueur.setTextFill(Color.web(Config.COLOR_TEXT));
    scoreJoueur.setStyle("-fx-font-size: 20px;-fx-font-weight: bold;");

    buttonSauv = new Bouton("Sauvegarder\nla partie");
    setMargin(buttonSauv, new Insets(10));
    buttonSauv.setOnAction(event -> fenetreSauvegarderPartie(primaryStage, titre));

    buttonScore = new Bouton("Enregistrer\nle Score");
    setMargin(buttonScore, new Insets(10));
    buttonScore.setOnAction(event -> fenetreEnregistrerScore(primaryStage, titre));

    this.getChildren().addAll(labelScore, scoreJoueur, buttonSauv, buttonScore);
    this.setAlignment(Pos.TOP_CENTER);
  }

  public void fenetreSauvegarderPartie(Stage primaryStage, String titre){
    Stage secondStage = new Stage();
    GridPane grid = new GridPane();
    grid.setPadding(new Insets(10));
    grid.setHgap(10);
    grid.setVgap(10);
    //-----------------
    Scene scene2 = new Scene(grid);
    //-----------------
    Label labelNom = new Label("Nom de la partie :");
    labelNom.setTextFill(Color.web(Config.COLOR_TEXT));
    grid.add(labelNom, 0, 0);
    //-----------------
    TextField fieldNom = new TextField();
    grid.add(fieldNom, 0, 1);
    //-----------------

    LectureParties test = new LectureParties(Config.PATH_PARTIES);
    for(PartiePuzzle pz : test.getPartiePuzzles()){
      if(pz.getNomPartie().equals(this.plateauPuzzle.getName())){
        fieldNom.setText(pz.getNomPartie());
      }
    }
    Bouton bouton = new Bouton("Valider");
    bouton.setOnAction(event -> {
      if(!fieldNom.getText().equals("")){
      EcritureParties ep = new EcritureParties(plateauPuzzle,fieldNom.getText(),"MOI");
      secondStage.close();
      }
    });
    grid.add(bouton, 1, 1);
    //-----------------
    grid.setStyle("-fx-background-color: " + Config.COLOR_INTERFACE + ";");
    //-----------------
    secondStage.setTitle(titre + " - Sauvegarder la partie");
    secondStage.setScene(scene2);
    secondStage.initModality(Modality.WINDOW_MODAL);
    secondStage.setResizable(false); 
    secondStage.initOwner(primaryStage);
    secondStage.show();
  }

  public void fenetreEnregistrerScore(Stage primaryStage, String titre){
    Stage secondStage = new Stage();
    GridPane grid = new GridPane();
    grid.setPadding(new Insets(10));
    grid.setHgap(10);
    grid.setVgap(10);
    //-----------------
    Scene scene2 = new Scene(grid);
    //-----------------
    Label labelNom = new Label("Nom du Joueur :");
    labelNom.setTextFill(Color.web(Config.COLOR_TEXT));
    grid.add(labelNom, 0, 0);
    //-----------------
    TextField fieldNom = new TextField();
    grid.add(fieldNom, 0, 1);
    //-----------------
    Bouton bouton = new Bouton("Valider");
    bouton.setOnAction(event -> {
      EcritureScores es = new EcritureScores(plateauPuzzle, plateauPuzzle.getName(), fieldNom.getText());
      PanelEst.this.score.majDonnee();
      secondStage.close();
    });
    grid.add(bouton, 1, 1);
    //-----------------
    grid.setStyle("-fx-background-color: " + Config.COLOR_INTERFACE + ";");
    //-----------------
    secondStage.setTitle(titre + " - Enregistrer le score");
    secondStage.setScene(scene2);
    secondStage.initModality(Modality.WINDOW_MODAL);
    secondStage.setResizable(false); 
    secondStage.initOwner(primaryStage);
    secondStage.show();
  }

  public void modeleMisAJour(Object source){
    scoreJoueur.setText("" + this.plateauPuzzle.espaceOccupe());
  }

  public static void styleMisAJour(){
    labelScore.setTextFill(Color.web(Config.COLOR_TEXT));
    scoreJoueur.setTextFill(Color.web(Config.COLOR_TEXT));

    buttonSauv.changerCouleur(Config.COLOR_TEXT, Config.COLOR_INTERFACE);
    buttonScore.changerCouleur(Config.COLOR_TEXT, Config.COLOR_INTERFACE);
  }

  public void setScore(Score score){
    this.score=score;
  }

}
