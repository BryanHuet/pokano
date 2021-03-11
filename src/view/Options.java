package src.view;

import src.data.Config;
import src.model.piece.Piece;

import javafx.stage.Stage;
import javafx.scene.layout.*; //VBox, HBox, GridPane
import javafx.scene.control.*; //Label, ComboBox, Spinner, CheckBox
import javafx.scene.text.*; //Text, Font
import javafx.scene.paint.Color;
import javafx.geometry.*; //Insets, Pos

public class Options extends VBox {

    private final Text textTitre;
    private final Label labelCouleurFond, labelCouleurText, labelPiecesDiff, labelDimPieces, labelCouleurPieces, labelCouleurGrille, labelFullscreen;
    private final Pane case1, case2;
    private final ComboBox<Piece> comboPieces;
    private final ComboBox<String> comboCouleurPieces;

    public Options(Stage primaryStage){
        this.textTitre = new Text("Options");
        this.textTitre.setFont(Font.font("Verdana", 50));
        this.textTitre.setFill(Color.web(Config.COLOR_TEXT));
        setMargin(this.textTitre, new Insets(0,0,30,0));

        GridPane grid = new GridPane();
        //--------------------------
        this.labelCouleurFond = new Label("Couleur du fond");
        this.labelCouleurFond.setTextFill(Color.web(Config.COLOR_TEXT));
        GridPane.setMargin(this.labelCouleurFond, new Insets(10));
        GridPane.setConstraints(this.labelCouleurFond, 0, 0);

        ComboBox<String> comboCouleurFond = new ComboBox<>();
        comboCouleurFond.getItems().addAll(Config.getListeNomCouleurs());
        comboCouleurFond.getSelectionModel().select(Config.getListeNomCouleurs().indexOf(Config.getKey(Config.listeCouleurs, Config.COLOR_INTERFACE)));
        comboCouleurFond.setVisibleRowCount(7);
        GridPane.setMargin(labelCouleurFond, new Insets(10));
        GridPane.setConstraints(comboCouleurFond, 1, 0);
        //--------------------------
        this.labelCouleurText = new Label("Couleur du texte");
        this.labelCouleurText.setTextFill(Color.web(Config.COLOR_TEXT));
        GridPane.setMargin(this.labelCouleurText, new Insets(10));
        GridPane.setConstraints(this.labelCouleurText, 0, 1);

        ComboBox<String> comboCouleurText = new ComboBox<>();
        comboCouleurText.getItems().addAll(Config.getListeNomCouleurs());
        comboCouleurText.getSelectionModel().select(Config.getListeNomCouleurs().indexOf(Config.getKey(Config.listeCouleurs, Config.COLOR_TEXT)));
        comboCouleurText.setVisibleRowCount(7);
        GridPane.setMargin(comboCouleurText, new Insets(10));
        GridPane.setConstraints(comboCouleurText, 1, 1);
        //--------------------------
        this.labelPiecesDiff = new Label("Pièces différentes en une partie");
        this.labelPiecesDiff.setTextFill(Color.web(Config.COLOR_TEXT));
        GridPane.setMargin(this.labelPiecesDiff, new Insets(10));
        GridPane.setConstraints(this.labelPiecesDiff, 0, 2);

        Spinner<Integer> spinnerPiecesDiff = new Spinner<>(1, 13, 13);
        spinnerPiecesDiff.setMaxWidth(75);
        //spinnerPiecesDiff.setEditable(true);
        GridPane.setMargin(spinnerPiecesDiff, new Insets(10));
        GridPane.setConstraints(spinnerPiecesDiff, 1, 2);
        //--------------------------
        this.labelDimPieces = new Label("Dimensions Max des pièces");
        this.labelDimPieces.setTextFill(Color.web(Config.COLOR_TEXT));
        GridPane.setMargin(this.labelDimPieces, new Insets(10));
        GridPane.setConstraints(this.labelDimPieces, 0, 3);

        Spinner<Integer> spinnerDimPieces = new Spinner<>(5, 10, 7);
        spinnerDimPieces.setMaxWidth(75);
        //spinnerDimPieces.setEditable(true);
        GridPane.setMargin(spinnerDimPieces, new Insets(10));
        GridPane.setConstraints(spinnerDimPieces, 1, 3);
        //--------------------------
        this.labelCouleurPieces = new Label("Couleurs des pièces");
        this.labelCouleurPieces.setTextFill(Color.web(Config.COLOR_TEXT));
        GridPane.setMargin(this.labelCouleurPieces, new Insets(10));
        GridPane.setConstraints(this.labelCouleurPieces, 0, 4);

        HBox hbox1 = new HBox();

        this.comboPieces = new ComboBox<>();
        this.comboPieces.getItems().addAll(Config.listePieces);
        this.comboPieces.getSelectionModel().select(0);//Pièce A
        this.comboPieces.setVisibleRowCount(7);
        HBox.setMargin(this.comboPieces, new Insets(10));

        this.comboCouleurPieces = new ComboBox<>();
        this.comboCouleurPieces.getItems().addAll(Config.getListeNomCouleurs());
        this.comboCouleurPieces.getSelectionModel().select(Config.getListeNomCouleurs().indexOf(Config.getKey(Config.listeCouleurs, Config.COLOR_PIECE_A)));
        this.comboCouleurPieces.setVisibleRowCount(7);

        HBox.setMargin(this.comboCouleurPieces, new Insets(10));
        
        this.case1 = new Pane();
        this.case1.setMinSize(30,30);
        this.case1.setMaxSize(30,30);
        this.case1.setStyle("-fx-background-color: " + Config.COLOR_PIECE_A + ";-fx-border-color: black;");
        HBox.setMargin(this.case1, new Insets(10));

        hbox1.getChildren().addAll(this.comboPieces, this.comboCouleurPieces, this.case1);
        hbox1.setAlignment(Pos.CENTER);
        GridPane.setMargin(hbox1, new Insets(10));
        GridPane.setConstraints(hbox1, 1, 4);
        //--------------------------
        this.labelCouleurGrille = new Label("Couleur de la grille");
        this.labelCouleurGrille.setTextFill(Color.web(Config.COLOR_TEXT));
        GridPane.setMargin(this.labelCouleurGrille, new Insets(10));
        GridPane.setConstraints(this.labelCouleurGrille, 0, 5);

        HBox hbox2 = new HBox();

        ComboBox<String> comboCouleurGrille = new ComboBox<>();
        comboCouleurGrille.getItems().addAll(Config.getListeNomCouleurs());
        comboCouleurGrille.getSelectionModel().select(Config.getListeNomCouleurs().indexOf(Config.getKey(Config.listeCouleurs, Config.COLOR_GRID)));
        comboCouleurGrille.setVisibleRowCount(7);
        HBox.setMargin(comboCouleurGrille, new Insets(10));

        this.case2 = new Pane();
        this.case2.setMinSize(30,30);
        this.case2.setMaxSize(30,30);
        this.case2.setStyle("-fx-background-color: " + Config.COLOR_GRID + ";-fx-border-color: black;");
        HBox.setMargin(this.case2, new Insets(10));

        hbox2.getChildren().addAll(comboCouleurGrille, this.case2);
        hbox2.setAlignment(Pos.CENTER);

        GridPane.setMargin(hbox2, new Insets(10));
        GridPane.setConstraints(hbox2, 1, 5);
        //--------------------------
        this.labelFullscreen = new Label("Plein écran");
        this.labelFullscreen.setTextFill(Color.web(Config.COLOR_TEXT));
        GridPane.setMargin(this.labelFullscreen, new Insets(10));
        GridPane.setConstraints(this.labelFullscreen, 0, 6);

        CheckBox checkFullscreen = new CheckBox();
        GridPane.setMargin(checkFullscreen, new Insets(10));
        GridPane.setConstraints(checkFullscreen, 1, 6);
        //--------------------------
        comboCouleurFond.setOnAction(e -> {
            Config.COLOR_INTERFACE = Config.listeCouleurs.get(comboCouleurFond.getValue());
            styleMisAJour();
        });

        comboCouleurText.setOnAction(e -> {
            Config.COLOR_TEXT = Config.listeCouleurs.get(comboCouleurText.getValue());
            styleMisAJour();
        });

        this.comboPieces.setOnAction(e -> {
            comboCouleurPieces.getSelectionModel().select(Config.getListeNomCouleurs().indexOf(Config.getKey(Config.listeCouleurs, Config.MAKE_TEST_COLOR_PIECE(comboPieces.getValue()))));
            styleMisAJour();
        });

        this.comboCouleurPieces.setOnAction(e -> {
            Config.CHANGE_COLOR_PIECE(comboPieces.getValue(),Config.listeCouleurs.get(comboCouleurPieces.getValue()));
            styleMisAJour();
        });

        comboCouleurGrille.setOnAction(e -> {
            Config.COLOR_GRID = Config.listeCouleurs.get(comboCouleurGrille.getValue());
            styleMisAJour();
        });

        checkFullscreen.setOnAction(e -> {
            Config.IS_FULLSCREEN = checkFullscreen.isSelected();
            primaryStage.setFullScreen(Config.IS_FULLSCREEN);
        });
        //--------------------------
        grid.getChildren().addAll(this.labelCouleurFond, comboCouleurFond, this.labelCouleurText, comboCouleurText, this.labelPiecesDiff, spinnerPiecesDiff, this.labelDimPieces, spinnerDimPieces, this.labelCouleurPieces, hbox1, this.labelCouleurGrille, hbox2, this.labelFullscreen, checkFullscreen);
        grid.setHgap(60);
        grid.setVgap(20);
        grid.setAlignment(Pos.CENTER);

        this.getChildren().addAll(this.textTitre, grid);
        this.setAlignment(Pos.CENTER);
        this.setStyle("-fx-background-color: " + Config.COLOR_INTERFACE + ";");
    }

    public void styleMisAJour(){
        this.setStyle("-fx-background-color: " + Config.COLOR_INTERFACE + ";");
        
        this.textTitre.setFill(Color.web(Config.COLOR_TEXT));
        this.labelCouleurFond.setTextFill(Color.web(Config.COLOR_TEXT));
        this.labelCouleurText.setTextFill(Color.web(Config.COLOR_TEXT));
        this.labelPiecesDiff.setTextFill(Color.web(Config.COLOR_TEXT));
        this.labelDimPieces.setTextFill(Color.web(Config.COLOR_TEXT));
        this.labelCouleurPieces.setTextFill(Color.web(Config.COLOR_TEXT));
        this.labelCouleurGrille.setTextFill(Color.web(Config.COLOR_TEXT));
        this.labelFullscreen.setTextFill(Color.web(Config.COLOR_TEXT)); 


        this.case1.setStyle("-fx-background-color: " + Config.MAKE_TEST_COLOR_PIECE(comboPieces.getValue()) + ";-fx-border-color: black;");

        this.case2.setStyle("-fx-background-color: " + Config.COLOR_GRID + ";-fx-border-color: black;");

        Fenetre.styleMisAJour();
        Titre.styleMisAJour();
        Credits.styleMisAJour();
        Score.styleMisAJour();
        PanelNord.styleMisAJour();
        PanelEst.styleMisAJour();
        PanelOuest.styleMisAJour();
    }
}
