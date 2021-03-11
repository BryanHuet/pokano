package src.view;

import src.model.*; //EcouteurModele, PlateauPuzzle
import src.model.ia.*; //BrutForce, Robot
import src.model.ecouteur.EcouteurModele;
import src.data.Config;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.*; //BorderPane, VBox
import javafx.scene.input.*; //KeyCode, KeyEvent
import javafx.scene.image.Image;
import javafx.geometry.*; //Insets, Pos

public class Fenetre extends Application implements EcouteurModele {

    private PlateauPuzzle plateauPuzzle;
    private static VuePlateau vuePlateau;
    private Scene sceneMenu;
    private static BorderPane borderPane;
    public static Titre ecranTitre;
    private static Credits credits;
    private static Score score;
    private static Bouton boutonRetourCredits, boutonRetourScore, boutonRetourOptions;

    public void build(Stage primaryStage){
        String titre = "POKANO";
        int largeur = 1000;
        int hauteur = 750;
        Config.remplirListeCouleur();

        borderPane = new BorderPane();
        Scene scenePlateau = new Scene(borderPane, largeur, hauteur);

        credits = new Credits(titre);
        score = new Score(primaryStage, largeur);
        Options options = new Options(primaryStage);

        boutonRetourCredits = new Bouton("Retour");
        VBox.setMargin(boutonRetourCredits, new Insets(10));
        boutonRetourCredits.setOnAction(event -> {
            primaryStage.setScene(sceneMenu);
            primaryStage.setFullScreen(Config.IS_FULLSCREEN);
        });

        boutonRetourScore = new Bouton("Retour");
        VBox.setMargin(boutonRetourScore, new Insets(10));
        boutonRetourScore.setOnAction(event -> {
            primaryStage.setScene(sceneMenu);
            primaryStage.setFullScreen(Config.IS_FULLSCREEN);
        });

        boutonRetourOptions = new Bouton("Fermer");
        VBox.setMargin(boutonRetourOptions, new Insets(10));
        boutonRetourOptions.setOnAction(event -> {
            primaryStage.setScene(sceneMenu);
            primaryStage.setFullScreen(Config.IS_FULLSCREEN);
        });

        credits.getChildren().add(boutonRetourCredits);
        score.getChildren().add(boutonRetourScore);
        options.getChildren().add(boutonRetourOptions);

        Scene sceneCredits = new Scene(credits, largeur, hauteur);
        Scene sceneScore = new Scene(score, largeur, hauteur);
        Scene sceneOptions = new Scene(options, largeur, hauteur);

        ecranTitre = new Titre(primaryStage, scenePlateau, sceneScore, sceneOptions, sceneCredits, titre, this.plateauPuzzle);
        sceneMenu = new Scene(ecranTitre, largeur, hauteur);
        
        //----HAUT----
        PanelNord panelNord = new PanelNord(primaryStage, titre, sceneMenu, scenePlateau, plateauPuzzle);
        borderPane.setTop(panelNord);
        
        //----CENTRE----
        vuePlateau = new VuePlateau(this.plateauPuzzle);
        borderPane.setCenter(vuePlateau);
        //this.borderPane.setCenter(new VuePlateauCouche1(this.plateauPuzzle,vuePlateau));
        //Afficher les pièces dans le terminal :
        //vuePlateau.getPositionPiece().forEach((key, value) -> System.out.println(key + " " + value));

        //----DROITE----
        PanelEst panelEst = new PanelEst(this.plateauPuzzle, primaryStage, titre);
        panelEst.setScore(score);
        borderPane.setRight(panelEst);

        //----GAUCHE----
        borderPane.setLeft(new PanelOuest(this.plateauPuzzle));

        //----TOUCHES CLAVIER----
        scenePlateau.addEventFilter(KeyEvent.KEY_PRESSED, event->{
            if (event.getCode() == KeyCode.ALT) {
                this.plateauPuzzle.supprimeToutePieces();
                this.plateauPuzzle.generationAlea(10);
            }
        });
        scenePlateau.addEventFilter(KeyEvent.KEY_PRESSED, event->{
            if (event.getCode() == KeyCode.V) {
                Robot r = new Robot(this.plateauPuzzle);
                r.appliqueStrategy(new BrutForceAction(40));
            }
        });

        borderPane.setStyle("-fx-padding: 5; -fx-background-color: " + Config.COLOR_INTERFACE + ";");
        //--------------
        ecranTitre.setVuePlateau();
        primaryStage.setTitle(titre);
        primaryStage.setScene(sceneMenu);
        primaryStage.setResizable(false);
        try{
            Image image = new Image("https://images-na.ssl-images-amazon.com/images/I/81km2TTrJKL._AC_SL1500_.jpg");
            primaryStage.getIcons().add(image);
        }catch (Exception e){
            System.err.println(e.fillInStackTrace());
        }
        primaryStage.show();
    }

    public static void styleMisAJour(){
        borderPane.setStyle("-fx-padding: 5; -fx-background-color: " + Config.COLOR_INTERFACE + ";");
        credits.setStyle("-fx-padding: 5; -fx-background-color: " + Config.COLOR_INTERFACE + ";");
        score.setStyle("-fx-padding: 5; -fx-background-color: " + Config.COLOR_INTERFACE + ";");
        score.setStyle("-fx-padding: 5; -fx-background-color: " + Config.COLOR_INTERFACE + ";");
        ecranTitre.setStyle("-fx-padding: 5; -fx-background-color: " + Config.COLOR_INTERFACE + ";");

        boutonRetourCredits.changerCouleur(Config.COLOR_TEXT, Config.COLOR_INTERFACE);
        boutonRetourScore.changerCouleur(Config.COLOR_TEXT, Config.COLOR_INTERFACE);
        boutonRetourOptions.changerCouleur(Config.COLOR_TEXT, Config.COLOR_INTERFACE);
    }

    public static VuePlateau getVuePlateau(){
        return vuePlateau;
    }

    @Override
    public void start(Stage primaryStage) {

        //----MODEL-----
            //creation du plateau
        this.plateauPuzzle = new PlateauPuzzle(25,25);
        this.plateauPuzzle.generationAlea(5);
        this.plateauPuzzle.ajoutEcouteur(this);

        //mise en place de la Fenetre
        this.build(primaryStage);
    }

    public void modeleMisAJour(Object source){
    }

    public static void main(String[] args) {
        launch(args);
    }
}
