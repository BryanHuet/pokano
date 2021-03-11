package src.data;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import src.model.PlateauPuzzle;
import src.model.piece.*;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicReference;

public class LectureParties {

    String nomPartie;
    String nomJoueur;
    int score;
    PlateauPuzzle nouveauPlateau;
    private ArrayList<PartiePuzzle> partiePuzzles;

    public LectureParties(String pathToFile){
        this.partiePuzzles=new ArrayList<>();
        JSONParser parser = new JSONParser();
        try(Reader reader = new FileReader(pathToFile)){
            JSONObject saves = (JSONObject) parser.parse(reader);

            for(Object key : saves.keySet()){

                JSONObject cible = (JSONObject) saves.get((String) key);
                this.nomJoueur = (String) (cible).get("nomJoueur"); //On stocke les données lu dans les attributs
                //this.score = Math.toIntExact((Long) cible.get("score"));

                this.nouveauPlateau = new PlateauPuzzle(Math.toIntExact((Long) cible.get("tailleX")),Math.toIntExact((Long) cible.get("tailleY")));
                    JSONArray plateau = (JSONArray) cible.get("plateau");

                    this.nouveauPlateau = new PlateauPuzzle(Math.toIntExact((Long) cible.get("tailleX")),Math.toIntExact((Long) cible.get("tailleY")));

                    Iterator<JSONObject> iterator = plateau.iterator();
                    while (iterator.hasNext()) {
                        JSONObject piece = (JSONObject) iterator.next();
                        String stringClass = (String) piece.get("classe");
                        Piece nouvellePiece;
                        switch(stringClass){
                            case "A":
                                nouvellePiece = new PieceA(Math.toIntExact((Long) piece.get("largeur")),Math.toIntExact((Long) piece.get("hauteur")));
                                break;
                            case "C":
                                nouvellePiece = new PieceC(Math.toIntExact((Long) piece.get("largeur")),Math.toIntExact((Long) piece.get("hauteur")));
                                break;
                            case "E":
                                nouvellePiece = new PieceE(Math.toIntExact((Long) piece.get("largeur")),Math.toIntExact((Long) piece.get("hauteur")));
                                break;
                            case "H":
                                nouvellePiece = new PieceH(Math.toIntExact((Long) piece.get("largeur")),Math.toIntExact((Long) piece.get("hauteur")));
                                break;
                            case "I":
                                nouvellePiece = new PieceI(Math.toIntExact((Long) piece.get("largeur")),Math.toIntExact((Long) piece.get("hauteur")));
                                break;
                            case "L":
                                nouvellePiece = new PieceL(Math.toIntExact((Long) piece.get("largeur")),Math.toIntExact((Long) piece.get("hauteur")));
                                break;
                            case "O":
                                nouvellePiece = new PieceO(Math.toIntExact((Long) piece.get("largeur")),Math.toIntExact((Long) piece.get("hauteur")));
                                break;
                            case "P":
                                nouvellePiece = new PieceP(Math.toIntExact((Long) piece.get("largeur")),Math.toIntExact((Long) piece.get("hauteur")));
                                break;
                            case "S":
                                nouvellePiece = new PieceS(Math.toIntExact((Long) piece.get("largeur")),Math.toIntExact((Long) piece.get("hauteur")));
                                break;
                            case "T":
                                nouvellePiece = new PieceT(Math.toIntExact((Long) piece.get("largeur")),Math.toIntExact((Long) piece.get("hauteur")));
                                break;
                            case "X":
                                nouvellePiece = new PieceX(Math.toIntExact((Long) piece.get("largeur")),Math.toIntExact((Long) piece.get("hauteur")));
                                break;
                            case "♥":
                                nouvellePiece = new PieceCoeur(Math.toIntExact((Long) piece.get("largeur")),Math.toIntExact((Long) piece.get("hauteur")));
                                break;
                            case "B":
                                nouvellePiece = new PieceB(Math.toIntExact((Long) piece.get("largeur")),Math.toIntExact((Long) piece.get("hauteur")));
                                break;
                            case "F":
                                nouvellePiece = new PieceF(Math.toIntExact((Long) piece.get("largeur")),Math.toIntExact((Long) piece.get("hauteur")));
                                break;
                            case "J":
                                nouvellePiece = new PieceJ(Math.toIntExact((Long) piece.get("largeur")),Math.toIntExact((Long) piece.get("hauteur")));
                                break;
                            default:
                                throw new IllegalStateException("Unexpected value: " + stringClass);
                        }
                        String sensRotation = ((String) piece.get("rotation"));
                        if(sensRotation!=null){
                            switch (sensRotation) {
                                case "default":
                                    break;
                                case "right": nouvellePiece.rotate(-1);
                                    break;
                                case "left":
                                    nouvellePiece.rotate(1);
                                    break;
                                case "down":
                                    nouvellePiece.rotate(1);
                                    nouvellePiece.rotate(1);
                                    break;
                                default:
                                    break;
                            }
                        }
                        //nouvellePiece.rotate(Math.toIntExact((Long) piece.get("rotate")));
                        nouvellePiece.deplace(Math.toIntExact((Long) piece.get("positionX")),Math.toIntExact((Long) piece.get("positionY")));
                        this.nouveauPlateau.ajoutPiece(nouvellePiece);
                    }

                String pieces="";
                for(Piece pi: this.nouveauPlateau.getEnsemblePiece()){
                    pieces = pieces+pi;
                }
                PartiePuzzle pz = new PartiePuzzle(this.nouveauPlateau,(String) key);
                this.partiePuzzles.add(pz);
            }
        }catch(IOException e){
            e.printStackTrace();
        }catch(ParseException e){
            e.printStackTrace();
        }
    }

    public String getNomPartie() {
        return nomPartie;
    }

    public String getNomJoueur() {
        return nomJoueur;
    }

    public int getScore() {
        return score;
    }

    public ArrayList<PartiePuzzle> getPartiePuzzles() {
        return partiePuzzles;
    }

    public void setPartiePuzzles(ArrayList<PartiePuzzle> partiePuzzles) {
        this.partiePuzzles = partiePuzzles;
    }

    public PlateauPuzzle getNouveauPlateau() {
        return nouveauPlateau;
    }
}