package src.model.piece;

import java.util.ArrayList;

/**
 * Piece en form de F
 */
public class PieceF extends AbstractPiece{
    public PieceF(int largeur, int hauteur) {
        super(largeur, hauteur);

        for(int i=0;i<this.getHauteur();i++){
            ArrayList<Integer> pos = new ArrayList<>();
            pos.add((this.getHauteur()/2)-i);
            pos.add(-(this.getLargeur()/2));
            this.ajoutCoord(pos);
        }

        for(int i=0;i<this.getLargeur();i++){
            ArrayList<Integer> pos = new ArrayList<>();
            pos.add(-(this.getHauteur()/2));
            pos.add((this.getLargeur()/2)-i);
            this.ajoutCoord(pos);
            ArrayList<Integer> pos2 = new ArrayList<>();
            pos2.add(0);
            pos2.add((this.getLargeur()/2)-i);
            this.ajoutCoord(pos2);
        }
    }

    public String toString(){
        return "F";
    }
}
