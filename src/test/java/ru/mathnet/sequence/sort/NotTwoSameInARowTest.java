package ru.mathnet.sequence.sort;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class NotTwoSameInARowTest
{
    @Test
    public void test_empty_expectedReturnsTrue()
            throws
            Exception
    {
        assertTrue(new NotTwoSameInARow().test(Collections.emptyList()));
    }

    @Test
    public void test_oneElement_expectedReturnsTrue()
            throws
            Exception
    {
        assertTrue(new NotTwoSameInARow().test(Arrays.asList(NumericKeypadButton.getInstance(1))));
    }

    @Test
    public void test_notTwoSameDigitsInARow_expectedReturnsTrue()
            throws
            Exception
    {
        assertTrue(new NotTwoSameInARow().test(Arrays.asList(NumericKeypadButton.getInstance(1),
                                                                   NumericKeypadButton.getInstance(2),
                                                                   NumericKeypadButton.getInstance(3),
                                                                   NumericKeypadButton.getInstance(4))));
    }

    @Test
    public void test_TwoSameDigitsInARow_expectedReturnsFalse()
            throws
            Exception
    {
        assertFalse(new NotTwoSameInARow().test(Arrays.asList(NumericKeypadButton.getInstance(1),
                                                                    NumericKeypadButton.getInstance(1),
                                                                    NumericKeypadButton.getInstance(2),
                                                                    NumericKeypadButton.getInstance(3))));
    }
}