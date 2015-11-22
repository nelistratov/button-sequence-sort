package ru.mathnet.sequence.sort;

import org.junit.Test;
import org.junit.contrib.theories.DataPoints;
import org.junit.contrib.theories.FromDataPoints;
import org.junit.contrib.theories.Theories;
import org.junit.contrib.theories.Theory;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

@RunWith(Theories.class)
public class NumericKeypadButtonTest
{
    @SuppressWarnings("unused")
    @DataPoints
    public static int[] values()
    {
        int[] result = new int[10];
        for (int i = 0; i < 9; i++)
            result[i] = i;
        return result;
    }

    @Theory
    public void getInstance_ZeroToNineValue_expectedDecimalDigitValueEqualsToSource(int value)
            throws
            Exception
    {
        assertEquals(value, NumericKeypadButton.getInstance(value).getValue());
    }

    @SuppressWarnings("unused")
    @DataPoints("buttonsOnMainDiagonal")
    public static NumericKeypadButton[] buttonsOnMainDiagonal = {NumericKeypadButton.getInstance(1),
                                                                 NumericKeypadButton.getInstance(5),
                                                                 NumericKeypadButton.getInstance(9)};

    @Theory
    public void mainDiagonalSymmetric_forButtonsOnMainDiagonal_expectedReturnsItself(
            @FromDataPoints("buttonsOnMainDiagonal") NumericKeypadButton numericKeypadButton)
            throws
            Exception
    {
        assertSame(numericKeypadButton, numericKeypadButton.mainDiagonalSymmetric());
    }

    @SuppressWarnings("unused")
    @DataPoints("buttonsOnAntiDiagonal")
    public static NumericKeypadButton[] buttonsOnAntiDiagonal = {NumericKeypadButton.getInstance(3),
                                                                 NumericKeypadButton.getInstance(5),
                                                                 NumericKeypadButton.getInstance(7)};

    @Theory
    public void antiDiagonalSymmetric_forButtonsOnAntiDiagonal_expectedReturnsItself(
            @FromDataPoints("buttonsOnAntiDiagonal") NumericKeypadButton numericKeypadButton)
            throws
            Exception
    {
        assertSame(numericKeypadButton, numericKeypadButton.antiDiagonalSymmetric());
    }

    @Test
    public void mainDiagonalSymmetric_forButtonNotOnMainDiagonal_expectedReturnsMainDiagonalSymmetricButton()
            throws
            Exception
    {
        assertEquals(NumericKeypadButton.getInstance(2), NumericKeypadButton.getInstance(4).mainDiagonalSymmetric());
    }

    @Test
    public void antiDiagonalSymmetric_forButtonNotOnAntiDiagonal_expectedReturnsAntiDiagonalSymmetricButton()
            throws
            Exception
    {
        assertEquals(NumericKeypadButton.getInstance(8), NumericKeypadButton.getInstance(4).antiDiagonalSymmetric());
    }

    @Test
    public void mainDiagonalSymmetric_forZeroButton_expectedReturnsNull()
            throws
            Exception
    {
        assertNull(NumericKeypadButton.getInstance(0).mainDiagonalSymmetric());
    }

    @Test
    public void antiDiagonalSymmetric_forZeroButton_expectedReturnsNull()
            throws
            Exception
    {
        assertNull(NumericKeypadButton.getInstance(0).antiDiagonalSymmetric());
    }
}