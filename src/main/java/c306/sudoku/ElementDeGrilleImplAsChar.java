package c306.sudoku;

/**
 * Implémentation d'un élément de grille représenté par un caractère.
 */
public class ElementDeGrilleImplAsChar implements ElementDeGrille {
    private char value;

    public ElementDeGrilleImplAsChar(char value) {
        this.value = value;
    }

    public char getValue() {
        return value;
    }

    public void setValue(char value) {
        this.value = value;
    }
}