package ru.mathnet.sequence.sort;

import java.util.List;

/**
 * @author Nikolay Elistratov
 */
public class ButtonSequencePriority
{
    private static final DiagonalSymmetric diagonalSymmetric = new DiagonalSymmetric();
    private static final NotTwoSameInARow notTwoSameInARow = new NotTwoSameInARow();
    private static final AtLeastOneOnDiagonal atLeastOneOnDiagonal = new AtLeastOneOnDiagonal();

    public static int value(List<NumericKeypadButton> numericKeypadButtons)
    {
        if (diagonalSymmetric.test(numericKeypadButtons)) {
            if (notTwoSameInARow.test(numericKeypadButtons)) {
                if (atLeastOneOnDiagonal.test(numericKeypadButtons)) return 100;
                return 90;
            }
            if (atLeastOneOnDiagonal.test(numericKeypadButtons))
                return 80;
            return 70;
        }
        if (notTwoSameInARow.test(numericKeypadButtons)) {
            if (atLeastOneOnDiagonal.test(numericKeypadButtons)) return 60;
            return 50;
        }
        if (atLeastOneOnDiagonal.test(numericKeypadButtons)) return 40;
        return 0;
    }

    public static String description(Integer priority)
    {
        if (priority == null)
            return "";
        switch (priority) {
            case 100: return "diagonal symmetric, not two same in a row, at least one on a diagonal";
            case 90: return "diagonal symmetric, not two same in a row";
            case 80: return "diagonal symmetric, at least one on a diagonal";
            case 70: return "diagonal symmetric";
            case 60: return "not two same in a row, at least one on diagonal";
            case 50: return "not two same in a row";
            case 40: return "at least one on diagonal";
            default: return "others";
        }
    }
}
