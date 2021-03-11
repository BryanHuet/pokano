package src.model.piece;

import java.util.ArrayList;

/**
 * Piece en forme de Coeur, est necessairement de largeur 7 et de hauteur 6
 */
public class PieceCoeur extends AbstractPiece {
    public PieceCoeur(int largeur, int hauteur) {
        super(7, 6);

        for(int i=-2;i<2;i++){
            ArrayList<Integer> pos = new ArrayList<>();
            pos.add(i);
            pos.add(-2);
            this.ajoutCoord(pos);
            ArrayList<Integer> pos2 = new ArrayList<>();
            pos2.add(i);
            pos2.add(2);
            this.ajoutCoord(pos2);
        }
        for(int i=-2;i<3;i++){
            ArrayList<Integer> pos = new ArrayList<>();
            pos.add(i);
            pos.add(-1);
            this.ajoutCoord(pos);
            ArrayList<Integer> pos2 = new ArrayList<>();
            pos2.add(i);
            pos2.add(1);
            this.ajoutCoord(pos2);
        }
        for(int i=-1;i<4;i++){
            ArrayList<Integer> pos = new ArrayList<>();
            pos.add(i);
            pos.add(0);
            this.ajoutCoord(pos);
        }


        ArrayList<Integer> pos0 = new ArrayList<>();
        pos0.add(0);
        pos0.add(-3);
        this.ajoutCoord(pos0);
        ArrayList<Integer> pos1 = new ArrayList<>();
        pos1.add(-1);
        pos1.add(-3);
        this.ajoutCoord(pos1);

        ArrayList<Integer> pos2 = new ArrayList<>();
        pos2.add(0);
        pos2.add(3);
        this.ajoutCoord(pos2);
        ArrayList<Integer> pos3 = new ArrayList<>();
        pos3.add(-1);
        pos3.add(3);
        this.ajoutCoord(pos3);


    }

    public String toString(){
        return "♥";
    }

}