package src.control;

import src.data.Config;
import src.model.PlateauPuzzle;
import src.model.action.*; //Rotation, Translater
import src.model.piece.*; //Piece, PieceCoeur

import javafx.scene.Node;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.*; //Color, Paint
import javafx.scene.shape.*; //Rectangle, StrokeType

import java.util.*; //ArrayList, LinkedList

public class CaseGrille extends Rectangle {

    private final PlateauPuzzle plateau;
    private final LinkedList<PieceControlable> piecesControlables;

    private boolean clicked;
    private final int nbScroll=0;
    private final int[] clickInitial;
    private PieceControlable actual;

    public CaseGrille(int hauteur, int largeur,PlateauPuzzle plateauPuzzle){
        super(hauteur,largeur);
        this.plateau=plateauPuzzle;
        this.piecesControlables=new LinkedList<>();
        this.clickInitial=new int[2];
        setFill(Color.web(Config.COLOR_GRID));
        setStroke(Paint.valueOf(Config.COLOR_INTERFACE));
        this.setStrokeWidth(0.5);
        this.setStrokeType(StrokeType.INSIDE);
        initEvent();
    }

/*
---------------------------------------------------------------------------------------------------------------------
                                        GETTER/SETTER
---------------------------------------------------------------------------------------------------------------------
*/

    public LinkedList<PieceControlable> getPiecesControlables() {
        return piecesControlables;
    }

/*
---------------------------------------------------------------------------------------------------------------------
                                     METHODES
---------------------------------------------------------------------------------------------------------------------
*/

    public void ajoutPieceControlable(PieceControlable pc){
        if(!this.piecesControlables.contains(pc)){
        this.piecesControlables.add(pc);
        this.setFill(pc.getColor());}
    }

    public void suppPieceControlable(PieceControlable pc){
        this.piecesControlables.remove(pc);
        if(this.piecesControlables.isEmpty()){
            this.setFill(Color.web(Config.COLOR_GRID));
        }else{
            this.setFill(this.piecesControlables.getLast().getColor());
        }
    }

    public void initEvent(){

        //au moment du premier click
        this.onMousePressedProperty().set(mouseEvent -> {

            Node source = mouseEvent.getPickResult().getIntersectedNode();
            Integer colIndex = GridPane.getColumnIndex(source);
            Integer rowIndex = GridPane.getRowIndex(source);

            this.clickInitial[0]=rowIndex;
            this.clickInitial[1]=colIndex;


            if( ! this.getPiecesControlables().isEmpty()){
                    this.clicked=true;
                    this.actual=this.piecesControlables.getLast();
                }else{
                    this.clicked=false;
             }
            mouseEvent.consume();
        });


        //pendant le drag
        this.onMouseDraggedProperty().set(event -> {
            if (clicked) {

                //On recupère le Node (ici le rectangle) sur lequel la souris pointe
                Node source = event.getPickResult().getIntersectedNode() ;
                if(source!=null){
                    Integer colIndex = GridPane.getColumnIndex(source);
                    Integer rowIndex = GridPane.getRowIndex(source);

                    //On regarde si la position du rectangle est bien valide sinon on stope l'evenement;
                    if(colIndex==null || rowIndex==null || colIndex > this.plateau.getTaille()[0] || rowIndex > this.plateau.getTaille()[1] || this.actual==null){
                        event.consume();
                        return;
                    }
                    int destinationX= rowIndex-this.clickInitial[0];
                    int destinationY= colIndex-this.clickInitial[1];



                    Piece subject = this.actual.getPiece();
                    Translater deplace = new Translater(subject,destinationX,destinationY);
                    this.plateau.effectuerUneAction(deplace);
                    this.clickInitial[0]=rowIndex;
                    this.clickInitial[1]=colIndex;
                }
                event.consume();
            }
        });

        //a la fin du drag
        this.onMouseReleasedProperty().set(event -> {
            if (clicked) {

                Piece subject = this.actual.getPiece();
                while(this.plateau.isInCollision(subject) || ! this.plateau.isInValidePositionPiece(subject)){
                    this.plateau.defaireDerniereAction();
            }}
            event.consume();
        });

        //ROTATION
        this.setOnScroll(scrollEvent -> {
            Node source = scrollEvent.getPickResult().getIntersectedNode() ;
            Integer colIndex = GridPane.getColumnIndex(source);
            Integer rowIndex = GridPane.getRowIndex(source);
            if(colIndex==null || rowIndex==null || colIndex > this.plateau.getTaille()[0] || rowIndex > this.plateau.getTaille()[1] || this.getPiecesControlables().isEmpty()){
                scrollEvent.consume();
                return;
            }
            this.actual=this.getPiecesControlables().getLast();
            ArrayList<Integer> pos = new ArrayList<>();
            pos.add(colIndex);
            pos.add(rowIndex);
            Piece subject = this.actual.getPiece();
            if (this.actual.getPositions().contains(pos)){
            Rotation rotate = new Rotation(subject, (int) scrollEvent.getDeltaY());
            this.plateau.effectuerUneAction(rotate);
            if (this.plateau.isInCollision(subject) || !this.plateau.isInValidePositionPiece(subject)) {
                this.plateau.defaireDerniereAction();
            }}
            scrollEvent.consume();
        });
    }
}
