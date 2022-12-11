package aoc22.impl.task2;

import aoc22.impl.AbstractMonkey;

import java.util.List;
import java.util.function.Function;

/**
 * Advent of Code 2022
 * <p>
 * Day 11
 * <p>
 * An object representing a monkey for the first task - with modulo and without dividing by 3
 *
 * @author Szymon Rozmarynowski
 */
public class StrongMonkey extends AbstractMonkey {

    public StrongMonkey(List<Long> items, Function<Long, Long> updateWorryLevel, int testDivider, int monkeyIndexIfTestIsTrue, int monkeyIndexIfTestIsFalse) {
        super(items, updateWorryLevel, testDivider, monkeyIndexIfTestIsTrue, monkeyIndexIfTestIsFalse);
    }

    @Override
    protected long calculateNewWorryLevel() {
        return updateWorryLevel.apply(items.get(0)) % factor;
    }
}
