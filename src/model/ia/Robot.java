package src.model.ia;

import src.model.PlateauPuzzle;

/**
 * Un robot va appliquer une methode de resolution suivant une strategy, sur un Plateau de jeu.
 */

public class Robot {

    private final PlateauPuzzle plateau;

    public Robot(PlateauPuzzle plateau){
        this.plateau=plateau;
    }

    public void appliqueStrategy(Strategy methode){
        methode.resolution(this.plateau);
    }


}
