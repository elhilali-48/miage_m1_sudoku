package c306.sudoku;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class GrilleImpl implements Grille {
    
    private int dim;
    private ElementDeGrille[][] grille;

    //public GrilleImpl(int dim) {
    //    this.dim = dim;
    //    this.grille = new ElementDeGrille[dim][dim]; //La création de la grille
    //}

    /*public GrilleImpl(ElementDeGrille[] elem, ElementDeGrille[][] elem2) {
        this.dim = elem.length;
        this.grille = new ElementDeGrille[dim][dim];
        elementSet = new HashSet<ElementDeGrille>(Arrays.asList(elem));
        elementSet.add(null);
    }*/

    private Set<ElementDeGrille> elementSet;

    public GrilleImpl(ElementDeGrille[] elementDeGrilles, ElementDeGrille[][] grilleTab) {
        this.dim = grilleTab.length;
        this.grille = new ElementDeGrille[dim][dim];
        elementSet = new HashSet<ElementDeGrille>();
        // 1
        for(ElementDeGrille e : elementDeGrilles){
            elementSet.add(e);
        }
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
        }else{
            return grille[a][b];
        }
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
        return grille[a][b] != null;
    }
}
