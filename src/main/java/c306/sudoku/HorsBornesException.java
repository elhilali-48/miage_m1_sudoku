package c306.sudoku;
/**
 * Sudoko.
 * Exception levée lorsque les paramètres de positions sortent de la grille.
 */
public class HorsBornesException extends Exception {
    /**
     * Constructeur pour HorsBornesException.
     */
    public HorsBornesException() {
        super("La position se situe en dehors des limites de la grille.");
    }
}
