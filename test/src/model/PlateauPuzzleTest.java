package src.model;

import org.junit.jupiter.api.Test;
import src.model.action.Action;
import src.model.action.Translater;
import src.model.piece.*;

import static org.junit.jupiter.api.Assertions.*;

class PlateauPuzzleTest {

    @Test
    void ajoutPiece() {

        // on creer le plateau
        PlateauPuzzle plateauPuzzle = new PlateauPuzzle(10, 10);


        // taille du plateau 10x10 donc piece total 100
        for (int i = 0; i < plateauPuzzle.getTaille()[0]; i++) {
            for (int j = 0; j < plateauPuzzle.getTaille()[1]; j++) {

                PieceA pieceA = new PieceA(1, 1);
                int[] pos = {i, j};
                pieceA.setPosition(pos);
                plateauPuzzle.ajoutPiece(pieceA);
            }
        }


        // on effectue le test
        assertEquals(100, plateauPuzzle.getEnsemblePiece().size());

        //ajouter une piece en position -1 -1


    }

    @Test
    void suppPiece() {

        // on creer le plateau

        PlateauPuzzle plateauPuzzle = new PlateauPuzzle(10, 10);

        for (int i = 0; i < plateauPuzzle.getTaille()[0]; i++) {
            for (int j = 0; j < plateauPuzzle.getTaille()[1]; j++) {

                PieceA pieceA = new PieceA(1, 1);
                int[] pos = {i, j};
                pieceA.setPosition(pos);
                // on creer la piece
                plateauPuzzle.ajoutPiece(pieceA);

                //on supprime la piece precedente
                plateauPuzzle.suppPiece(pieceA);
            }
        }

        // on regarde si dans le plateau il y a bien 0 pieces
        assertEquals(0, plateauPuzzle.getEnsemblePiece().size());


        // TESTER AVEC PLUSIEURS PIECE
    }

    @Test
    void espaceOccupe() {

        for (int i = 0; i < 100; i++) {
            PlateauPuzzle plateauPuzzle = new PlateauPuzzle(3 + i, 3 + i);
            PieceA piece1 = new PieceA(1, 1);
            PieceA piece2 = new PieceA(1, 1);
            piece1.setPosition(i, i);
            piece1.setPosition(plateauPuzzle.getTaille()[0] - 1, plateauPuzzle.getTaille()[1] - 1);
            plateauPuzzle.ajoutPiece(piece1);
            plateauPuzzle.ajoutPiece(piece2);
            assertEquals((plateauPuzzle.getTaille()[0] - 1) * (plateauPuzzle.getTaille()[1] - 1), plateauPuzzle.espaceOccupe());
        }
    }

    @Test
    void pieceAtPosition() {

        // on creer le plateau
        PlateauPuzzle plateauPuzzle = new PlateauPuzzle(10, 10);

        //on creer une piece avec une Position
        //parcourir toutes les pieces du plateau


        PieceA pieceA = new PieceA(3, 3);
        int[] position = {4, 4};
        pieceA.setPosition(position);

        //On choisi une position pour le test
        int[] isPosition = {4, 4};

        //on compare la position de la Piece avec la Position chosi pour le test
        assertArrayEquals(isPosition, position);

    }

    @Test
    void collision() {

        //On creer le plateau
        PlateauPuzzle plateauPuzzle = new PlateauPuzzle(10, 10);

        //on creer une piece avec une Position
        PieceA pieceA = new PieceA(1, 1);
        int[] position = {1, 1};
        pieceA.setPosition(position);

        PieceE pieceE = new PieceE(1, 1);
        int[] position2 = {0, 0};
        pieceE.setPosition(position2);

        //on ajoute la piece dans le plateau
        plateauPuzzle.ajoutPiece(pieceA);

        plateauPuzzle.ajoutPiece(pieceE);


        //apres faire une translation sur une des pieces

        pieceE.translate(1, 1);

        //effectuer le test
        assertTrue(plateauPuzzle.collision(pieceA, pieceE));

    }

    @Test
    void isInValidePositionPiece() {

        //On creer le plateau
        PlateauPuzzle plateauPuzzle = new PlateauPuzzle(150, 150);

        PieceA pieceA = new PieceA(1, 1);


        for (int i = -100; i < plateauPuzzle.getTaille()[0] + 100; i++) {
            for (int j = -100; j < plateauPuzzle.getTaille()[1] + 100; j++) {

                int[] pos = {i, j};
                pieceA.setPosition(pos);

                if (i < 0 || j < 0 || i > plateauPuzzle.getTaille()[0] || j > plateauPuzzle.getTaille()[1]) {
                    assertFalse(plateauPuzzle.isInValidePositionPiece(pieceA));
                } else {
                    assertTrue(plateauPuzzle.isInValidePositionPiece(pieceA));
                }
            }
        }
    }

    @Test
    void isInCollision() {

        //On creer le plateau
        PlateauPuzzle plateauPuzzle = new PlateauPuzzle(10, 10);

        //on creer une piece avec une Position
        PieceA pieceA = new PieceA(1, 1);
        int[] posA = {1, 1};
        pieceA.setPosition(posA);

        PieceE pieceE = new PieceE(1, 1);
        int[] posE = {0, 0};
        pieceE.setPosition(posE);

        //on ajoute les pieces
        plateauPuzzle.ajoutPiece(pieceA);

        plateauPuzzle.ajoutPiece(pieceE);

        // on effectue une translation au coordonée de la piece A
        pieceE.translate(1, 1);

        //on effectue le test
        assertTrue(plateauPuzzle.isInCollision(pieceA));


    }

    @Test
    void supprimeToutePieces() {
        //On creer le plateau
        PlateauPuzzle plateauPuzzle = new PlateauPuzzle(10, 10);

        //on creer une piece
        PieceA pieceA = new PieceA(3, 3);
        int[] position = {4, 4};
        pieceA.setPosition(position);

        PieceO pieceO = new PieceO(4, 4);
        int[] position2 = {3, 3};
        pieceO.setPosition(position2);

        //on ajoute la piece dans le plateau
        plateauPuzzle.ajoutPiece(pieceA);
        plateauPuzzle.ajoutPiece(pieceO);

        //on supprime la piece precedente
        plateauPuzzle.supprimeToutePieces();

        assertEquals(0, plateauPuzzle.getEnsemblePiece().size());
    }

    @Test
    void generationAlea() {

        for (int i = -100; i < 100; i++) {
            PlateauPuzzle plateauPuzzle = new PlateauPuzzle(3 + i, 3 + i);
            plateauPuzzle.generationAlea(i);
            assertEquals(Math.max(i, 0), plateauPuzzle.getEnsemblePiece().size());
        }
    }

    @Test
    void effectuerUneAction() {

        //On creer le plateau
        PlateauPuzzle plateauPuzzle = new PlateauPuzzle(10, 10);

        PieceA pieceA = new PieceA(1, 1);
        int[] position = {0, 0};
        pieceA.setPosition(position);


        Action<Piece> action = new Translater(pieceA, 1, 1);

        plateauPuzzle.effectuerUneAction(action);

        int[] positionExpected = {1, 1};

        assertArrayEquals(positionExpected, pieceA.getPosition());


    }

    @Test
    void defaireDerniereAction() {

        //On creer le plateau
        PlateauPuzzle plateauPuzzle = new PlateauPuzzle(10, 10);

        PieceA pieceA = new PieceA(1, 1);
        int[] position = {0, 0};
        pieceA.setPosition(position);


        Action<Piece> action = new Translater(pieceA, 1, 1);

        plateauPuzzle.effectuerUneAction(action);

        plateauPuzzle.defaireDerniereAction();

        int[] positionExpected = {0, 0};

        assertArrayEquals(positionExpected, pieceA.getPosition());
    }

}