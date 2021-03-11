package src.model.ia;

import src.model.PlateauPuzzle;
import src.model.action.Action;
import src.model.action.Rotation;
import src.model.action.Translater;
import src.model.piece.Piece;

public class BrutForceAction implements Strategy {

    private final int nbTour;

    public BrutForceAction(int nbTour) {
        this.nbTour=nbTour;
    }

    @Override
    public void resolution(PlateauPuzzle plateau) {
        int[] centre = new int[2];
        centre[0] = plateau.getTaille().clone()[0]/2;
        centre[1] = plateau.getTaille().clone()[1]/2;
        for (Piece p: plateau.getEnsemblePiece()){
            while (!plateau.isInCollision(p) || plateau.isInValidePositionPiece(p)){
                if(p.getPosition()[0]==centre[0] && p.getPosition()[1]==centre[1]){
                    break;
                }
                Action<Piece> translate=null;
                if(p.getPosition()[0]>centre[0] && p.getPosition()[1]>centre[1]){
                    translate= new Translater(p,-1,-1);
                }
                if(p.getPosition()[0]==centre[0] && p.getPosition()[1]>centre[1]){
                    translate= new Translater(p,0,-1);
                }
                if(p.getPosition()[0]>centre[0] && p.getPosition()[1]==centre[1]){
                    translate= new Translater(p,-1,0);
                }

                if(p.getPosition()[0]<centre[0] && p.getPosition()[1]>centre[1]){
                    translate= new Translater(p,+1,-1);
                }
                if(p.getPosition()[0]==centre[0] && p.getPosition()[1]>centre[1]){
                    translate= new Translater(p,0,-1);
                }
                if(p.getPosition()[0]<centre[0] && p.getPosition()[1]==centre[1]){
                    translate= new Translater(p,+1,0);
                }

                if(p.getPosition()[0]>centre[0] && p.getPosition()[1]<centre[1]){
                    translate= new Translater(p,-1,+1);
                }
                if(p.getPosition()[0]==centre[0] && p.getPosition()[1]<centre[1]){
                    translate= new Translater(p,0,+1);
                }
                if(p.getPosition()[0]>centre[0] && p.getPosition()[1]==centre[1]){
                    translate= new Translater(p,-1,0);
                }

                if(p.getPosition()[0]<centre[0] && p.getPosition()[1]<centre[1]){
                    translate= new Translater(p,+1,+1);
                }
                if(p.getPosition()[0]==centre[0] && p.getPosition()[1]<centre[1]){
                    translate= new Translater(p,0,+1);
                }
                if(p.getPosition()[0]<centre[0] && p.getPosition()[1]==centre[1]){
                    translate= new Translater(p,+1,0);
                }

                plateau.effectuerUneAction(translate);

            }
            while (plateau.isInCollision(p) || !plateau.isInValidePositionPiece(p)){
                plateau.defaireDerniereAction();
            }

        }


        int[] centre2 = new int[2];

        centre2[0] = plateau.getTaille().clone()[0] / 2;
        centre2[1] = plateau.getTaille().clone()[1] / 2;
        int i=0;
        while(i<this.nbTour){
        for (Piece p : plateau.getEnsemblePiece()) {
            i++;
            int scoreDebut = plateau.espaceOccupe();
            //Effectue une Rotation de Droite si elle diminue le ScoreDebut
            Action<Piece> rotateDroite = new Rotation(p,1);
            plateau.effectuerUneAction(rotateDroite);
            if(!plateau.isInCollision(p) && plateau.isInValidePositionPiece(p)){
                if ( plateau.espaceOccupe() < scoreDebut ){
                    continue;
                }
            }
            plateau.defaireDerniereAction();


            //Effectue une Rotation de Gauche si elle diminue le ScoreDebut
            Action<Piece> rotateGauche = new Rotation(p,-1);
            plateau.effectuerUneAction(rotateGauche);
            if(!plateau.isInCollision(p) && plateau.isInValidePositionPiece(p)){
                if ( plateau.espaceOccupe() < scoreDebut ){
                    continue;
                }
            }
            plateau.defaireDerniereAction();

            Action<Piece> translateDiaGaucheHaut = new Translater(p, -1, -1);
            plateau.effectuerUneAction(translateDiaGaucheHaut);
            if(!plateau.isInCollision(p) && plateau.isInValidePositionPiece(p)){
                if ( plateau.espaceOccupe() < scoreDebut ){
                    continue;
                }
            }
                plateau.defaireDerniereAction();
            Action<Piece> translateDiaDroiteHaut = new Translater(p, -1, 1);
            plateau.effectuerUneAction(translateDiaDroiteHaut);
            if(!plateau.isInCollision(p) && plateau.isInValidePositionPiece(p)){
                if ( plateau.espaceOccupe() < scoreDebut ){
                    continue;
                }
            }
                plateau.defaireDerniereAction();

            Action<Piece> translateDiaDroiteBas = new Translater(p, 1, 1);
            plateau.effectuerUneAction(translateDiaDroiteBas);
            if(!plateau.isInCollision(p) && plateau.isInValidePositionPiece(p)){
                if ( plateau.espaceOccupe() < scoreDebut ){
                    continue;
                }
            }
                plateau.defaireDerniereAction();

            Action<Piece> translateDiaGaucheBas = new Translater(p, 1, -1);
            plateau.effectuerUneAction(translateDiaGaucheBas);
            if(!plateau.isInCollision(p) && plateau.isInValidePositionPiece(p)){
                if ( plateau.espaceOccupe() < scoreDebut ){
                    continue;
                }
            }
                plateau.defaireDerniereAction();

            Action<Piece> translateGauche = new Translater(p, 0, -1);
            plateau.effectuerUneAction(translateGauche);
            if(!plateau.isInCollision(p) && plateau.isInValidePositionPiece(p)){
                if ( plateau.espaceOccupe() < scoreDebut ){
                    continue;
                }
            }
                plateau.defaireDerniereAction();


            Action<Piece> translateDroite = new Translater(p, 0, 1);
            plateau.effectuerUneAction(translateDroite);
            if(!plateau.isInCollision(p) && plateau.isInValidePositionPiece(p)){
                if ( plateau.espaceOccupe() < scoreDebut ){
                    continue;
                }
            }
                plateau.defaireDerniereAction();


            Action<Piece> translateHaut = new Translater(p, -1, 0);
            plateau.effectuerUneAction(translateHaut);
            if(!plateau.isInCollision(p) && plateau.isInValidePositionPiece(p)){
                if ( plateau.espaceOccupe() < scoreDebut ){
                    continue;
                }
            }
                plateau.defaireDerniereAction();


            Action<Piece> translateBas = new Translater(p, 1, 0);
            plateau.effectuerUneAction(translateBas);
            if(!plateau.isInCollision(p) && plateau.isInValidePositionPiece(p)){
                if ( plateau.espaceOccupe() < scoreDebut ){
                    continue;
                }
            }
                plateau.defaireDerniereAction();


            }

        }}
    }

