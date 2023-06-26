package c.sudoku;

/**
 * Implémentation d'un élément de grille représenté par un caractère.
 */
public class ElementDeGrilleImplAsChar implements ElementDeGrille {
    /**
     * variable char.
     */
    private final char charactere;

    /**
     * ElementDeGrilleImpAsChar.
     * @param value parametre value
     */
    public ElementDeGrilleImplAsChar(final char value) {
        this.charactere = value;
    }
    /**
     * getValue.
     * @return recuperer la valeur.
     */
    public final char getValue() {
        return charactere;
    }

}
