package aoc22.impl.task2;

import aoc22.impl.AbstractPrioritiesCalculator;

import java.lang.reflect.Array;
import java.util.*;

/**
 * Advent of Code 2022
 * <p>
 * Day 03
 * <p>
 * Implementation for the solution for the second task.
 *
 * @author Szymon Rozmarynowski
 */
public class AdvancedPrioritiesCalculator extends AbstractPrioritiesCalculator {

    private final List<char[]> rucksacksGroup;
    private final Set<Character> usedCharacters;
    private int lineCounter = 0;

    public AdvancedPrioritiesCalculator() {
        rucksacksGroup = new ArrayList<>();
        usedCharacters = new HashSet<>();
        readInput();
    }

    @Override
    protected void readInput(String line) {
        rucksacksGroup.add(line.toCharArray());
        lineCounter++;
        if (lineCounter == 3) {
            rucksacksGroup.sort(Comparator.comparingInt(Array::getLength));
            sum += getPriority(getCommonCharacter());
            rucksacksGroup.clear();
            usedCharacters.clear();
            lineCounter = 0;
        }
    }

    private char getCommonCharacter() {
        String thirdRucksack = new String(rucksacksGroup.get(2));
        for (int i = 0; i < rucksacksGroup.get(0).length; i++) {
            if (!usedCharacters.contains(rucksacksGroup.get(0)[i])) {
                for (int j = 0; j < rucksacksGroup.get(1).length; j++) {
                    if (rucksacksGroup.get(0)[i] == rucksacksGroup.get(1)[j]) {
                        if (thirdRucksack.indexOf(rucksacksGroup.get(0)[i]) >= 0) {
                            return rucksacksGroup.get(0)[i];
                        } else {
                            usedCharacters.add(rucksacksGroup.get(0)[i]);
                        }
                    }
                }
                usedCharacters.add(rucksacksGroup.get(0)[i]);
            }
        }
        return '0';
    }
}
