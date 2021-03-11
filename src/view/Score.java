package src.view;

import src.data.*; //PartiePuzzle, PartieScore, Config

import javafx.collections.ObservableList;
import javafx.stage.*; //Stage, Popup
import javafx.scene.control.*; //Label, TableView
import javafx.scene.control.TableView.TableViewSelectionModel;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.*; //VBox, HBox
import javafx.scene.text.*; //Text, TextAlignment, Font
import javafx.scene.paint.Color;
import javafx.geometry.*; //Insets, Pos

import java.util.Map;

public class Score extends VBox {

    private final TableView tableParties;
    private static Text textTitre, textParties;
    private static Bouton bouton;
    private static VBox vbox;

    public Score(Stage primaryStage, int largeur){
        textTitre = new Text("Tableau des Scores");
        setMargin(textTitre, new Insets(10));
        textTitre.setFont(Font.font("Verdana", 50));
        textTitre.setFill(Color.web(Config.COLOR_TEXT));
        setMargin(textTitre, new Insets(0,0,30,0));

        HBox hbox = new HBox();

        vbox = new VBox();

        textParties = new Text("Parties les plus jouées");
        setMargin(textParties, new Insets(10));
        textParties.setFont(Font.font("Verdana", 20));
        textParties.setFill(Color.web(Config.COLOR_TEXT));

        this.tableParties = new TableView();
        TableColumn<PartiePuzzle, String> colNom = new TableColumn<>("Nom");
        colNom.setCellValueFactory(new PropertyValueFactory<>("nomPartie"));
        TableColumn<PartiePuzzle, String> colPieces = new TableColumn<>("Pièces");
        colPieces.setCellValueFactory(new PropertyValueFactory<>("listePieces"));
        TableColumn<PartiePuzzle, Integer> colTailleX = new TableColumn<>("Taille x");
        colTailleX.setCellValueFactory(new PropertyValueFactory<>("tailleX"));
        TableColumn<PartiePuzzle, Integer> colTailleY = new TableColumn<>("Taille y");
        colTailleY.setCellValueFactory(new PropertyValueFactory<>("tailleY"));
        tableParties.getColumns().addAll(colNom, colPieces, colTailleX, colTailleY);
        tableParties.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        tableParties.setPlaceholder(new Label("Aucune partie, il est temps de jouer !"));
        setMargin(tableParties, new Insets(10));
        tableParties.setMinWidth(largeur/1.6);

        //test
        this.majDonnee();

        bouton = new Bouton("Charger");
        setMargin(bouton, new Insets(10));


        vbox.getChildren().addAll(textParties, tableParties, bouton);
        vbox.setAlignment(Pos.CENTER);
        vbox.setStyle("-fx-border-color: " + Config.COLOR_TEXT + ";");

        TableView tableScores = new TableView();
        TableColumn<PartieScore, String> colJoueur = new TableColumn<>("Joueur");
        colJoueur.setCellValueFactory(new PropertyValueFactory<>("nomJoueur"));
        TableColumn<PartieScore, Integer> colScore = new TableColumn<>("Score");
        colScore.setCellValueFactory(new PropertyValueFactory<>("score"));
        tableScores.getColumns().addAll(colJoueur, colScore);
        tableScores.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        Label labelAucunScore = new Label("Sélectionnez une partie puis\ncliquez sur 'Charger' pour en voir\nles scores !");
        labelAucunScore.setTextAlignment(TextAlignment.CENTER);       
        tableScores.setPlaceholder(labelAucunScore);
        HBox.setMargin(tableScores, new Insets(10));
        tableScores.setMinWidth(largeur/3.5);

        bouton.setOnAction(event -> {
            try {
                tableScores.getItems().clear();
                TableViewSelectionModel<PartiePuzzle> selectionModel = tableParties.getSelectionModel();
                ObservableList<PartiePuzzle> selectedItems = selectionModel.getSelectedItems();
                PartiePuzzle partieSelectionnee = selectedItems.get(0);
                tableScores.getItems().addAll(partieSelectionnee.getScore());
            } catch (Exception e) {
                Popup popup = new Popup();
                Label labelError = new Label("Aucune partie n'a été sélectionée !");
                labelError.setPadding(new Insets(10));
                labelError.setStyle(" -fx-background-color: " + Config.COLOR_INTERFACE + ";-fx-text-fill: " + Config.COLOR_TEXT + ";-fx-background-radius: 20; -fx-effect: dropshadow(gaussian, rgba(0, 0, 0, 0.4), 10, 0.5, 0.0, 0.0);");
                popup.getContent().add(labelError);
                popup.setAutoHide(true);
                popup.show(primaryStage);
                System.out.println("Aucune partie n'a été selectionée !");
            }
        });

        hbox.getChildren().addAll(vbox, tableScores);
        hbox.setAlignment(Pos.CENTER);
        hbox.setPadding(new Insets(10));

        this.getChildren().addAll(textTitre, hbox);
        this.setAlignment(Pos.CENTER);
        this.setStyle("-fx-background-color: " + Config.COLOR_INTERFACE + ";");
    }

    public static void styleMisAJour(){
        textTitre.setFill(Color.web(Config.COLOR_TEXT));
        textParties.setFill(Color.web(Config.COLOR_TEXT));

        vbox.setStyle("-fx-border-color: " + Config.COLOR_TEXT + ";");

        bouton.changerCouleur(Config.COLOR_TEXT, Config.COLOR_INTERFACE);
    }

    public void majDonnee(){
        this.tableParties.getItems().clear();
        LectureScores tab = new LectureScores();
        for (PartiePuzzle pz : new LectureParties(Config.PATH_PARTIES).getPartiePuzzles()){
            for (Map.Entry<String, Integer> entry : tab.getTableauScores(pz.getNomPartie()).entrySet()) {
                pz.ajouterScore(new PartieScore(entry.getKey(), entry.getValue()));
            }
            this.tableParties.getItems().add(pz);
        }
        for (PartiePuzzle pz : new LectureParties(Config.PATH_PARTIES_PREDEF).getPartiePuzzles()){
            for (Map.Entry<String, Integer> entry : tab.getTableauScores(pz.getNomPartie()).entrySet()) {
                pz.ajouterScore(new PartieScore(entry.getKey(), entry.getValue()));
            }
            this.tableParties.getItems().add(pz);
        }

    }

}
