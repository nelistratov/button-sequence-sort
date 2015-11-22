package ru.mathnet.sequence.sort;

import java.util.List;
import java.util.function.Predicate;

/**
 * @author Nikolay Elistratov
 */
public class DiagonalSymmetric implements Predicate<List<NumericKeypadButton>>
{
    private static final MainDiagonalSymmetric mainDiagonalSymmetric = new MainDiagonalSymmetric();
    private static final AntiDiagonalSymmetric antiDiagonalSymmetric = new AntiDiagonalSymmetric();

    @Override
    public boolean test(List<NumericKeypadButton> numericKeypadButtons)
    {
        return mainDiagonalSymmetric.test(numericKeypadButtons) || antiDiagonalSymmetric.test(numericKeypadButtons);
    }
}
