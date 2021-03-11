package src.model.action;

import src.model.piece.Piece;


/**
 * Action de translation d'une piece, on applique la methode translate de la piece
 */
public class Translater implements Action<Piece> {
    private final Piece piece;
    private final int destinationX;
    private final int destinationY;

    public Translater(Piece piece, int destinationX, int destinationY) {
        this.piece = piece;
        this.destinationX = destinationX;
        this.destinationY = destinationY;
    }

    @Override
    public Piece getSubject() {
        return piece;
    }

    @Override
    public void effectuer() {
        this.piece.translate(this.destinationX,this.destinationY);
    }

    @Override
    public void annuler() {
        this.piece.translate(-destinationX,-destinationY);
    }

}
