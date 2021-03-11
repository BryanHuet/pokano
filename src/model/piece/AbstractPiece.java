package src.model.piece;

import java.util.ArrayList;
import java.util.List;

/**
 * Implementation concrete d'une Piece
 */
public abstract class AbstractPiece implements Piece {

    private final int hauteur;
    private final int largeur;
    private final List<ArrayList<Integer>> range;
    private int[] position;
    private String sensRotation;

    public AbstractPiece(int largeur, int hauteur){
        this.hauteur=hauteur;
        this.largeur=largeur;
        this.position=new int[2];
        this.range=new ArrayList<>();
        this.sensRotation="default";
    }

/*
---------------------------------------------------------------------------------------------------------------------
                                    GETTER/SETTER
---------------------------------------------------------------------------------------------------------------------
*/
    public int getHauteur() {
        return this.hauteur;
    }

    public int getLargeur() {
        return this.largeur;
    }

    public int[] getPosition() {
        return this.position.clone();
    }

    public List<ArrayList<Integer>> getRange() {
        return this.range;
    }

    public String getSensRotation() { return this.sensRotation; }

    public void setPosition(int[] position) {
        this.position = position;
    }
    public void setPosition(int x,int y) {
        this.position[0] = x;
        this.position[1] = y;
    }

/*
---------------------------------------------------------------------------------------------------------------------
                                 METHODES
---------------------------------------------------------------------------------------------------------------------
*/

    protected void ajoutCoord(ArrayList<Integer> coords){
    if(!this.range.contains(coords)){
        this.range.add(coords);
    }
}

    /**
     * Methode qui permet de savoir si la piece occupe une certaine coordonne x,y
     * @param x Position x de la coordonnee a tester
     * @param y Position y de la coordonnee a tester
     * @return vrai si la piece occupe cette coordonne faux sinon.
     */
    public boolean occupe(int x, int y) {
        if(this.range.isEmpty()){
            return false;
        }
        List<Integer> pos = new ArrayList<>();
        pos.add(x-this.getPosition()[0]);
        pos.add(y-this.getPosition()[1]);
        return this.range.contains(pos);
    }

    /**
     * Implementation de la methode de deplacement d'une piece
     * @param x Nouvelle position x
     * @param y Nouvelle position y
     */
    public void deplace(int x, int y) {
        this.setPosition(new int[]{x, y});
    }

    /**
     * Implementation de la methode de rotation d'une piece. Tourne la piece par rapport a son centre
     * @param sens Permet de definir le sens de rotation, entier positif -> la piece tourne vers la gauche, entier negatif -> la piece tourne vers la droite.
     */
    public void rotate(int sens) {
        this.MAJsensRotation(sens);
        for (ArrayList<Integer> integers : this.range) {
            int tmp = integers.get(0);
            if(sens<0) {
                integers.set(0, integers.get(1));
                integers.set(1, -(tmp));
            }else {
                integers.set(0, -(integers.get(1)));
                integers.set(1, tmp);
            }
        }
    }

    public void MAJsensRotation(int sens){

        if ("default".equals(this.sensRotation)) {
            if (sens > 0) {
                this.sensRotation = "left";
            } else {
                this.sensRotation = "right";
            }
        } else if ("right".equals(this.sensRotation)) {
            if (sens > 0) {
                this.sensRotation = "default";
            } else {
                this.sensRotation = "down";
            }
        } else if ("left".equals(this.sensRotation)) {
            if (sens > 0) {
                this.sensRotation = "down";
            } else {
                this.sensRotation = "default";
            }
        } else if ("down".equals(this.sensRotation)) {
            if (sens > 0) {
                this.sensRotation = "right";
            } else {
                this.sensRotation = "left";
            }
        }
    }

    /**
     * Implementation de la methode de translation d'une piece.
     * @param x Translation de x pas
     * @param y Translation de y pas
     */
    public void translate(int x, int y) {
        this.deplace(this.getPosition()[0]+x,this.getPosition()[1]+y);
    }


}
