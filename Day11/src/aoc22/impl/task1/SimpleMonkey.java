package aoc22.impl.task1;

import aoc22.impl.AbstractMonkey;

import java.util.List;
import java.util.function.Function;

/**
 * Advent of Code 2022
 * <p>
 * Day 11
 * <p>
 * An object representing a monkey for the first task - without modulo and with dividing by 3
 *
 * @author Szymon Rozmarynowski
 */
public class SimpleMonkey extends AbstractMonkey {

    public SimpleMonkey(List<Long> items, Function<Long, Long> updateWorryLevel, int testDivider, int monkeyIndexIfTestIsTrue, int monkeyIndexIfTestIsFalse) {
        super(items, updateWorryLevel, testDivider, monkeyIndexIfTestIsTrue, monkeyIndexIfTestIsFalse);
    }

    @Override
    protected long calculateNewWorryLevel() {
        return updateWorryLevel.apply(items.get(0)) / 3;
    }
}
