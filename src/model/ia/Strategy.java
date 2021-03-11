package src.model.ia;

import src.model.PlateauPuzzle;

/**
 * Structure d'une Strategy applicable pour un Robot
 */
public interface Strategy {

    void resolution(PlateauPuzzle plateau);

}
