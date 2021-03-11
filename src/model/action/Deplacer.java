package src.model.action;

import src.model.piece.Piece;

/**
 * Action de deplacement de position d'une piece, on modifie la position de la piece
 */
public class Deplacer implements Action<Piece> {

    private final Piece piece;
    private final int destinationX;
    private final int destinationY;
    private final int sourceX;
    private final int sourceY;

    public Deplacer(Piece piece, int destinationX, int destinationY) {
        this.piece = piece;
        this.destinationX = destinationX;
        this.destinationY = destinationY;
        sourceX=this.piece.getPosition().clone()[0];
        sourceY=this.piece.getPosition().clone()[1];
    }

    @Override
    public void effectuer() {
        this.piece.deplace(this.destinationX,this.destinationY);
    }

    @Override
    public void annuler() {
        this.piece.deplace(sourceX,sourceY);
    }

    @Override
    public Piece getSubject() {
        return piece;
    }
}
