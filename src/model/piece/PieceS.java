package src.model.piece;

import java.util.ArrayList;

/**
 * Piece en forme de S
 */
public class PieceS extends AbstractPiece{
    public PieceS(int largeur, int hauteur) {
        super(largeur, hauteur);

        for(int i=0;i<this.getHauteur()/2;i++){
            ArrayList<Integer> pos = new ArrayList<>();
            pos.add(-i);
            pos.add(-this.getLargeur()/2);
            this.ajoutCoord(pos);
            ArrayList<Integer> pos2 = new ArrayList<>();
            pos2.add(i);
            pos2.add(this.getLargeur()/2);
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
            ArrayList<Integer> pos3 = new ArrayList<>();
            pos3.add(0);
            pos3.add((this.getLargeur()/2)-i);
            this.ajoutCoord(pos3);
        }
    }


    public String toString(){
        return "S";
    }
}
