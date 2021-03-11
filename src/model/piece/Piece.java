package src.model.piece;

import java.util.*; //ArrayList, List

public interface Piece {

    int getHauteur();
    int getLargeur();
    int[] getPosition();
    List<ArrayList<Integer>> getRange();
    String getSensRotation();
    boolean occupe(int x, int y);

    //methodes de déplacement

    void deplace(int x, int y);
    void rotate(int sens);
    void translate(int x, int y);
}
