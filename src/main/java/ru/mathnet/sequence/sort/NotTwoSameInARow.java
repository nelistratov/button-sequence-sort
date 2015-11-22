package ru.mathnet.sequence.sort;

import java.util.Iterator;
import java.util.List;
import java.util.function.Predicate;

/**
 * @author Nikolay Elistratov
 */
public class NotTwoSameInARow implements Predicate<List<NumericKeypadButton>>
{
    @Override
    public boolean test(List<NumericKeypadButton> numericKeypadButtons)
    {
        if (numericKeypadButtons.size() < 2)
            return true;
        Iterator<NumericKeypadButton> iterator = numericKeypadButtons.iterator();
        NumericKeypadButton previous = iterator.next();
        while (iterator.hasNext()) {
            NumericKeypadButton next = iterator.next();
            if (next == previous)
                return false;
            previous = next;
        }
        return true;
    }
}
