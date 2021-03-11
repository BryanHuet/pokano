package src.view;

import src.model.PlateauPuzzle;
import src.model.ecouteur.EcouteurModele;
import src.model.piece.Piece;

import src.control.*; //CaseGrille, PieceControlable
import javafx.scene.*; //Group, Node
import javafx.scene.layout.GridPane;
import java.util.*;

public class VuePlateau extends GridPane implements EcouteurModele {

    public static Integer TAILLE_CASE = 600;

    // Ensemble de Case qui represente les cases de la grille occupée par une piece.
    private HashMap<Piece,PieceControlable> ensemblePiece;
    private PlateauPuzzle plateauPuzzle;


    public VuePlateau(PlateauPuzzle plateauPuzzle) {
        this.plateauPuzzle = plateauPuzzle;
        this.ensemblePiece = new HashMap<>();
        //on ajoute la vue comme ecouteur du modele (MVC)
        this.plateauPuzzle.ajoutEcouteur(this);

        //Paramétrage de la grille
        TAILLE_CASE = TAILLE_CASE / plateauPuzzle.getTaille()[1];
        this.setGridLinesVisible(true);
        //this.setHgap(1);
        //this.setVgap(1);
        this.setMaxSize((TAILLE_CASE * plateauPuzzle.getTaille()[0]) + (plateauPuzzle.getTaille()[0]), (TAILLE_CASE * plateauPuzzle.getTaille()[1]) + (plateauPuzzle.getTaille()[1]));
        this.setMinSize((TAILLE_CASE * plateauPuzzle.getTaille()[0]) + (plateauPuzzle.getTaille()[0]), (TAILLE_CASE * plateauPuzzle.getTaille()[1]) + (plateauPuzzle.getTaille()[1]));

        //Construction de la grille
        this.buildGrid();

    }

/*
---------------------------------------------------------------------------------------------------------------------
                                GETTER/SETTER
---------------------------------------------------------------------------------------------------------------------
 */

    public HashMap<Piece,PieceControlable> getEnsemblePiece() {
        return ensemblePiece;
    }
    public PlateauPuzzle getPlateauPuzzle() {
        return plateauPuzzle;
    }

    /**
     * Methode qui permet de recuperer la case en position (x,y) de la grille
     * @param col Position x
     * @param row Position y
     * @return Un objet du type de la case en position (x,y)
     */
    private CaseGrille getPaneFromGrid(int col, int row) {
        for (Node node : this.getChildren()) {
            if(! (node instanceof Group)){
                Integer columnIndex = GridPane.getColumnIndex(node);
                Integer rowIndex = GridPane.getRowIndex(node);

                if (columnIndex == null)
                    columnIndex = 0;
                if (rowIndex == null)
                    rowIndex = 0;

                if (columnIndex == col && rowIndex == row) {
                    return (CaseGrille) node;
                }
            }
        }
        return null;
    }


    public void setEnsemblePiece(HashMap<Piece,PieceControlable> ensemblePiece) {
        this.ensemblePiece = ensemblePiece;
    }

    public void setPlateauPuzzle(PlateauPuzzle plateauPuzzle) {
        this.plateauPuzzle = plateauPuzzle;
    }


    /*
---------------------------------------------------------------------------------------------------------------------
                                 METHODES
---------------------------------------------------------------------------------------------------------------------
 */

    /**
     * Construit la grille suivant la taille du plateau de jeu.
     */
    public void buildGrid(){
        this.getChildren().clear();
        for(int i = 0 ; i<= plateauPuzzle.getTaille()[0] ; i++) {
            for (int j = 0 ; j <= plateauPuzzle.getTaille()[1] ; j++) {
                this.add(new CaseGrille(TAILLE_CASE, TAILLE_CASE ,this.plateauPuzzle), i, j);
            }
        }
    }

    private void dessineUnePiece(Piece p) {
        if (!this.ensemblePiece.containsKey(p)) {
            PieceControlable pc = new PieceControlable(p);
            this.ensemblePiece.put(p, pc);
        }
        PieceControlable pc = this.ensemblePiece.get(p);
        pc.majPositions();
        for (ArrayList<Integer> pos : pc.getPositions()) {
            try{
                Objects.requireNonNull(this.getPaneFromGrid(pos.get(0), pos.get(1))).ajoutPieceControlable(pc);
            }catch (Exception ignored){}
        }
    }

    private void cleanUnePiece(Piece p){
        if (this.ensemblePiece.containsKey(p)) {
            PieceControlable pc = this.ensemblePiece.get(p);
            //pc.majPositions();
            for(ArrayList<Integer> pos : pc.getPositions()){
                if(this.getChildren().contains(this.getPaneFromGrid(pos.get(0), pos.get(1)))){
                    Objects.requireNonNull(this.getPaneFromGrid(pos.get(0), pos.get(1))).suppPieceControlable(pc);
                }
            }
        }

    }

    //Cette methode est appelée lorsque le modele est mis a jour (MVC)
    @Override
    public void modeleMisAJour(Object source) {
        ArrayList<Piece> tempo = new ArrayList<>();
        for (Map.Entry<Piece, PieceControlable> entry : this.ensemblePiece.entrySet()) {
            if(!this.plateauPuzzle.getEnsemblePiece().contains(entry.getKey())){
                this.cleanUnePiece(entry.getKey());
                tempo.add(entry.getKey());
            }
        }

        for(Piece p : tempo){
            this.ensemblePiece.remove(p);
        }

        for(Piece p : this.plateauPuzzle.getEnsemblePiece()){
            this.cleanUnePiece(p);
            this.dessineUnePiece(p);
        }
    }
}