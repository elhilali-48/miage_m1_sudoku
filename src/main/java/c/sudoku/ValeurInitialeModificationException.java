package c.sudoku;
/**
 * Sudoko.
 * Quand on modifie une valeur initiale de la grille.
 */
public class ValeurInitialeModificationException extends Exception {
    /**
     * Constructeur pour ValeurInitialeModificationException.
     */
    public ValeurInitialeModificationException() {
        super("La valeur est initiale et ne peut pas être modifiée.");
    }
}
