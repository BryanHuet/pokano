package src.view;

import src.data.*;
import src.model.PlateauPuzzle;
import src.model.ia.Robot;

import javafx.scene.layout.VBox;
import javafx.scene.control.*; //Label, ComboBox
import javafx.scene.text.TextAlignment;
import javafx.scene.paint.Color;
import javafx.geometry.*; //Insets, Pos

public class PanelOuest extends VBox{

	private static Label labelScore, scoreJoueur, labelStrategy;
	private static Bouton boutonIA;

	public PanelOuest(PlateauPuzzle plateauPuzzle){
		labelScore = new Label("Meilleur Score\npour cette partie :");
		setMargin(labelScore, new Insets(10));
		labelScore.setTextFill(Color.web(Config.COLOR_TEXT));
		labelScore.setTextAlignment(TextAlignment.CENTER);

	    scoreJoueur = new Label("Aucun");
	    setMargin(scoreJoueur, new Insets(10));
	    scoreJoueur.setTextFill(Color.web(Config.COLOR_TEXT));
	    scoreJoueur.setStyle("-fx-font-size: 20px;-fx-font-weight: bold;");

		labelStrategy = new Label("Générer une solution :");
		setMargin(labelStrategy, new Insets(10));
		labelStrategy.setTextFill(Color.web(Config.COLOR_TEXT));

		ComboBox<String> comboStrategy = new ComboBox<>();
		comboStrategy.getItems().addAll(Config.getListeStrategy());
		comboStrategy.getSelectionModel().select(0);
		VBox.setMargin(comboStrategy, new Insets(10));

		boutonIA = new Bouton("Afficher une solution");
		VBox.setMargin(boutonIA, new Insets(10));
		boutonIA.setOnAction(event -> {
			Robot robot = new Robot(plateauPuzzle);
			robot.appliqueStrategy(Config.listeStrategy.get(comboStrategy.getValue()));
		});

		this.getChildren().addAll(labelScore, scoreJoueur, labelStrategy, comboStrategy, boutonIA);
		this.setAlignment(Pos.TOP_CENTER);
	}

	public static void styleMisAJour(){
	    labelScore.setTextFill(Color.web(Config.COLOR_TEXT));
	    scoreJoueur.setTextFill(Color.web(Config.COLOR_TEXT));
		labelStrategy.setTextFill(Color.web(Config.COLOR_TEXT));
		boutonIA.changerCouleur(Config.COLOR_TEXT, Config.COLOR_INTERFACE);
  	}
}