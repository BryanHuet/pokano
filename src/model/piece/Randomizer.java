package src.model.piece;


import src.data.Config;

import java.util.Random;

public class Randomizer {

    //On représente le type de la piece par un entier
    public static int typePiece;
    //Le nombre de type de piece existant
    private static final int NOMBRE_DE_PIECE= Config.NOMBRE_PIECES;
    //On donne dimension maximum pour les pieces (la largeur et la hauteur d'une piece ne peut pas depasser DIM_MAX)
    private static final int DIM_MAX=Config.DIMENSION_MAX_PIECE;

    /**
     *
     * @param maxX Position X maximum duquel la piece peut etre generee
     * @param maxY Position Y maximum duquel la piece peut etre generee
     * @return Retourne une piece avec une forme et une position aleatoire.
     */
    public static Piece random(int maxX, int maxY,int type){
        int hauteur;
        int largeur;
        Piece piece = null;

        //on choisit le type de la piece
        typePiece=type;
        if(typePiece==0){
        typePiece =(int) (1 + (Math.random() * NOMBRE_DE_PIECE));
        }
        Random r = new Random();
        //Suivant le type de piece, on génère une hauteur et une largeur aleatoire et on instancie la piece.
        switch (typePiece) {
            case 1:
                hauteur = 1 + (r.nextInt(DIM_MAX));
                piece = new PieceI(1, hauteur);
                break;
            case 2:
                hauteur = 2 + (r.nextInt(DIM_MAX));
                largeur = 3 + (r.nextInt(DIM_MAX));
                hauteur= Math.min(hauteur, DIM_MAX);
                largeur= Math.min(largeur,DIM_MAX);
                if(hauteur%2==0 && largeur%2==0){
                    largeur= Math.min(largeur-1, DIM_MAX);
                }
                piece = new PieceL(largeur, hauteur);
                break;
            case 3:
                hauteur = 3 + (r.nextInt(DIM_MAX));
                largeur = 3 + (r.nextInt(DIM_MAX));
                hauteur= Math.min(hauteur, DIM_MAX);
                largeur= Math.min(largeur,DIM_MAX);
                if(hauteur%2==0 && largeur%2==0){
                    hauteur= Math.min(hauteur-1, DIM_MAX);
                }


                piece = new PieceO(largeur, hauteur);
                break;
            case 4:
                hauteur = 2 + (r.nextInt(DIM_MAX));
                largeur = 3 + (r.nextInt(DIM_MAX));
                hauteur= Math.min(hauteur, DIM_MAX);
                largeur= Math.min(largeur,DIM_MAX);
                if(hauteur%2==0 && largeur%2==0){
                    hauteur= Math.min(hauteur-1, DIM_MAX);
                }
                piece = new PieceT(largeur, hauteur);
                break;
            case 5:
                hauteur = 3 + (r.nextInt(DIM_MAX));
                largeur = 2 + (r.nextInt(DIM_MAX));
                hauteur= Math.min(hauteur, DIM_MAX);
                largeur= Math.min(largeur,DIM_MAX);
                if(hauteur%2==0 && largeur%2==0){
                    hauteur= Math.min(hauteur-1, DIM_MAX);
                }
                piece = new PieceC(largeur, hauteur);
                break;
            case 6:
                hauteur = 5 + (r.nextInt(DIM_MAX));
                largeur = 2 + (r.nextInt(DIM_MAX));
                hauteur= Math.min(hauteur, DIM_MAX);
                largeur= Math.min(largeur,DIM_MAX);
                if(hauteur%2==0 && largeur%2==0){
                    largeur= Math.min(largeur-1,DIM_MAX);
                }
                piece = new PieceE(largeur, hauteur);
                break;
            case 7:
                hauteur = 3 + (r.nextInt(DIM_MAX));
                largeur = 3 + (r.nextInt(DIM_MAX));
                hauteur= Math.min(hauteur, DIM_MAX);
                largeur= Math.min(largeur,DIM_MAX);
                if(hauteur%2==0 && largeur%2==0){
                    hauteur= Math.min(hauteur-1, DIM_MAX);
                }
                piece = new PieceH(largeur, hauteur);
                break;
            case 8:
                hauteur = 5 + (r.nextInt(DIM_MAX));
                largeur = 3 + (r.nextInt(DIM_MAX));
                hauteur= Math.min(hauteur, DIM_MAX);
                largeur= Math.min(largeur,DIM_MAX);
                if(hauteur%2==0){
                    hauteur= Math.min(hauteur-1, DIM_MAX);
                }
                if(largeur%2==0){
                    largeur= Math.min(largeur-1,DIM_MAX);
                }
                piece = new PieceS(largeur, hauteur);
                break;
            case 9:
                hauteur = 4 + (r.nextInt(DIM_MAX));
                largeur = 3 + (r.nextInt(DIM_MAX));
                hauteur= Math.min(hauteur, DIM_MAX);
                largeur= Math.min(largeur,DIM_MAX);
                if(hauteur%2==0 && largeur%2==0){
                    largeur= Math.min(largeur-1,DIM_MAX);
                }
                piece = new PieceA(largeur, hauteur);
                break;
            case 10:
                hauteur = 4 + (r.nextInt(DIM_MAX));
                largeur = 3 + (r.nextInt(DIM_MAX));
                hauteur= Math.min(hauteur, DIM_MAX);
                largeur= Math.min(largeur,DIM_MAX);
                if(hauteur%2==0 && largeur%2==0){
                    largeur= Math.min(largeur-1,DIM_MAX);
                }
                piece = new PieceP(largeur, hauteur);
                break;
            case 11:
                hauteur = 3 + (r.nextInt(DIM_MAX));
                largeur = 3 + (r.nextInt(DIM_MAX));
                hauteur= Math.min(hauteur, DIM_MAX);
                largeur= Math.min(largeur,DIM_MAX);
                if(hauteur%2==0 && largeur%2==0){
                    largeur= Math.min(largeur-1,DIM_MAX);
                }
                piece = new PieceX(largeur, hauteur);
                break;
            case 12:
                hauteur = 5 + (r.nextInt(DIM_MAX));
                largeur = 3 + (r.nextInt(DIM_MAX));
                hauteur= Math.min(hauteur, DIM_MAX);
                largeur= Math.min(largeur,DIM_MAX);
                if(hauteur%2==0 && largeur%2==0){
                    largeur= Math.min(largeur-1,DIM_MAX);
                }
                piece = new PieceB(largeur, hauteur);
                break;
            case 13:
                piece = new PieceCoeur(7, 6);
                break;
            case 14:
                hauteur = 5 + (r.nextInt(DIM_MAX));
                largeur = 2 + (r.nextInt(DIM_MAX));
                hauteur= Math.min(hauteur, DIM_MAX);
                largeur= Math.min(largeur,DIM_MAX);
                if(hauteur%2==0 && largeur%2==0){
                    largeur= Math.min(largeur-1,DIM_MAX);
                }
                piece = new PieceF(largeur, hauteur);
                break;
            case 15:
                hauteur = 3 + (r.nextInt(DIM_MAX));
                largeur = 3 + (r.nextInt(DIM_MAX));
                hauteur= Math.min(hauteur, DIM_MAX);
                largeur= Math.min(largeur,DIM_MAX);
                if(largeur%2==0){
                    largeur= Math.min(largeur-1, DIM_MAX);
                }
                piece = new PieceJ(largeur, hauteur);
                break;
        }

        //On génère des positions aleatoire.
        int posX=(int) (1 + (Math.random() * (maxX)));
        int posY=(int) (1 + (Math.random() * (maxY)));

        //On vérifie que les positions sont bien valide et retourne la piece générée.
        assert piece != null;
        if(posX<0) {
            posX=posX+piece.getPosition()[0];
        }
        if(posX>maxX){
            posX=posX-piece.getPosition()[0];
        }
        if(posY<0){
            posY=posY+piece.getPosition()[1];
        }
        if(posY>maxY){
            posY=posY-piece.getPosition()[1];
        }
        posY = posY<0 || posY>maxY ? (posY<0 ? posY+piece.getPosition()[0] : posY-piece.getPosition()[0] ) : posY;
        piece.deplace(posX,posY);
        return piece;

    }

    public static Piece randomAvecType(int maxX, int maxY,String type){
        switch (type) {
            case "A":
                return Randomizer.random(maxX,maxY,9);
            case "C":
                return Randomizer.random(maxX,maxY,5);
            case "E":
                return Randomizer.random(maxX,maxY,6);
            case "H":
                return Randomizer.random(maxX,maxY,7);
            case "I":
                return Randomizer.random(maxX,maxY,1);
            case "L":
                return Randomizer.random(maxX,maxY,2);
            case "O":
                return Randomizer.random(maxX,maxY,3);
            case "P":
                return Randomizer.random(maxX,maxY,10);
            case "S":
                return Randomizer.random(maxX,maxY,8);
            case "T":
                return Randomizer.random(maxX,maxY,4);
            case "X":
                return Randomizer.random(maxX,maxY,11);
            case "B":
                return Randomizer.random(maxX,maxY,12);
            case "♥":
                return Randomizer.random(maxX,maxY,13);
            case "F":
                return Randomizer.random(maxX,maxY,14);
            case "J":
                return Randomizer.random(maxX,maxY,15);
            default:
                System.err.println("No such piece available with type : "+type);
                return null;
        }
    }


}
