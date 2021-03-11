package src.data;

public class PartieScore {

    private final String nomJoueur;
    private final Integer score;

    public PartieScore(String nomJoueur, Integer score){
        this.nomJoueur = nomJoueur;
        this.score = score;
    }

    public String getNomJoueur() {
        return this.nomJoueur;
    }

    public Integer getScore() {
        return this.score;
    }
}