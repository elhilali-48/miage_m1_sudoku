package c306.sudoku;

/**
 * Implémentation d'un élément de grille représenté par un caractère.
 */
public class ElementDeGrilleImplAsChar implements ElementDeGrille {
    
    private final char charactere;

    public ElementDeGrilleImplAsChar(char value) {
        this.charactere = value;
    }

    public char getValue() {
        return charactere;
    }

}
