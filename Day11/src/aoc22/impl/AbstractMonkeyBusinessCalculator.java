package aoc22.impl;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Advent of Code 2022
 * <p>
 * Day 11
 * <p>
 * {@link AbstractMonkey} game observation simulator and their actions counter (common code for both tasks).
 *
 * @author Szymon Rozmarynowski
 */
public abstract class AbstractMonkeyBusinessCalculator {

    protected AbstractMonkey[] monkeys;

    public void play(int rounds) {
        for (int i = 0; i < rounds; i++) {
            for (int monkeyIndex = 0; monkeyIndex < 8; monkeyIndex++) {
                while (monkeys[monkeyIndex].hasItems()) {
                    long currentItem = monkeys[monkeyIndex].getNewWorryLevelForCurrentItem();
                    monkeys[monkeys[monkeyIndex].getNewMonkeyIndexFromTest(currentItem)].addItem(currentItem);
                }
            }
        }
    }

    public void getResult() {
        List<AbstractMonkey> monkeyList = Arrays.asList(monkeys);
        monkeyList.sort(Comparator.comparing(AbstractMonkey::getInspectCounter).reversed());
        System.out.println(monkeyList.get(0).getInspectCounter() * monkeyList.get(1).getInspectCounter());
    }
}
