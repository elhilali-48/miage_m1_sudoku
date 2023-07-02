package c.sudoku;

import java.util.HashSet;
import java.util.Set;
/**
 * Grille.
 */
public class GrilleImpl implements Grille {
    /**
     * dim int.
     */
    private int dim;
    /**
     * private ElementGrille.
     */
    private ElementDeGrille[][] grille;
    //public GrilleImpl(int dim) {
    //    this.dim = dim;
    //    this.grille = new ElementDeGrille[dim][dim];
    //La création de la grille
    //}

    /*public GrilleImpl(ElementDeGrille[] elem, ElementDeGrille[][] elem2) {
        this.dim = elem.length;
        this.grille = new ElementDeGrille[dim][dim];
        elementSet = new HashSet<ElementDeGrille>(Arrays.asList(elem));
        elementSet.add(null);
    }*/
    /**
     * elementSet set un element.
     */
    private Set<ElementDeGrille> elementSet;
    /**
     *
     * @param elementDeGrilles elements de la grille
     * @param grilleTab tableau de grille
     */
    public GrilleImpl(final ElementDeGrille[] elementDeGrilles,
     final ElementDeGrille[][] grilleTab) {
        this.dim = grilleTab.length;
        this.grille = new ElementDeGrille[dim][dim];
        elementSet = new HashSet<ElementDeGrille>();
        // 1
        for (ElementDeGrille e : elementDeGrilles) {
            elementSet.add(e);
        }
}

    @Override
    public final Set<ElementDeGrille> getElements() {
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
    public final int getDimension() {
        return dim;
    }

    @Override
    public final void setValue(final int a, final int b,
     final ElementDeGrille valeur)
            throws ValeurImpossibleException, HorsBornesException,
            CaractereInterditException, ValeurInitialeModificationException {
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
    public final ElementDeGrille getValue(final int a, final int b)
        throws HorsBornesException {
        if (a < 0 || a >= dim || b < 0 || b >= dim) {
            throw new HorsBornesException();
        } else {
            return grille[a][b];
        }
    }

    @Override
    public final boolean isComplete() {
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
    public final boolean isPossible(final int a, final int b,
    final ElementDeGrille valeur)
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

        //Ajouter le test de ligne et colonne
        int tailleBloc = (int) Math.sqrt(dim);
        int blocX = (a / tailleBloc) * tailleBloc;
        int blocY = (b / tailleBloc) * tailleBloc;
        for (int i = blocX; i < blocX + tailleBloc; i++) {
            for (int j = blocY; j < blocY + tailleBloc; j++) {
                if (grille[i][j] == valeur) {
                    return false; // L'élément se trouve déjà dans le bloc.
                }
            }
        }

        for (int i = 0; i < dim; i++) {
            if (grille[a][i] == valeur || grille[i][b] == valeur) {
                return false; // L'élément se trouve déjà dans la ligne ou dans la colonne.
            }
        }

         return true;
    }

    @Override
    public final boolean isValeurInitiale(final int a, final int b) {
        return grille[a][b] != null;
        //riyedd
    }
}
