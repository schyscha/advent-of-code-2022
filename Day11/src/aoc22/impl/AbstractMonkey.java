package aoc22.impl;

import java.util.LinkedList;
import java.util.List;
import java.util.function.Function;

/**
 * Advent of Code 2022
 * <p>
 * Day 11
 * <p>
 * An object representing a monkey with its information and actions.
 *
 * @author Szymon Rozmarynowski
 */
public abstract class AbstractMonkey {
    protected final List<Long> items;
    protected final Function<Long, Long> updateWorryLevel;
    private final int testDivider;
    private final int monkeyIndexIfTestIsTrue;
    private final int monkeyIndexIfTestIsFalse;
    protected int factor;
    private long inspectCounter = 0;

    public AbstractMonkey(List<Long> items, Function<Long, Long> updateWorryLevel, int testDivider, int monkeyIndexIfTestIsTrue, int monkeyIndexIfTestIsFalse) {
        this.items = new LinkedList<>(items);
        this.updateWorryLevel = updateWorryLevel;
        this.testDivider = testDivider;
        this.monkeyIndexIfTestIsTrue = monkeyIndexIfTestIsTrue;
        this.monkeyIndexIfTestIsFalse = monkeyIndexIfTestIsFalse;
    }

    public void setFactor(int factor) {
        this.factor = factor;
    }

    public long getNewWorryLevelForCurrentItem() {
        long newWorryLevel = calculateNewWorryLevel();
        items.remove(0);
        inspectCounter++;
        return newWorryLevel;
    }

    protected abstract long calculateNewWorryLevel();

    public int getNewMonkeyIndexFromTest(long worryLevel) {
        return worryLevel % testDivider == 0 ? monkeyIndexIfTestIsTrue : monkeyIndexIfTestIsFalse;
    }

    public boolean hasItems() {
        return !items.isEmpty();
    }

    public long getInspectCounter() {
        return inspectCounter;
    }

    public void addItem(long item) {
        items.add(item);
    }
}
