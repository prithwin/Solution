package com.personal;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * Created by prajeeva on 7/4/17.
 * 'x','x','x','x','x','x'},
 {'x','x','x','H','W','I'},
 {'x','x','P','T','x','N'},
 {'x','x','R','I','x','Z'},
 {'x','x','x','x','x','x'},
 {'x','x','x','x','x','x'
 */
public class CrosswordTest {
    @Test
    public void testFindWordInMatrix() throws Exception {
    char[][] matrix =  {{'x','x','x','x','x','x'},
                        {'x','x','x','H','W','I'},
                        {'x','x','P','T','x','N'},
                        {'x','x','R','I','x','Z'},
                        {'x','x','x','x','x','x'},
                        {'x','x','x','x','x','x'}
                       };
        Crossword c = new Crossword();
        c.setMatrix(matrix);
        assertTrue(c.findWordInMatrix("PRITHWINZ"));
    }

    @Test
    public void testFindWordInMatrix2() throws Exception {
        char[][] matrix =  {{'x','x','x','x','x','x'},
                            {'x','x','x','x','x','x'},
                            {'x','x','x','x','x','x'},
                            {'x','N','x','R','P','x'},
                            {'x','I','x','I','x','x'},
                            {'x','W','H','T','x','x'}
        };
        Crossword c = new Crossword();
        c.setMatrix(matrix);
        assertTrue(c.findWordInMatrix("PRITHWIN"));
    }

    @Test
    public void testFindWordInMatrix3() throws Exception {
        char[][] matrix =  {{'x','x','x','x','x','x'},
                            {'x','x','x','P','W','I'},
                            {'x','R','U','M','x','N'},
                            {'x','T','R','I','x','Z'},
                            {'x','x','x','x','x','x'},
                            {'x','x','x','x','x','x'}
        };
        Crossword c = new Crossword();
        c.setMatrix(matrix);
        assertTrue(c.findWordInMatrix("TRUMP"));
    }

    @Test
    public void testFindWordInMatrix4() throws Exception {
        char[][] matrix =  {{'G','E','R','N','Y','x'},
                            {'x','x','M','A','W','I'},
                            {'x','R','U','M','x','N'},
                            {'x','T','R','I','x','Z'},
                            {'x','x','x','x','x','x'},
                            {'x','x','x','x','x','x'}
        };
        Crossword c = new Crossword();
        c.setMatrix(matrix);
        assertTrue(c.findWordInMatrix("GERMANY"));
    }

    @Test
    public void testFindWordInMatrixFalse() throws Exception {
        char[][] matrix =  {{'x','x','x','x','x','x'},
                {'x','x','x','H','W','I'},
                {'x','x','P','T','x','N'},
                {'x','x','R','I','x','Z'},
                {'x','x','x','x','x','x'},
                {'x','x','x','x','x','x'}
        };
        Crossword c = new Crossword();
        c.setMatrix(matrix);
        assertFalse(c.findWordInMatrix("PRITHWINT"));
    }

    @Test
    public void testFindWordInMatrixFalse2() throws Exception {
        char[][] matrix =  {{'x','x','x','x','x','x'},
                {'x','x','x','H','W','I'},
                {'x','x','P','T','x','N'},
                {'x','x','R','I','x','Z'},
                {'x','x','x','x','x','x'},
                {'x','x','x','x','x','x'}
        };
        Crossword c = new Crossword();
        c.setMatrix(matrix);
        assertFalse(c.findWordInMatrix("TOPAZ"));
    }
}