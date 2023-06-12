package c306.sudoku;

import java.util.HashSet;
import java.util.Set;

public class GrilleImpl implements Grille {
    
    private int dim; // Dimension de la grille
    private ElementDeGrille[][] grille; // Grille du jeu

    //public GrilleImpl(int dim) {
    //    this.dim = dim;
    //    this.grille = new ElementDeGrille[dim][dim]; //La création de la grille
    //}

    public GrilleImpl(ElementDeGrille[]  grille) {
        this.dim = grille.length;
        //this.grille = grille;
    }

    @Override
    public Set<ElementDeGrille> getElements() {
        Set<ElementDeGrille> elements = new HashSet<ElementDeGrille>();
        for (ElementDeGrille[] row : grille) {
            for (ElementDeGrille element : row) {
                if (element != null) {
                    elements.add(element);
                }
            }
        }
        return elements;
    }

    @Override
    public int getDimension() {
        return dim;
    }

    @Override
    public void setValue(int a, int b, ElementDeGrille valeur)
            throws ValeurImpossibleException, HorsBornesException, CaractereInterditException, ValeurInitialeModificationException {
        if (!isPossible(a, b, valeur)) {
            throw new ValeurImpossibleException(String.valueOf(valeur));
        }

        if (a < 0 || a >= dim || b < 0 || b >= dim) {
            throw new HorsBornesException();
        }

        if (!isPossible(a, b, valeur)) {
            throw new CaractereInterditException();
        }

        if (isValeurInitiale(a, b)) {
            throw new ValeurInitialeModificationException();
        }
        
        grille[a][b] = valeur;
    }

    @Override
    public ElementDeGrille getValue(int a, int b) throws HorsBornesException {
        if (a < 0 || a >= dim || b < 0 || b >= dim) {
            throw new HorsBornesException();
        }
        return grille[a][b];
    }

    @Override
    public boolean isComplete() {
        for (ElementDeGrille[] row : grille) {
            for (ElementDeGrille element : row) {
                if (element == null) {
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public boolean isPossible(int a, int b, ElementDeGrille valeur)
            throws HorsBornesException, CaractereInterditException {
        if (a < 0 || a >= dim || b < 0 || b >= dim) {
            throw new HorsBornesException();
        }
        
        if (valeur == null) {
            return true;
        }
        
        if (!getElements().contains(valeur)) {
            throw new CaractereInterditException();
        }
        
        return true;
    }

    @Override
    public boolean isValeurInitiale(int a, int b) {
        return false;
    }
}
