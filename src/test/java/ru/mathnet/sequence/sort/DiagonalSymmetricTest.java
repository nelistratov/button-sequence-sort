package ru.mathnet.sequence.sort;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class DiagonalSymmetricTest
{
    @Test
    public void test_diagonalSymmetric_expectedReturnsTrue()
            throws
            Exception
    {
        assertTrue(new DiagonalSymmetric().test(Arrays.asList(NumericKeypadButton.getInstance(1), NumericKeypadButton
                .getInstance(3), NumericKeypadButton.getInstance(7))));
    }

    @Test
    public void test_diagonalSymmetric2_expectedReturnsTrue()
            throws
            Exception
    {
        assertTrue(new DiagonalSymmetric().test(Arrays.asList(NumericKeypadButton.getInstance(1), NumericKeypadButton
                .getInstance(3), NumericKeypadButton.getInstance(9))));
    }

    @Test
    public void test_diagonalNotSymmetric_expectedReturnsFalse()
            throws
            Exception
    {
        assertFalse(new DiagonalSymmetric().test(Arrays.asList(NumericKeypadButton.getInstance(1), NumericKeypadButton
                .getInstance(3),
                                                               NumericKeypadButton.getInstance(4))));
    }
}