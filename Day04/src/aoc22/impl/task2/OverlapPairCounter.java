package aoc22.impl.task2;

import aoc22.impl.AbstractPairCounter;
import aoc22.impl.Section;

/**
 * Advent of Code 2022
 * <p>
 * Day 04
 * <p>
 * Implementation for the solution for the second task.
 *
 * @author Szymon Rozmarynowski
 */
public class OverlapPairCounter extends AbstractPairCounter {

    @Override
    protected void checkSections(Section section1, Section section2) {
        if (section1.isOverlapping(section2) || section2.isOverlapping(section1)) {
            counter++;
        }
    }


}
