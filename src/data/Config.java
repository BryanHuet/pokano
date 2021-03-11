package src.data;

import src.model.ia.BrutForce;
import src.model.ia.BrutForceAction;
import src.model.ia.Strategy;
import src.model.piece.*;

import java.util.*; //HashMap, ArrayList, Collections

public class Config {

    //Chemin vers les ressources;
    public static String PATH_PARTIES = "./livraison/ressource/saves/parties.json";
    public static String PATH_PARTIES_PREDEF = "./livraison/ressource/saves/predef.json";
    public static String PATH_SCORES = "./livraison/ressource/saves/scores.json";
    public static String PATH_TITLE_FONT = "file:./livraison/ressource/fonts/parmaInitialenMK.ttf";

    //Couleur de l'interface
    public static String COLOR_INTERFACE;
    //Couleur du texte
    public static String COLOR_TEXT;
    //Couleur de la grille
    public static String COLOR_GRID;

    //Nombre du type de pieces existant
    public static int NOMBRE_PIECES = 15;
    //Dimension maximum que la largeur ou la hauteur d'une piece peut atteindre
    public static int DIMENSION_MAX_PIECE = 5;

    public static Boolean IS_FULLSCREEN = false;

    //Couleur de chaque pieces
    public static String COLOR_PIECE_I;
    public static String COLOR_PIECE_A;
    public static String COLOR_PIECE_B;
    public static String COLOR_PIECE_C;
    public static String COLOR_PIECE_H;
    public static String COLOR_PIECE_L;
    public static String COLOR_PIECE_P;
    public static String COLOR_PIECE_O;
    public static String COLOR_PIECE_X;
    public static String COLOR_PIECE_E;
    public static String COLOR_PIECE_S;
    public static String COLOR_PIECE_T;
    public static String COLOR_PIECE_F;
    public static String COLOR_PIECE_COEUR;
    public static String COLOR_PIECE_J;

    //Structure utilisée
    public static HashMap<String, String> listeCouleurs = new HashMap<>();
    public static ArrayList<Piece> listePieces = new ArrayList<>();

    public static HashMap<String, Strategy> listeStrategy = new HashMap<>();


    //Utilisé dans control.PieceControlable et dans Options
    public static String MAKE_TEST_COLOR_PIECE(Piece piece){
        if (piece instanceof PieceI) {
            return Config.COLOR_PIECE_I;
        }
        if (piece instanceof PieceO) {
            return Config.COLOR_PIECE_O;
        }
        if (piece instanceof PieceT) {
            return Config.COLOR_PIECE_T;
        }
        if (piece instanceof PieceL) {
            return Config.COLOR_PIECE_L;
        }
        if (piece instanceof PieceC) {
            return Config.COLOR_PIECE_C;
        }
        if (piece instanceof PieceE) {
            return Config.COLOR_PIECE_E;
        }
        if (piece instanceof PieceH) {
            return Config.COLOR_PIECE_H;
        }
        if (piece instanceof PieceS) {
            return Config.COLOR_PIECE_S;
        }
        if (piece instanceof PieceA) {
            return Config.COLOR_PIECE_A;
        }
        if (piece instanceof PieceP) {
            return Config.COLOR_PIECE_P;
        }
        if (piece instanceof PieceX) {
            return Config.COLOR_PIECE_X;
        }
        if (piece instanceof PieceB) {
            return Config.COLOR_PIECE_B;
        }
        if (piece instanceof PieceCoeur) {
            return Config.COLOR_PIECE_COEUR;
        }
        if (piece instanceof PieceF) {
            return Config.COLOR_PIECE_F;
        }
        if (piece instanceof PieceJ) {
            return Config.COLOR_PIECE_J;
        }
        return null;
    }

    //Utilisé dans option
    public static void CHANGE_COLOR_PIECE(Piece piece, String color){
        if (piece instanceof PieceI) {
            Config.COLOR_PIECE_I=color;
        }
        if (piece instanceof PieceO) {
            Config.COLOR_PIECE_O=color;
        }
        if (piece instanceof PieceT) {
            Config.COLOR_PIECE_T=color;
        }
        if (piece instanceof PieceL) {
            Config.COLOR_PIECE_L=color;
        }
        if (piece instanceof PieceC) {
            Config.COLOR_PIECE_C=color;
        }
        if (piece instanceof PieceE) {
            Config.COLOR_PIECE_E=color;
        }
        if (piece instanceof PieceH) {
            Config.COLOR_PIECE_H=color;
        }
        if (piece instanceof PieceS) {
            Config.COLOR_PIECE_S=color;
        }
        if (piece instanceof PieceA) {
            Config.COLOR_PIECE_A=color;
        }
        if (piece instanceof PieceP) {
            Config.COLOR_PIECE_P=color;
        }
        if (piece instanceof PieceX) {
            Config.COLOR_PIECE_X=color;
        }
        if (piece instanceof PieceB) {
            Config.COLOR_PIECE_B=color;
        }
        if (piece instanceof PieceCoeur) {
            Config.COLOR_PIECE_COEUR=color;
        }
        if (piece instanceof PieceF) {
            Config.COLOR_PIECE_F=color;
        }
        if (piece instanceof PieceJ) {
            Config.COLOR_PIECE_J=color;
        }
    }

    public static void remplirListeCouleur(){
        listeCouleurs.put("Blanc","#FFFFFF");
        listeCouleurs.put("Bordeau","#330000");
        listeCouleurs.put("Bleu","#336699");
        listeCouleurs.put("Violet fonce","#493578");
        listeCouleurs.put("Bleuet","#6495ED");
        listeCouleurs.put("Gris","#808080");
        listeCouleurs.put("Verge d'or","#EEE8AA");
        listeCouleurs.put("Fuchia","#FF00FF");
        listeCouleurs.put("Foret verte","#228B22");
        listeCouleurs.put("Marron","#582900");
        listeCouleurs.put("Rouge indien","#CD5C5C");
        listeCouleurs.put("Ivoire","#FFFFF0");
        listeCouleurs.put("Violet","#EE82EE");
        listeCouleurs.put("Blanc diamand","#FFEBCD");
        listeCouleurs.put("Or","#FFD700");
        listeCouleurs.put("Chocolat","#D2691E");
        listeCouleurs.put("Cyan sombre","#008B8B");
        listeCouleurs.put("Corail","#FF7F50");
        listeCouleurs.put("Rouge","#FF0000");
        listeCouleurs.put("Noir","#000000");
        listeCouleurs.put("Eau","#00FFFF");
        listeCouleurs.put("Eau marine","#7FFFD4");
        listeCouleurs.put("Brique de feu","#B22222");
        listeCouleurs.put("Rose","#FFC0CB");
        listeCouleurs.put("Rose profond","#FF1493");

        COLOR_INTERFACE = listeCouleurs.get("Bleu");
        COLOR_TEXT = listeCouleurs.get("Blanc");
        COLOR_GRID = listeCouleurs.get("Bleuet");

        COLOR_PIECE_I = listeCouleurs.get("Verge d'or");
        COLOR_PIECE_A = listeCouleurs.get("Gris");
        COLOR_PIECE_B = listeCouleurs.get("Foret verte");
        COLOR_PIECE_C = listeCouleurs.get("Marron");
        COLOR_PIECE_H = listeCouleurs.get("Rouge indien");
        COLOR_PIECE_L = listeCouleurs.get("Ivoire");
        COLOR_PIECE_P = listeCouleurs.get("Violet");
        COLOR_PIECE_O = listeCouleurs.get("Blanc diamand");
        COLOR_PIECE_X = listeCouleurs.get("Or");
        COLOR_PIECE_E = listeCouleurs.get("Brique de feu");
        COLOR_PIECE_S = listeCouleurs.get("Cyan sombre");
        COLOR_PIECE_T = listeCouleurs.get("Corail");
        COLOR_PIECE_COEUR = listeCouleurs.get("Rouge");
        COLOR_PIECE_F = listeCouleurs.get("Noir");
        COLOR_PIECE_J = listeCouleurs.get("Rose");

        listePieces.add(new PieceA(0,0));
        listePieces.add(new PieceB(0,0));
        listePieces.add(new PieceC(0,0));
        listePieces.add(new PieceE(0,0));
        listePieces.add(new PieceH(0,0));
        listePieces.add(new PieceI(0,0));
        listePieces.add(new PieceL(0,0));
        listePieces.add(new PieceO(0,0));
        listePieces.add(new PieceP(0,0));
        listePieces.add(new PieceS(0,0));
        listePieces.add(new PieceT(0,0));
        listePieces.add(new PieceX(0,0));
        listePieces.add(new PieceF(0,0));
        listePieces.add(new PieceCoeur(0,0));
        listePieces.add(new PieceJ(0,0));

        listeStrategy.put("Brute Force", new BrutForce());
        listeStrategy.put("Brute Force Action", new BrutForceAction(25));
    }

    public static ArrayList<String> getListeNomCouleurs(){
        ArrayList<String> listeNomCouleurs = new ArrayList<>(listeCouleurs.keySet());
        Collections.sort(listeNomCouleurs);
        return listeNomCouleurs;
    }

    public static String getKey(Map<String, String> map, String value) {
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (value.equals(entry.getValue())) {
                return entry.getKey();
            }
        }
        return null;
    }

    public static ArrayList<String> getListeStrategy(){
        ArrayList<String> listeNomStrategy = new ArrayList<>(listeStrategy.keySet());
        return listeNomStrategy;
    }
}
