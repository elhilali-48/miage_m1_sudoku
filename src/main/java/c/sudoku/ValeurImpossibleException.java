package c.sudoku;
/**
 * Sudoko.
 * Quand une valeur dans la grille qui ne respecte pas les règles.
 */
public class ValeurImpossibleException extends Exception {
    /**
     * Constructeur pour ValeurImpossibleException.
     * @param element element
     */
    public ValeurImpossibleException(final String element) {
        super("La valeur" + element
        + " spécifiée ne respecte pas les règles du Sudoku.");
    }
}
