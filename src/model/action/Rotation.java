package src.model.action;

import src.model.piece.Piece;

/**
 * Action de rotation d'une piece, on applique la methode rotate de la piece
 */
public class Rotation implements Action<Piece> {

    private final Piece piece;
    private final int sens;

    public Rotation(Piece piece, int sens) {
        this.piece = piece;
        this.sens = sens;
    }

    @Override
    public void effectuer() {
        this.piece.rotate(this.sens);
    }

    @Override
    public void annuler() {
        this.piece.rotate(-this.sens);
    }

    @Override
    public Piece getSubject() {
        return piece;
    }
}
