package aoc22.impl.task1;

import aoc22.impl.AbstractCrateMover;

/**
 * Advent of Code 2022
 * <p>
 * Day 05
 * <p>
 * Implementation for the solution for the first task.
 *
 * @author Szymon Rozmarynowski
 */
public class CrateMover9000 extends AbstractCrateMover {

    @Override
    protected void move(int amount, int startStackIndex, int endStackIndex) {
        for (int i = 0; i < amount; i++) {
            crateStacks[endStackIndex - 1].add(crateStacks[startStackIndex - 1].pop());
        }
    }
}
