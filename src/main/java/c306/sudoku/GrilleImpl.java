package c306.sudoku;

import java.util.HashSet;
import java.util.Set;

public class GrilleImpl implements Grille {
    private int dimension;
    private ElementDeGrille[][] grille;

    public GrilleImpl(int dimension) {
        this.dimension = dimension;
        this.grille = new ElementDeGrille[dimension][dimension];
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
        return dimension;
    }

    @Override
    public void setValue(int x, int y, ElementDeGrille value)
            throws HorsBornesException, ValeurImpossibleException, CaractereInterditException, ValeurInitialeModificationException {
        if (x < 0 || x >= dimension || y < 0 || y >= dimension) {
            throw new HorsBornesException();
        }
        
        if (isValeurInitiale(x, y)) {
            throw new ValeurInitialeModificationException();
        }
        
        if (!isPossible(x, y, value)) {
            throw new ValeurImpossibleException();
        }

        if (!isPossible(x, y, value)) {
            throw new CaractereInterditException();
        }
        
        grille[x][y] = value;
    }

    @Override
    public ElementDeGrille getValue(int x, int y) throws HorsBornesException {
        if (x < 0 || x >= dimension || y < 0 || y >= dimension) {
            throw new HorsBornesException();
        }
        return grille[x][y];
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
    public boolean isPossible(int x, int y, ElementDeGrille value)
            throws HorsBornesException, CaractereInterditException {
        if (x < 0 || x >= dimension || y < 0 || y >= dimension) {
            throw new HorsBornesException();
        }
        
        if (value == null) {
            return true;
        }
        
        if (!getElements().contains(value)) {
            throw new CaractereInterditException();
        }
        
        return true;
    }

    @Override
    public boolean isValeurInitiale(int x, int y) {
        return false;
    }
}
