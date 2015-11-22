package ru.mathnet.sequence.sort;

/**
 * @author Nikolay Elistratov
 */
public final class NumericKeypadButton
{
    private static final NumericKeypadButton[] buttons = new NumericKeypadButton[10];
    private final int value;

    static {
        for (int i = 0; i < 10; i++)
            buttons[i] = new NumericKeypadButton(i);
    }

    private NumericKeypadButton(int value)
    {
        this.value = value;
    }

    public int getValue()
    {
        return value;
    }

    public static NumericKeypadButton getInstance(int i)
    {
        return buttons[i];
    }

    public boolean isOnDiagonal()
    {
        return isOnMainDiagonal() || isOnAntiDiagonal();
    }

    public boolean isOnMainDiagonal()
    {
        return keypadSquareColumn() == keypadSquareRow();
    }

    public boolean isOnAntiDiagonal()
    {
        return 2 - keypadSquareColumn() == keypadSquareRow();
    }

    public NumericKeypadButton mainDiagonalSymmetric()
    {
        for (NumericKeypadButton button : buttons) {
            if (button.keypadSquareColumn() == keypadSquareRow() && button.keypadSquareRow() == keypadSquareColumn())
                return button;
        }
        return null;
    }

    public NumericKeypadButton antiDiagonalSymmetric()
    {
        for (NumericKeypadButton button : buttons) {
            if (2 - button.keypadSquareColumn() == keypadSquareRow() && button.keypadSquareRow() == 2 - keypadSquareColumn())
                return button;
        }
        return null;
    }

    private int keypadSquareRow()
    {
        return (value - 1) / 3;
    }

    private int keypadSquareColumn()
    {
        return (value - 1) % 3;
    }

    @Override
    public String toString()
    {
        return "" + value;
    }
}
