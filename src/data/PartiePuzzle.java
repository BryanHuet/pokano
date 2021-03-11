package src.data;

import src.model.PlateauPuzzle;
import src.model.piece.Piece;

import java.util.ArrayList;

public class PartiePuzzle {

    public String nomPartie;
    public String listePieces;
    private PlateauPuzzle plateauPuzzle;
    public ArrayList<PartieScore> score;

    public PartiePuzzle(PlateauPuzzle plateauPuzzle, String nomPartie){
        this.plateauPuzzle = plateauPuzzle;
        this.nomPartie=nomPartie;
        this.plateauPuzzle.setName(nomPartie);
        this.score = new ArrayList<>();
    }

    public void ajouterScore(PartieScore nouveauScore){
        this.score.add(nouveauScore);
    }

    public String getNomPartie() {
        return this.nomPartie;
    }

    public String getListePieces() {
        StringBuilder listePiecesString= new StringBuilder();
        for(Piece p: this.plateauPuzzle.getEnsemblePiece()){
            listePiecesString.append(p);
        }
        return listePiecesString.toString();
    }

    public Integer getTailleX() {
        return this.plateauPuzzle.getTaille()[0];
    }

    public Integer getTailleY() {
        return this.plateauPuzzle.getTaille()[1];
    }

    public PlateauPuzzle getPlateauPuzzle() {
        return plateauPuzzle;
    }

    public void setPlateauPuzzle(PlateauPuzzle plateauPuzzle) {
        this.plateauPuzzle = plateauPuzzle;
    }

    public ArrayList<PartieScore> getScore() {
        return this.score;
    }

    public int getBestScore(){
        int bestScore=10000000;

        if(this.getScore()!=null){
            for(PartieScore ps :this.getScore()){
                if(ps.getScore()<bestScore){
                    bestScore=ps.getScore();
                }
            }
        }
        return bestScore==10000000? 0 : bestScore;
    }
}