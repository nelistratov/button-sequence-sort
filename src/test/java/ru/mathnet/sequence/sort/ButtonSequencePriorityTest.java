package ru.mathnet.sequence.sort;

import org.junit.contrib.theories.DataPoint;
import org.junit.contrib.theories.FromDataPoints;
import org.junit.contrib.theories.Theories;
import org.junit.contrib.theories.Theory;
import org.junit.runner.RunWith;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertTrue;

@RunWith(Theories.class)
public class ButtonSequencePriorityTest
{
    @SuppressWarnings("unused")
    @DataPoint("SYM-!2-1DIAG")
    public static List<NumericKeypadButton> diagonalSymmetricNotTowSameInARowAtLeastOneOnDiagonal = Arrays.asList(
            NumericKeypadButton.getInstance(1), NumericKeypadButton.getInstance(9), NumericKeypadButton.getInstance(4),
            NumericKeypadButton.getInstance(8));
    @SuppressWarnings("unused")
    @DataPoint({"SYM-!2", "!(SYM-!2-1DIAG)"})
    public static List<NumericKeypadButton> diagonalSymmetricNotTowSameInARow = Arrays.asList(
            NumericKeypadButton.getInstance(2), NumericKeypadButton.getInstance(4), NumericKeypadButton.getInstance(2),
            NumericKeypadButton.getInstance(4));
    @SuppressWarnings("unused")
    @DataPoint({"SYM-1DIAG", "!(SYM-!2-1DIAG)", "!(SYM-!2)"})
    public static List<NumericKeypadButton> diagonalSymmetricAtLeastOneOnDiagonal = Arrays.asList(
            NumericKeypadButton.getInstance(1), NumericKeypadButton.getInstance(1), NumericKeypadButton.getInstance(9),
            NumericKeypadButton.getInstance(1));
    @SuppressWarnings("unused")
    @DataPoint({"SYM", "!(SYM-!2-1DIAG)", "!(SYM-!2)", "!(SYM-1DIAG)"})
    public static List<NumericKeypadButton> diagonalSymmetric = Arrays.asList(NumericKeypadButton.getInstance(2),
                                                                              NumericKeypadButton.getInstance(2),
                                                                              NumericKeypadButton.getInstance(4),
                                                                              NumericKeypadButton.getInstance(4));
    @SuppressWarnings("unused")
    @DataPoint({"!2-1DIAG", "!(SYM-!2-1DIAG)", "!(SYM-!2)", "!(SYM-1DIAG)", "!SYM"})
    public static List<NumericKeypadButton> notTowSameInARowAtLeastOneOnDiagonal = Arrays.asList(
            NumericKeypadButton.getInstance(1), NumericKeypadButton.getInstance(2), NumericKeypadButton.getInstance(3),
            NumericKeypadButton.getInstance(4));
    @SuppressWarnings("unused")
    @DataPoint({"!2", "!(SYM-!2-1DIAG)", "!(SYM-!2)", "!(SYM-1DIAG)", "!SYM", "!(!2-1DIAG)"})
    public static List<NumericKeypadButton> notTowSameInARow = Arrays.asList(NumericKeypadButton.getInstance(2),
                                                                             NumericKeypadButton.getInstance(0),
                                                                             NumericKeypadButton.getInstance(2),
                                                                             NumericKeypadButton.getInstance(0));
    @SuppressWarnings("unused")
    @DataPoint({"1DIAG", "!(SYM-!2-1DIAG)", "!(SYM-!2)", "!(SYM-1DIAG)", "!SYM", "!(!2-1DIAG)", "!(!2)"})
    public static List<NumericKeypadButton> oneOnDiag = Arrays.asList(NumericKeypadButton.getInstance(1),
                                                                      NumericKeypadButton.getInstance(1),
                                                                      NumericKeypadButton.getInstance(2),
                                                                      NumericKeypadButton.getInstance(2));
    @SuppressWarnings("unused")
    @DataPoint({"!(SYM-!2-1DIAG)", "!(SYM-!2)", "!(SYM-1DIAG)", "!SYM", "!(!2-1DIAG)", "!(!2)", "!(1DIAG)"})
    public static List<NumericKeypadButton> other = Arrays.asList(NumericKeypadButton.getInstance(2),
                                                                  NumericKeypadButton.getInstance(2),
                                                                  NumericKeypadButton.getInstance(2),
                                                                  NumericKeypadButton.getInstance(2));

    @Theory
    public void apply_diagonalSymmetricNotTowSameInARowAtLeastOneOnDiagonal_higherThanForNot(
            @FromDataPoints("SYM-!2-1DIAG") List<NumericKeypadButton> meeting,
            @FromDataPoints("!(SYM-!2-1DIAG)") List<NumericKeypadButton> notMeeting)
            throws
            Exception
    {
        assertTrue(ButtonSequencePriority.value(meeting) > ButtonSequencePriority.value(notMeeting));
    }

    @Theory
    public void apply_diagonalSymmetricNotTowSameInARow_higherThanForNot(
            @FromDataPoints("SYM-!2") List<NumericKeypadButton> meeting,
            @FromDataPoints("!(SYM-!2)") List<NumericKeypadButton> notMeeting)
            throws
            Exception
    {
        assertTrue(ButtonSequencePriority.value(meeting) > ButtonSequencePriority.value(notMeeting));
    }

    @Theory
    public void apply_diagonalSymmetricAtLeastOneOnDiagonal_higherThanForNot(
            @FromDataPoints("SYM-1DIAG") List<NumericKeypadButton> meeting,
            @FromDataPoints("!(SYM-1DIAG)") List<NumericKeypadButton> notMeeting)
            throws
            Exception
    {
        assertTrue(ButtonSequencePriority.value(meeting) > ButtonSequencePriority.value(notMeeting));
    }

    @Theory
    public void apply_diagonalSymmetric_higherThanForNot(@FromDataPoints("SYM") List<NumericKeypadButton> meeting,
                                                         @FromDataPoints("!SYM") List<NumericKeypadButton> notMeeting)
            throws
            Exception
    {
        assertTrue(ButtonSequencePriority.value(meeting) > ButtonSequencePriority.value(notMeeting));
    }

    @Theory
    public void apply_notTowSameInARowAtLeastOneOnDiagonal_higherThanForNot(
            @FromDataPoints("!2-1DIAG") List<NumericKeypadButton> meeting,
            @FromDataPoints("!(!2-1DIAG)") List<NumericKeypadButton> notMeeting)
            throws
            Exception
    {
        assertTrue(ButtonSequencePriority.value(meeting) > ButtonSequencePriority.value(notMeeting));
    }

    @Theory
    public void apply_notTowSameInARow_higherThanForNot(@FromDataPoints("!2") List<NumericKeypadButton> meeting,
                                                        @FromDataPoints("!(!2)") List<NumericKeypadButton> notMeeting)
            throws
            Exception
    {
        assertTrue(ButtonSequencePriority.value(meeting) > ButtonSequencePriority.value(notMeeting));
    }

    @Theory
    public void apply_oneOnDiag_higherThanForNot(@FromDataPoints("1DIAG") List<NumericKeypadButton> meeting,
                                                 @FromDataPoints("!(1DIAG)") List<NumericKeypadButton> notMeeting)
            throws
            Exception
    {
        assertTrue(ButtonSequencePriority.value(meeting) > ButtonSequencePriority.value(notMeeting));
    }
}