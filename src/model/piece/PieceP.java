package src.model.piece;

import java.util.ArrayList;

/**
 * Piece en forme de P
 */
public class PieceP extends AbstractPiece {
    public PieceP(int largeur, int hauteur) {
        super(largeur, hauteur );


        for(int i=0;i<this.getHauteur();i++) {
            ArrayList<Integer> pos = new ArrayList<>();
            pos.add((this.getHauteur()/2)-i);
            pos.add(-this.getLargeur()/2);
            this.ajoutCoord(pos);
        }
        for(int i=0;i<getHauteur()/2;i++){
            ArrayList<Integer> pos = new ArrayList<>();
            pos.add((-this.getHauteur()/2)+i);
            pos.add(this.getLargeur()/2);
            this.ajoutCoord(pos);
        }


        for(int i=0;i<this.getLargeur();i++){
            ArrayList<Integer> pos = new ArrayList<>();
            pos.add(-this.getHauteur()/2);
            pos.add(this.getLargeur()/2-i);
            this.ajoutCoord(pos);

            ArrayList<Integer> pos2 = new ArrayList<>();
            pos2.add(0);
            pos2.add(this.getLargeur()/2-i);
            this.ajoutCoord(pos2);
        }

    }

    public String toString(){
        return "P";
    }
}
