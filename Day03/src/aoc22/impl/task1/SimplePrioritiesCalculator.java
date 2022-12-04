package aoc22.impl.task1;

import aoc22.impl.AbstractPrioritiesCalculator;

/**
 * Advent of Code 2022
 * <p>
 * Day 03
 * <p>
 * Implementation for the solution for the first task.
 *
 * @author Szymon Rozmarynowski
 */
public class SimplePrioritiesCalculator extends AbstractPrioritiesCalculator {

    public SimplePrioritiesCalculator() {
        readInput();
    }

    @Override
    protected void readInput(String line) {
        final int mid = line.length() / 2;
        char commonCharacter = findCommonCharacter(line.substring(0, mid).toCharArray(), line.substring(mid).toCharArray());
        sum += getPriority(commonCharacter);
    }

    private char findCommonCharacter(char[] part1, char[] part2) {
        for (char charFromFirstPart : part1) {
            for (char charFromSecondPart : part2) {
                if (charFromFirstPart == charFromSecondPart) {
                    return charFromFirstPart;
                }
            }
        }
        return '0';
    }


}
