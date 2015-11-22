package ru.mathnet.sequence.sort;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class AtLeastOneOnDiagonalTest
{
    @Test
    public void test_oneDigitOnDiagonal_expectedReturnsTrue()
            throws
            Exception
    {
        assertTrue(new AtLeastOneOnDiagonal().test(Arrays.asList(NumericKeypadButton.getInstance(3),
                                                                      NumericKeypadButton.getInstance(0),
                                                                      NumericKeypadButton.getInstance(2),
                                                                      NumericKeypadButton.getInstance(4))));
    }

    @Test
    public void test_noneDigitOnDiagonal_expectedReturnsFalse()
            throws
            Exception
    {
        assertFalse(new AtLeastOneOnDiagonal().test(Arrays.asList(NumericKeypadButton.getInstance(6),
                                                                       NumericKeypadButton.getInstance(0),
                                                                       NumericKeypadButton.getInstance(2),
                                                                       NumericKeypadButton.getInstance(4))));
    }
}