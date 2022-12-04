package aoc22.impl.task1;

import aoc22.impl.AbstractPairCounter;
import aoc22.impl.Section;

/**
 * Advent of Code 2022
 * <p>
 * Day 04
 * <p>
 * Implementation for the solution for the first task.
 *
 * @author Szymon Rozmarynowski
 */
public class CommonPairCounter extends AbstractPairCounter {

    @Override
    protected void checkSections(Section section1, Section section2) {
        if (section1.hasCommonLimit(section2) || section1.containsWithoutCommonLimits(section2) ||
                section2.containsWithoutCommonLimits(section1)) {
            counter++;
        }
    }


}
