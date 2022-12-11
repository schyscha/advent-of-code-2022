package aoc22.impl.task2;

import aoc22.impl.AbstractMonkeyBusinessCalculator;

import java.util.Arrays;
import java.util.List;

/**
 * Advent of Code 2022
 * <p>
 * Day 11
 * <p>
 * {@link StrongMonkey} game observation simulator and their actions counter (second task)
 *
 * @author Szymon Rozmarynowski
 */
public class StrongMonkeyBusinessCalculator extends AbstractMonkeyBusinessCalculator {

    public StrongMonkeyBusinessCalculator() {
        monkeys = new StrongMonkey[8];
        monkeys[0] = new StrongMonkey(Arrays.asList(72L, 64L, 51L, 57L, 93L, 97L, 68L), x -> x * 19, 17, 4, 7);
        monkeys[1] = new StrongMonkey(List.of(62L), x -> x * 11, 3, 3, 2);
        monkeys[2] = new StrongMonkey(Arrays.asList(57L, 94L, 69L, 79L, 72L), x -> x + 6, 19, 0, 4);
        monkeys[3] = new StrongMonkey(Arrays.asList(80L, 64L, 92L, 93L, 64L, 56L), x -> x + 5, 7, 2, 0);
        monkeys[4] = new StrongMonkey(Arrays.asList(70L, 88L, 95L, 99L, 78L, 72L, 65L, 94L), x -> x + 7, 2, 7, 5);
        monkeys[5] = new StrongMonkey(Arrays.asList(57L, 95L, 81L, 61L), x -> x * x, 5, 1, 6);
        monkeys[6] = new StrongMonkey(Arrays.asList(79L, 99L), x -> x + 2, 11, 3, 1);
        monkeys[7] = new StrongMonkey(Arrays.asList(68L, 98L, 62L), x -> x + 3, 13, 5, 6);
        for (int i = 0; i < 8; i++) {
            monkeys[i].setFactor(17 * 3 * 19 * 7 * 2 * 5 * 11 * 13);
        }
    }
}
