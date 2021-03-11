package src.model.ia;

import src.model.PlateauPuzzle;
import src.model.action.Action;
import src.model.action.Translater;
import src.model.piece.Piece;

public class BrutForce implements Strategy {

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

                if (translate != null) {
                    plateau.effectuerUneAction(translate);
                }

            }
            while (plateau.isInCollision(p) || !plateau.isInValidePositionPiece(p)){
                plateau.defaireDerniereAction();
            }

        }
    }
}
