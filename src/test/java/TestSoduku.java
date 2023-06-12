import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import c306.sudoku.GrilleImpl;
import c306.sudoku.GrilleParser;

/**
 * Activité 2, TabAlgosTest.java .
 *
 * @author Groupe Q
 */
public class TestSoduku {

    //private final GrilleImpl grilleImpl = new GrilleImpl());
    /*public static char[][] GRID_TO_SOLVE = {
        {'@', '8', '@', '@', '3', '1', '7', '6', '@'},
        {'7', '5', '2', '@', '@', '9', '3', '@', '@'},
        {'@', '1', '6', '@', '2', '@', '@', '@', '@'},
        {'@', '@', '@', '@', '9', '@', '@', '1', '@'},
        {'@', '@', '@', '@', '1', '@', '@', '@', '6'},
        {'@', '9', '1', '@', '@', '@', '@', '2', '4'},
        {'8', '@', '3', '@', '6', '2', '@', '@', '@'},
        {'@', '6', '@', '@', '@', '4', '@', '@', '@'},
        {'@', '@', '4', '@', '@', '@', '@', '7', '3'},
    };*/

    //private final GrilleParser grilleParser = new GrilleParser(GRID_TO_SOLVE);

    @Test
    public final void testDimension() {
        int dim = 9;
        assertEquals(dim, 9);
    }

}
