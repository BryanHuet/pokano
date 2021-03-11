package src.model.piece;

import java.util.ArrayList;

/**
 * Piece en forme de E
 */

public class PieceE extends AbstractPiece {


    public PieceE(int hauteur, int largeur) {
        super(hauteur, largeur);


        for(int i=0;i<this.getHauteur();i++){
            ArrayList<Integer> pos = new ArrayList<>();
            pos.add((this.getHauteur()/2)-i);
            pos.add(-(this.getLargeur()/2));
            this.ajoutCoord(pos);
        }

        for(int i=0;i<this.getLargeur();i++){
            ArrayList<Integer> pos = new ArrayList<>();
            pos.add((this.getHauteur()/2));
            pos.add((this.getLargeur()/2)-i);
            this.ajoutCoord(pos);
            ArrayList<Integer> pos2 = new ArrayList<>();
            pos2.add(-(this.getHauteur()/2));
            pos2.add((this.getLargeur()/2)-i);
            this.ajoutCoord(pos2);
            ArrayList<Integer> pos3 = new ArrayList<>();
            pos3.add(0);
            pos3.add((this.getLargeur()/2)-i);
            this.ajoutCoord(pos3);
        }
    }

    public String toString(){
        return "E";
    }
}
