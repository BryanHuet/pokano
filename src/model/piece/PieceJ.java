package src.model.piece;

import java.util.ArrayList;

/**
 * Piece en forme de J
 */
public class PieceJ extends AbstractPiece{
    public PieceJ(int largeur, int hauteur) {
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
        for(int i=0;i<this.getLargeur()/2;i++){
            ArrayList<Integer> pos = new ArrayList<>();
            pos.add((this.getHauteur()/2));
            pos.add(-(this.getLargeur()/2)+i);
            this.ajoutCoord(pos);
        }
    }

    public String toString(){
        return "J";
    }
}
