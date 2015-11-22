package ru.mathnet.sequence.sort;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class AntiDiagonalSymmetricTest
{
    @Test
    public void test_mainDiagonalSymmetric_expectedReturnsFalse()
            throws
            Exception
    {
        assertFalse(new AntiDiagonalSymmetric().test(Arrays.asList(NumericKeypadButton.getInstance(1),
                                                                   NumericKeypadButton.getInstance(3),
                                                                   NumericKeypadButton.getInstance(7))));
    }

    @Test
    public void test_antiDiagonalSymmetric_expectedReturnsTrue()
            throws
            Exception
    {
        assertTrue(new AntiDiagonalSymmetric().test(Arrays.asList(NumericKeypadButton.getInstance(1),
                                                                  NumericKeypadButton.getInstance(3),
                                                                  NumericKeypadButton.getInstance(9))));
    }

    @Test
    public void test_diagonalNotSymmetric_expectedReturnsFalse()
            throws
            Exception
    {
        assertFalse(new AntiDiagonalSymmetric().test(Arrays.asList(NumericKeypadButton.getInstance(1),
                                                                   NumericKeypadButton.getInstance(3),
                                                                   NumericKeypadButton.getInstance(4))));
    }
}