package src.model.piece;

import java.util.ArrayList;

/**
 * Piece en forme de O
 */

public class PieceO extends AbstractPiece {

    public PieceO(int largeur, int hauteur) {
        super(largeur, hauteur);

        for(int i=0;i<this.getHauteur();i++){
            ArrayList<Integer> pos1 = new ArrayList<>();
            pos1.add((this.getHauteur()/2)-i);
            pos1.add(this.getLargeur()/2);
            this.ajoutCoord(pos1);
            ArrayList<Integer> pos2 = new ArrayList<>();
            pos2.add((this.getHauteur()/2)-i);
            pos2.add(-(this.getLargeur()/2));
            this.ajoutCoord(pos2);
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
        }

    }

        public String toString(){
          return "O";
        }
}
