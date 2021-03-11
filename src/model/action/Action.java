package src.model.action;


/**
 * Structure d'une action. On peut l'effectuer ou l'annuler.
 */
public interface Action<E> {

    void effectuer();
    void annuler();
    E getSubject();

}
