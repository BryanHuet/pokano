package src.model;

import src.model.action.Action;
import src.model.ecouteur.AbstractModeleEcoutable;
import src.model.piece.*;
import java.util.ArrayList;
import java.util.HashSet;

public class PlateauPuzzle extends AbstractModeleEcoutable {
    private HashSet<Piece> ensemblePiece;
    private int[] taille = new int[2];
    private ArrayList<Action<Piece>> listeActions;
    private String name;

    public PlateauPuzzle(int hauteur, int largeur) {
        super();
        this.taille[0] = hauteur;
        this.taille[1] = largeur;
        this.name="null";

        this.ensemblePiece = new HashSet<>();
        this.ecouteurs = new ArrayList<>();
        this.listeActions = new ArrayList<>();
    }
/*
---------------------------------------------------------------------------------------------------------------------
                                GETTER/SETTER
---------------------------------------------------------------------------------------------------------------------
 */
    public HashSet<Piece> getEnsemblePiece() {
        return ensemblePiece;
    }

    public int[] getTaille() {
        return taille;
    }

    public String getName(){
        return this.name;
    }

    public int getNbPiece() {
        return this.ensemblePiece.size();
    }

    public Action<Piece> getDerniereAction(){
        if(this.listeActions.isEmpty()){
            return null;
        }
        return this.listeActions.get(this.listeActions.size()-1);
    }

    public ArrayList<Action<Piece>> getListeActions() {
        return listeActions;
    }

    public void setEnsemblePiece(HashSet<Piece> ensemblePiece) {
        this.ensemblePiece = ensemblePiece;
    }

    public void setTaille(int[] taille) {
        this.taille = taille;
    }

    public void setListeActions(ArrayList<Action<Piece>> listeActions) {
        this.listeActions = listeActions;
    }

    public void setName(String name){
        this.name=name;
        fireChangement();
    }

/*
---------------------------------------------------------------------------------------------------------------------
                                 METHODES
---------------------------------------------------------------------------------------------------------------------
 */

    public void ajoutPiece(Piece p){
        if(! ensemblePiece.isEmpty()){
            if(! ensemblePiece.contains(p)){
                if (! isInCollision(p) && isInValidePositionPiece(p)) this.ensemblePiece.add(p);
            }
        }else{
            if(isInValidePositionPiece(p)) this.ensemblePiece.add(p);
        }
        fireChangement();
    }

    public void suppPiece(Piece p){
        if(ensemblePiece.contains(p)){
            this.ensemblePiece.remove(p);
            fireChangement();
        }
    }

    /**
     * Calcul de l'espace occupe par l'ensemble des pieces du plateu, pour ce faire on regarde les quatres pieces aux
     * extremite, puis on calcul l'air du rectangle qu'elles forment.
     *
     * @return une entier representant l'air du rectangle
     */
    public int espaceOccupe(){

        if (this.ensemblePiece.isEmpty()){
            return 0;
        }
        Object pieceSud=null;
        Object pieceEst=null;
        Object pieceOuest=null;
        Object pieceNord=null;

        int[] coordNord=new int[2];
        int[] coordSud=new int[2];
        int[] coordOuest=new int[2];
        int[] coordEst=new int[2];

        //----PieceNord
        for (int i=0;i<this.getTaille()[0]+1;i++){
            for(int j=0;j<this.getTaille()[1]+1;j++){
                if(pieceAtPosition(i,j)!=null){
                    pieceNord= pieceAtPosition(i,j);
                    coordNord[0]=i;
                    coordNord[1]=j;
                    break;
                }
            }
            if(pieceNord!=null){
                break;
            }
        }
        //---PieceSud----
        for (int i=getTaille()[0]+1;i>=0;i--){
            for(int j=0;j<this.getTaille()[1]+1;j++){
                if(pieceAtPosition(i,j)!=null){
                    pieceSud= pieceAtPosition(i,j);
                    coordSud[0]=i;
                    coordSud[1]=j;
                    break;
                }
            }
            if(pieceSud!=null){
                break;
            }
        }
        //----PieceEst----
        for (int i=this.getTaille()[0]+1;i>=0;i--){
            for(int j=this.getTaille()[1]+1;j>=0;j--){
                if(pieceAtPosition(j,i)!=null){
                    pieceEst= pieceAtPosition(j,i);
                    coordEst[0]=j;
                    coordEst[1]=i;
                    break;
                }
            }
            if(pieceEst!=null){
                break;
            }
        }
        //----PieceOuest----
        for (int i=0;i<this.getTaille()[0]+1;i++){
            for(int j=0;j<this.getTaille()[1]+1;j++){

                if(pieceAtPosition(j,i)!=null){
                    pieceOuest= pieceAtPosition(j,i);
                    coordOuest[0]=j;
                    coordOuest[1]=i;
                    break;
                }
            }
            if(pieceOuest!=null){
                break;
            }
        }


        int[] coinNordOuest=new int[2];
        int[] coinSudEst=new int[2];
        int[] coinNordEst=new int[2];

        //----Coin Haut-Gauche----

        coinNordEst[0]=coordNord[0];
        coinNordEst[1]=coordEst[1];

        //----Coin Bas-Droite----

        coinSudEst[0]=coordSud[0];
        coinSudEst[1]=coordEst[1];

        //----Coin Haut-Droite----

        coinNordOuest[0]=coordNord[0];
        coinNordOuest[1]=coordOuest[1];

        // On calcul la longueur et la largeur du rectangle, et on retourne son air.
        int longueur=coinNordEst.clone()[1]-coinNordOuest.clone()[1];
        int hauteur=coinSudEst.clone()[0]-coinNordEst.clone()[0];
        return longueur*hauteur;
    }

    /**
     * On regarde si la position (x,y) est occupee par une piece, si oui alors on retourne la piece
     * @param x Position x
     * @param y Position y
     * @return Si elle existe la piece qui occupe la position (x,y) sinon null
     */
    public Piece pieceAtPosition(int x, int y){
        for(Piece piece: this.ensemblePiece){
            if(piece.occupe(x,y)){
                return piece;
            }
        }
        return null;
    }

    /**
     * Detecte la collision entre deux pieces. On parcours la range de la Piece p1 et on regarde si p2 occupe une des
     * positions.
     * @param p1 Objet de type Piece
     * @param p2 Objet de type Piece
     * @return vrai lorsqu'il y a collision, faux sinon.
     */
    public boolean collision(Piece p1, Piece p2){
        for(ArrayList<Integer> pos: p1.getRange()){
            if(p2.occupe(p1.getPosition()[0]+pos.get(0),p1.getPosition()[1]+ pos.get(1))){
                return true;
            }
        }
        return false;
    }

    /**
     * Methode qui regarde si la piece en parametre a une position valide dans le plateau
     * @param piece la piece a tester
     * @return vrai si la position est valide, faux sinon
     */
    public boolean isInValidePositionPiece(Piece piece){
        for(ArrayList<Integer> pos: piece.getRange()){
            if(piece.getPosition()[0]+pos.get(0)<0 | piece.getPosition()[1]+ pos.get(1)<0 | piece.getPosition()[0]+pos.get(0)>this.getTaille()[0] | piece.getPosition()[1]+ pos.get(1)>this.getTaille()[1]){
                        return false;
            }
        }
        return true;
    }

    /**
     * Methode qui regarde si la piece en parametre est en collision avec une piece du plateau
     * @param piece la piece a tester
     * @return vrai s'il y a une collision, faux sinon
     */
    public boolean isInCollision(Piece piece){
        for(Piece p : this.getEnsemblePiece()){
            if(p!=piece){
                if(this.collision(p,piece)){
                    return true;
                }
            }
        }
        return false;
    }

    public void supprimeToutePieces(){
        this.ensemblePiece=new HashSet<>();
        this.listeActions=new ArrayList<>();
        fireChangement();
    }

    /**
     * Genere des pieces aleatoires et les ajoutes au plateau
     * @param nbPiece Un entier representant le nombre de piece a generer sur le plateau
     */
    public void generationAlea(int nbPiece){
        if(nbPiece<0){
            return;
        }
        while(this.ensemblePiece.size()<nbPiece){
            Piece randomPiece = Randomizer.random(this.taille[0],this.taille[1],0);
            if(isInValidePositionPiece(randomPiece)){
            this.ajoutPiece(randomPiece);}
        }
    }

    public void effectuerUneAction(Action<Piece> act) {
        act.effectuer();
        this.listeActions.add(act);
        fireChangement();
    }

    public void defaireDerniereAction(){
        if(this.getDerniereAction()!=null){
            this.getDerniereAction().annuler();
        }
        this.listeActions.remove(this.getDerniereAction());
        fireChangement();
    }

    public void replace(PlateauPuzzle newPlateau){
        this.setEnsemblePiece(newPlateau.getEnsemblePiece());
        this.setTaille(newPlateau.getTaille());
        this.setName(newPlateau.getName());
        this.setListeActions(newPlateau.getListeActions());
        fireChangement();
    }

}

