package src.model.piece;

import java.util.ArrayList;

/**
 * Piece en forme de L
 */

public class PieceL extends AbstractPiece {

    public PieceL(int hauteur, int largeur) {
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
        }
    }

    public String toString(){
      return "L";
    }
}
