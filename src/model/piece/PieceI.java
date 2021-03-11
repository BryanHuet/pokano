package src.model.piece;

import java.util.ArrayList;

/**
 * Piece en forme de I
 */

public class PieceI extends AbstractPiece {

    public PieceI(int largeur, int hauteur) {
        super(largeur, hauteur );

        for(int i=0;i<this.getHauteur();i++){
            ArrayList<Integer> pos = new ArrayList<>();
            pos.add((this.getHauteur()/2)-i);
            pos.add(0);
            this.ajoutCoord(pos);
        }
    }

    public String toString(){
          return "I";
        }
}

