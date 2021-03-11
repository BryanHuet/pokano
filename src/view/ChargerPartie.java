package src.view;

import src.data.*; //Config, LectureParties, PartiePuzzle, Suppression
import src.model.PlateauPuzzle;

import javafx.stage.*; //Stage, Modality, Popup
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.*; //Label, TableColumn, TableView
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.*; //HBox, VBox
import javafx.scene.paint.Color;
import javafx.scene.text.*; //Font, FontWeight, Text, TextAlignment
import javafx.geometry.*; //Insets, Pos


public class ChargerPartie extends Stage {
    public ChargerPartie(Stage primaryStage, String titre, Scene scenePlateau, PlateauPuzzle plateau){
        VBox vbox = new VBox();
        //-----------------
        Scene scene2 = new Scene(vbox);
        //-----------------
        Text text = new Text("Charger une Partie");
        text.setFill(Color.web(Config.COLOR_TEXT));
        text.setFont(Font.font("Verdana", FontWeight.BOLD, 30));
        //-----------------
        HBox hbox = new HBox();

        VBox vboxPredef = new VBox();
        Label labelPredef = new Label("Parties\nprédéfinies");
        labelPredef.setFont(new Font("Verdana", 20));
        VBox.setMargin(labelPredef, new Insets(10));
        labelPredef.setTextFill(Color.web(Config.COLOR_TEXT));
        labelPredef.setTextAlignment(TextAlignment.CENTER);

        //def des deux tableaux
        TableView tablePredef = new TableView();
        TableView tableSauv = new TableView();

        //paramétrage du tableau du Parties Prédéfinies
        TableColumn<PartiePuzzle, String> colNomPredef = new TableColumn<>("Nom");
        colNomPredef.setCellValueFactory(new PropertyValueFactory<>("nomPartie"));
        TableColumn<PartiePuzzle, String> colPiecesPredef = new TableColumn<>("Pièces");
        colPiecesPredef.setCellValueFactory(new PropertyValueFactory<>("listePieces"));
        TableColumn<PartiePuzzle, Integer> colTailleXPredef = new TableColumn<>("Taille x");
        colTailleXPredef.setCellValueFactory(new PropertyValueFactory<>("tailleX"));
        TableColumn<PartiePuzzle, Integer> colTailleYPredef = new TableColumn<>("Taille y");
        colTailleYPredef.setCellValueFactory(new PropertyValueFactory<>("tailleY"));
        tablePredef.getColumns().addAll(colNomPredef, colPiecesPredef, colTailleXPredef, colTailleYPredef);
        tablePredef.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        Label labelAucunPredef = new Label("Aucune partie\nprédéfinie enregistrée");
        labelAucunPredef.setTextAlignment(TextAlignment.CENTER);
        tablePredef.setPlaceholder(labelAucunPredef);
        VBox.setMargin(tablePredef, new Insets(10));

        vboxPredef.getChildren().addAll(labelPredef, tablePredef);
        vboxPredef.setAlignment(Pos.CENTER);

        VBox vboxSauv = new VBox();
        Label labelSauv = new Label("Parties\nsauvegardées");
        labelSauv.setFont(new Font("Verdana", 20));
        VBox.setMargin(labelSauv, new Insets(10));
        labelSauv.setTextFill(Color.web(Config.COLOR_TEXT));
        labelSauv.setTextAlignment(TextAlignment.CENTER);

        //paramétrage du tableau du Parties Sauvegardée
        TableColumn<PartiePuzzle, String> colNomSauv = new TableColumn<>("Nom");
        colNomSauv.setCellValueFactory(new PropertyValueFactory<>("nomPartie"));
        TableColumn<PartiePuzzle, String> colPiecesSauv = new TableColumn<>("Pièces");
        colPiecesSauv.setCellValueFactory(new PropertyValueFactory<>("listePieces"));
        TableColumn<PartiePuzzle, Integer> colTailleXSauv = new TableColumn<>("Taille x");
        colTailleXSauv.setCellValueFactory(new PropertyValueFactory<>("tailleX"));
        TableColumn<PartiePuzzle, Integer> colTailleYSauv = new TableColumn<>("Taille y");
        colTailleYSauv.setCellValueFactory(new PropertyValueFactory<>("tailleY"));
        tableSauv.getColumns().addAll(colNomSauv, colPiecesSauv, colTailleXSauv, colTailleYSauv);
        tableSauv.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        tableSauv.setPlaceholder(new Label("Aucune partie sauvegardée"));

        // On fait en sorte de clear la selection d'une table view si l'on clique sur l'autre.
        //largement insipiré de : https://stackoverflow.com/questions/14965521/two-tableview-and-just-one-selection-with-javafx
        scene2.focusOwnerProperty().addListener((observableValue, node, t1) -> {
            if (t1 == tablePredef) {
                tableSauv.getSelectionModel().clearSelection();
            }
            if (t1 == tableSauv) {
                tablePredef.getSelectionModel().clearSelection();
            }
        });
        for (PartiePuzzle pz : new LectureParties(Config.PATH_PARTIES_PREDEF).getPartiePuzzles()){
            tablePredef.getItems().addAll(pz);
        }
        for (PartiePuzzle pz : new LectureParties(Config.PATH_PARTIES).getPartiePuzzles()){
            tableSauv.getItems().addAll(pz);
        }
        VBox.setMargin(tableSauv, new Insets(10));

        vboxSauv.getChildren().addAll(labelSauv, tableSauv);
        vboxSauv.setAlignment(Pos.CENTER);

        hbox.getChildren().addAll(vboxPredef, vboxSauv);
        hbox.setAlignment(Pos.CENTER);

        //--- popup affichée si rien n'a ete selectionnee
        Popup popup = new Popup();
        Label labelError = new Label();
        labelError.setPadding(new Insets(10));
        labelError.setStyle(" -fx-background-color: " + Config.COLOR_INTERFACE + ";-fx-text-fill: " + Config.COLOR_TEXT + ";-fx-background-radius: 20; -fx-effect: dropshadow(gaussian, rgba(0, 0, 0, 0.4), 10, 0.5, 0.0, 0.0);");
        popup.getContent().add(labelError);
        popup.setAutoHide(true);
        //-----------------
        Bouton boutonOuvrir = new Bouton("Ouvrir la partie sélectionnée");
        VBox.setMargin(boutonOuvrir, new Insets(10));
        boutonOuvrir.setOnAction(event -> {
            try {
                TableView.TableViewSelectionModel selectionModel = tablePredef.getSelectionModel(); //on regarde la sélection du tableau predef
                if (selectionModel.getSelectedItem() == null) { //si rien n'est sélectionné dans le plateau predef
                    selectionModel = tableSauv.getSelectionModel(); //on regarde la sélection dans le tableau des parties saves
                }
                ObservableList selectedItems = selectionModel.getSelectedItems();
                PartiePuzzle partieSelectionnee = (PartiePuzzle) selectedItems.get(0);
                plateau.replace(partieSelectionnee.getPlateauPuzzle()); //on remplace le plateau de Titre par celui de la partie créée

                primaryStage.setScene(scenePlateau);
                primaryStage.setFullScreen(Config.IS_FULLSCREEN);
                this.close();
            }
            catch (Exception e) {
                labelError.setText("Aucune partie n'a été sélectionée !");
                popup.show(this);
            }
        });
        //-----------------
        Bouton boutonSuppr = new Bouton("Supprimer la partie sélectionnée");
        VBox.setMargin(boutonSuppr, new Insets(10));
        boutonSuppr.setOnAction(event -> {
            try {
                TableView.TableViewSelectionModel selectionModel = tableSauv.getSelectionModel();
                ObservableList selectedItems = selectionModel.getSelectedItems();
                PartiePuzzle partieSelectionnee = (PartiePuzzle) selectedItems.get(0);
                new Suppression(partieSelectionnee.getNomPartie());
                tableSauv.getItems().remove(partieSelectionnee);
            }
            catch (Exception e){
                labelError.setText("Il est impossible de supprimer une partie prédéfinie.");
                popup.show(this);
            }
        });
        //-----------------
        vbox.getChildren().addAll(text, hbox, boutonOuvrir, boutonSuppr);
        vbox.setStyle("-fx-background-color: " + Config.COLOR_INTERFACE + ";");
        vbox.setAlignment(Pos.CENTER);
        //-----------------
        this.setTitle(titre + " - Charger une partie");
        this.setScene(scene2);
        this.initModality(Modality.WINDOW_MODAL);
        this.setResizable(false);
        this.initOwner(primaryStage);
        this.show();
    }
}
