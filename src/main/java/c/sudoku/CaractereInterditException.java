package c.sudoku;
/**
 * Sudoko.
 * Quand une valeur qui ne fait pas partie du jeu de valeurs.
 */
public class CaractereInterditException extends Exception {
    /**
     * Constructeur pour CaractereInterditException.
     */
    public CaractereInterditException() {
        super("Le caractère n'est pas autorisé en Sudoku.");
    }
}
