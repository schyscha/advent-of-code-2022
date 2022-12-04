package aoc22.impl;

/**
 * Advent of Code 2022
 * <p>
 * Day 04
 * <p>
 * Object representing the section (from both tasks).
 *
 * @author Szymon Rozmarynowski
 */
public class Section {

    private final int start;
    private final int end;

    public Section(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public boolean hasCommonLimit(Section otherSection) {
        return this.start == otherSection.start || this.end == otherSection.end;
    }

    public boolean containsWithoutCommonLimits(Section otherSection) {
        return this.start < otherSection.start && this.end > otherSection.end;
    }

    public boolean isOverlapping(Section otherSection) {
        return this.start <= otherSection.end && this.end >= otherSection.start;
    }
}
