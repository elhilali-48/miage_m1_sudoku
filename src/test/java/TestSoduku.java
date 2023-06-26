import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.IOException;
import java.io.InputStream;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import c.sudoku.CaractereInterditException;
import c.sudoku.ElementDeGrille;
import c.sudoku.ElementDeGrilleImplAsChar;
import c.sudoku.GrilleImpl;
import c.sudoku.GrilleParser;
import c.sudoku.HorsBornesException;
import c.sudoku.ValeurImpossibleException;
import c.sudoku.ValeurInitialeModificationException;

/**
 * Activité 2, TabAlgosTest.java .
 *
 * @author Groupe Q
 */
public class TestSoduku {

    /**
    grilleExemple.
    */
    private GrilleImpl grilleExemple;
    /**
    allElements.
    */
    private Set<ElementDeGrille> allElements;
    /**
    constante.
    */
    private static final int C16 = 16;
    /**
    Dimmensions attendues.
    */
    private int dim = C16;

    /**
    constante.
    */
    private static final int C0 = 0;
    /**
    constante.
    */
    private static final int C8 = 8;
    /**
    constante.
    */
    private static final int C2 = 2;
    /**
    constante.
    */
    private static final int C05 = -5;
    /**
    constante.
    */
    private static final int C1 = 1;
    /**
    constante.
    */
    private static final int C12 = 12;
    /**
    constante.
    */
    private static final int C5 = 5;

    /**
     * Se lance avant chaque test.
     * @throws IOException IOException
     * @throws CaractereInterditException CaractereInterditException
     * @throws ValeurInitialeModificationException ValeurInitiale
     * @throws HorsBornesException HorsBornesException
     * @throws ValeurImpossibleException ValeurImpossibleException
     */
    @BeforeEach
    public final void setUp() throws IOException, CaractereInterditException,
    ValeurInitialeModificationException,
    HorsBornesException, ValeurImpossibleException {
        InputStream in = getClass().
        getResourceAsStream("/grilles/sudoku16-b.txt");
        grilleExemple = (GrilleImpl) GrilleParser.parse(in);
        allElements = grilleExemple.getElements();
        /*if(fichierGrille != null){
            grilleExemple = GrilleParser.parse(fichierGrille);
            AllElements = grilleExemple.getElements();
        }*/
    }

    /**
     * testDimension.
     */
    @Test
    public final void testDimension() {
        assertEquals(dim, grilleExemple.getDimension());
    }

    /**
     * testGetElement.
     */
    @Test
    public final void testGetElement() {
        assertTrue(allElements.isEmpty());
    }

    /**
     * testsetElement.
     * @throws HorsBornesException
     * @throws CaractereInterditException
     */
        @Test
        public final void testsetElement() {
            assertThrows(HorsBornesException.class, () -> {
                grilleExemple.setValue(C05, C1, grilleExemple.getValue(C0, C8));
            });

            /*assertThrows(ValeurImpossibleException.class, () -> {
                //grilleExemple.setValue(15, 1, grilleExemple.getValue(0, 6));
                grilleExemple.setValue(15, 1, grilleExemple.getValue(0, 6));
            });*/

            assertThrows(CaractereInterditException.class, () -> {
                grilleExemple.setValue(C0, C2, new ElementDeGrilleImplAsChar('z'));
            });

            /*assertThrows(ValeurInitialeModificationException.class, () -> {
                grilleExemple.setValue(0, 15, grilleExemple.getValue(0, 1));
            });*/

        }

    /**
     * testgetValue.
     * @throws HorsBornesException
     */
    @Test
    public final void testgetValue() {
        assertThrows(HorsBornesException.class, () -> {
            grilleExemple.getValue(C05, C1);
        });
    }

    /**
     * TestisComplete.
     */
    @Test
    public final void testisComplete() {
        assertFalse(grilleExemple.isComplete());
        //assertTrue(!grilleExemple.isComplete());
    }

    /**
     * testisPossible.
     * @throws HorsBornesException HorsBornesException
     * @throws CaractereInterditException CaractereInter
     */
    @Test
    public final void testisPossible() throws HorsBornesException,
    CaractereInterditException {

        assertTrue(grilleExemple.
        isPossible(C1, C12, grilleExemple.getValue(C0, C5)));

        assertThrows(HorsBornesException.class, () -> {
            grilleExemple.setValue(C05, C1, grilleExemple.getValue(C0, C8));
        });

        assertThrows(CaractereInterditException.class, () -> {
            grilleExemple.setValue(C0, C2, new ElementDeGrilleImplAsChar('z'));
        });

    }

    /**
     * testisValeurInitiale.
     */
    @Test
    public final void testisValeurInitiale() {
        assertTrue(!grilleExemple.isValeurInitiale(C0, C0));
    }

}
