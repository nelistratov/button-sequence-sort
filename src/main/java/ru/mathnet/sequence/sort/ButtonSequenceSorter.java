package ru.mathnet.sequence.sort;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author Nikolay Elistratov
 */
public class ButtonSequenceSorter
{

    private static final String HELP_OPTION_KEY = "help";
    private static final String SHUFFLE_OPTION_KEY = "shuffle";
    private static final String STATISTICS_OPTION_KEY = "statistics";
    private static final String PRIORITY_OPTION_KEY = "priority";

    public static List<List<NumericKeypadButton>> sort(List<List<NumericKeypadButton>> decimalDigitSequences)
    {
        return decimalDigitSequences.stream().sorted((x, y) -> ButtonSequencePriority.value(y) -
                ButtonSequencePriority.value(x)).collect(Collectors.toList());
    }

    public static void main(String[] args)
    {
        if (isOptionEnabled(args, HELP_OPTION_KEY)) {
            System.out.println("Options:\n" +
                                       "\t-" + HELP_OPTION_KEY + "\t\t\t\tprints this message\n" +
                                       "\t-" + SHUFFLE_OPTION_KEY + "\t\t\tshuffles sequences within each group\n" +
                                       "\t-" + STATISTICS_OPTION_KEY +
                                       "\t\tprints statistics for groups with same priority\n" +
                                       "\t-" + PRIORITY_OPTION_KEY + "\t\tprints priority for each sequence");
            return;
        }
        List<List<NumericKeypadButton>> buttonSequences = sort(getButtonSequences(isOptionEnabled(args,
                                                                                                  SHUFFLE_OPTION_KEY)));
        if (isOptionEnabled(args, PRIORITY_OPTION_KEY)) buttonSequences.stream().
                forEach(x -> System.out.println(x + " (" + ButtonSequencePriority.value(x) + ")"));
        else buttonSequences.stream().forEach(System.out::println);
        if (isOptionEnabled(args, STATISTICS_OPTION_KEY)) {
            System.out.println("\nStatistics:");
            buttonSequences.stream().map(ButtonSequencePriority::value).distinct().sorted((x, y) -> y - x).forEach(
                    p -> System.out.println(ButtonSequencePriority.description(p) + " (priority=" + p + "): " +
                                                    buttonSequences.stream().map(ButtonSequencePriority::value).filter(
                                                            x -> Objects.equals(x, p)).count()));
        }
    }

    private static boolean isOptionEnabled(String[] args, String optionKey)
    {
        for (String arg : args)
            if (arg.equalsIgnoreCase("-" + optionKey)) return true;
        return false;
    }

    private static List<List<NumericKeypadButton>> getButtonSequences(boolean randomize)
    {
        List<Integer> integers = getIntegers(randomize);
        List<List<NumericKeypadButton>> buttonSequences = new ArrayList<>();
        for (Integer x : integers) {
            buttonSequences.add(Arrays.<NumericKeypadButton>asList(NumericKeypadButton.getInstance(x / 1000),
                                                                   NumericKeypadButton.getInstance((x % 1000) / 100),
                                                                   NumericKeypadButton.getInstance((x % 100) / 10),
                                                                   NumericKeypadButton.getInstance(x % 10)));
        }
        return buttonSequences;
    }

    private static List<Integer> getIntegers(boolean randomize)
    {
        if (randomize) {
            Set<Integer> generated = new HashSet<>();
            List<Integer> result = new ArrayList<>();
            Random random = new Random();
            while (result.size() < 10000) {
                Integer next = random.nextInt(10000);
                if (generated.add(next)) result.add(next);
            }
            return result;
        }
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < 10000; i++)
            result.add(i);
        return result;
    }
}
