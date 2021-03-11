package src.control;

import src.data.Config;
import src.model.piece.*;

import javafx.scene.paint.Color;
import static javafx.scene.paint.Color.*;

import java.util.*; //ArrayList, HashSet

public class PieceControlable {

    private final Piece piece;
    private final HashSet<ArrayList<Integer>> positions;
    private final Color color;

    public PieceControlable(Piece piece){
        this.piece = piece;
        this.positions=new HashSet<>();
        this.majPositions();

        this.color = web(Config.MAKE_TEST_COLOR_PIECE(piece));
    }

/*
---------------------------------------------------------------------------------------------------------------------
                                    GETTER/SETTER
---------------------------------------------------------------------------------------------------------------------
*/
    public Piece getPiece() {
        return piece;
    }

    public HashSet<ArrayList<Integer>> getPositions() {
        return positions;
    }

    public Color getColor() {
        return color;
    }

/*
---------------------------------------------------------------------------------------------------------------------
                                     METHODES
---------------------------------------------------------------------------------------------------------------------
*/
    public void majPositions(){
        this.positions.clear();
        for(ArrayList<Integer> forme: this.piece.getRange()){
            ArrayList<Integer> pos = new ArrayList<>();
            pos.add(this.piece.getPosition()[1]+forme.get(1));
            pos.add(this.piece.getPosition()[0]+forme.get(0));
            this.positions.add(pos);
        }
    }
}
