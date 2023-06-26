import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.IOException;
import java.io.InputStream;
import java.util.Set;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import c306.sudoku.CaractereInterditException;
import c306.sudoku.ElementDeGrille;
import c306.sudoku.ElementDeGrilleImplAsChar;
import c306.sudoku.GrilleImpl;
import c306.sudoku.Grille;
import c306.sudoku.GrilleParser;
import c306.sudoku.HorsBornesException;
import c306.sudoku.ValeurImpossibleException;
import c306.sudoku.ValeurInitialeModificationException;

/**
 * Activité 2, TabAlgosTest.java .
 *
 * @author Groupe Q
 */
public class TestSoduku {

    private GrilleImpl grilleExemple;
    private Set<ElementDeGrille> AllElements;
    private int dim = 16;
    
    @BeforeEach
    public void setUp() throws IOException, CaractereInterditException, ValeurInitialeModificationException, HorsBornesException, ValeurImpossibleException {
        //InputStream fichierGrille = TestSoduku.class.getClassLoader().getResourceAsStream("sudoku16-a.txt");
        //grilleExemple = GrilleParser.parse(getClass().getResourceAsStream("/grilles/sudoku16-b.txt"));
        //AllElements = grilleExemple.getElements();

        InputStream in = getClass().getResourceAsStream("/grilles/sudoku16-b.txt");
        grilleExemple = (GrilleImpl) GrilleParser.parse(in);
        AllElements = grilleExemple.getElements();
        
        /*InputStream fichierGrille = getClass().getResourceAsStream("sudoku16-a.txt");
        if(fichierGrille != null){
            grilleExemple = GrilleParser.parse(fichierGrille);
            AllElements = grilleExemple.getElements();
        }*/
    }

    @Test
    public final void testDimension() {
        assertEquals(dim, grilleExemple.getDimension());
    }

    @Test
    public void TestGetElement(){
        assertTrue(AllElements.isEmpty());
    }

    @Test
    public void TestsetElement(){
        
        assertThrows(HorsBornesException.class, () -> {
            grilleExemple.setValue(-5, 1, grilleExemple.getValue(0, 8));
        });

        /*assertThrows(ValeurImpossibleException.class, () -> {
            //grilleExemple.setValue(15, 1, grilleExemple.getValue(0, 6));
            grilleExemple.setValue(15, 1, grilleExemple.getValue(0, 6));
        });*/

        assertThrows(CaractereInterditException.class, () -> {
            grilleExemple.setValue(0, 2, new ElementDeGrilleImplAsChar('z'));
        });

        /*assertThrows(ValeurInitialeModificationException.class, () -> {
            grilleExemple.setValue(0, 15, grilleExemple.getValue(0, 1));
        });*/

    }

    @Test
    public void TestgetValue(){
        assertThrows(HorsBornesException.class, () -> {
            grilleExemple.getValue(-5, 1);
        });
    }

    @Test
    public void TestisComplete(){
        assertFalse(grilleExemple.isComplete());
    }

    @Test
    public void TestisPossible() throws HorsBornesException, CaractereInterditException {
        
        assertTrue(grilleExemple.isPossible(1, 12, grilleExemple.getValue(0, 5)));

        assertThrows(HorsBornesException.class, () -> {
            grilleExemple.setValue(-5, 1, grilleExemple.getValue(0, 8));
        });

        assertThrows(CaractereInterditException.class, () -> {
            grilleExemple.setValue(0, 2, new ElementDeGrilleImplAsChar('z'));
        });

    }

    @Test
    public void TestisValeurInitiale(){
        assertTrue(!grilleExemple.isValeurInitiale(0, 0));
    }

}
