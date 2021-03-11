package src.model.piece;

import java.util.ArrayList;

/**
 * Piece en forme de T
 */

public class PieceT extends AbstractPiece {

    public PieceT(int largeur, int hauteur) {
        super(largeur, hauteur);

        for(int i=0;i<this.getHauteur();i++){
            ArrayList<Integer> pos = new ArrayList<>();
            pos.add((this.getHauteur()/2)-i);
            pos.add(0);
            this.ajoutCoord(pos);
        }

        for(int i=0;i<this.getLargeur();i++){
            ArrayList<Integer> pos = new ArrayList<>();
            pos.add(-(this.getHauteur()/2));
            pos.add((this.getLargeur()/2)-i);
            this.ajoutCoord(pos);
        }
    }

    public String toString(){
        return "T";
    }
}
