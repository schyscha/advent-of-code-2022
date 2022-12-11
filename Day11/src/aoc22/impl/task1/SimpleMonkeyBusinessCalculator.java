package aoc22.impl.task1;

import aoc22.impl.AbstractMonkeyBusinessCalculator;

import java.util.Arrays;
import java.util.List;

/**
 * Advent of Code 2022
 * <p>
 * Day 11
 * <p>
 * {@link SimpleMonkey} game observation simulator and their actions counter (first task)
 *
 * @author Szymon Rozmarynowski
 */
public class SimpleMonkeyBusinessCalculator extends AbstractMonkeyBusinessCalculator {

    public SimpleMonkeyBusinessCalculator() {
        monkeys = new SimpleMonkey[8];
        monkeys[0] = new SimpleMonkey(Arrays.asList(72L, 64L, 51L, 57L, 93L, 97L, 68L), x -> x * 19, 17, 4, 7);
        monkeys[1] = new SimpleMonkey(List.of(62L), x -> x * 11, 3, 3, 2);
        monkeys[2] = new SimpleMonkey(Arrays.asList(57L, 94L, 69L, 79L, 72L), x -> x + 6, 19, 0, 4);
        monkeys[3] = new SimpleMonkey(Arrays.asList(80L, 64L, 92L, 93L, 64L, 56L), x -> x + 5, 7, 2, 0);
        monkeys[4] = new SimpleMonkey(Arrays.asList(70L, 88L, 95L, 99L, 78L, 72L, 65L, 94L), x -> x + 7, 2, 7, 5);
        monkeys[5] = new SimpleMonkey(Arrays.asList(57L, 95L, 81L, 61L), x -> x * x, 5, 1, 6);
        monkeys[6] = new SimpleMonkey(Arrays.asList(79L, 99L), x -> x + 2, 11, 3, 1);
        monkeys[7] = new SimpleMonkey(Arrays.asList(68L, 98L, 62L), x -> x + 3, 13, 5, 6);
    }
}
