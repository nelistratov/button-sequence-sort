package ru.mathnet.sequence.sort;

import java.util.List;
import java.util.function.Predicate;

/**
 * @author Nikolay Elistratov
 */
public class AntiDiagonalSymmetric implements Predicate<List<NumericKeypadButton>>
{
    @Override
    public boolean test(List<NumericKeypadButton> numericKeypadButtons)
    {
        return numericKeypadButtons.stream().allMatch(x -> numericKeypadButtons.contains(x.antiDiagonalSymmetric()));
    }
}
