package src.model.piece;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AbstractPieceTest {


    @Test
    void occupe() {
        PieceT pieceT = new PieceT(3,3);
        PieceO pieceO = new PieceO(3,3);
        for (int i=-100;i<100;i++){
            pieceT.setPosition(100+i,100+i);
            pieceO.setPosition(i,i);
            for(int j=-100;j<100;j++){
                //test PieceT
                assertTrue(pieceT.occupe(99+i,99+i));
                assertTrue(pieceT.occupe(99+i,101+i));
                assertTrue(pieceT.occupe(99+i,100+i));
                assertTrue(pieceT.occupe(100+i,100+i));
                assertTrue(pieceT.occupe(101+i,100+i));
                assertFalse(pieceT.occupe(97+i,100+i));

                //test PieceA
                assertFalse(pieceO.occupe(i,i));
                assertTrue(pieceO.occupe(i-1,i));
                assertTrue(pieceO.occupe(i+1,i));
                assertTrue(pieceO.occupe(i,i+1));
                assertTrue(pieceO.occupe(i,i-1));
            }
        }
    }

    @Test
    void rotate() {
        PieceA piece = new PieceA(1,1);
        for(int i=0;i<100;i++){
            piece.rotate(1);

        }
        assertEquals("default",piece.getSensRotation());
        for(int i=0;i<101;i++){
            piece.rotate(1);

        }
        assertEquals("left",piece.getSensRotation());

        for(int i=0;i<102;i++){
            piece.rotate(1);

        }
        assertEquals("right",piece.getSensRotation());

        for(int i=0;i<103;i++){
            piece.rotate(1);

        }
        assertEquals("down",piece.getSensRotation());

    }

    @Test
    void translate() {
        Piece pieceA = new PieceA(1,1);
        pieceA.deplace(0,0);
        for(int i=1;i<100;i++){
            pieceA.translate(1,1);
            int[] pos = new int[]{i,i};
            assertEquals(pos[0],pieceA.getPosition()[0]);
            assertEquals(pos[1],pieceA.getPosition()[1]);
        }

    }
}