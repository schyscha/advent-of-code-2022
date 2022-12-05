package aoc22.impl.task2;

import aoc22.impl.AbstractCrateMover;

import java.util.Stack;

/**
 * Advent of Code 2022
 * <p>
 * Day 05
 * <p>
 * Implementation for the solution for the second task.
 *
 * @author Szymon Rozmarynowski
 */
public class CrateMover9001 extends AbstractCrateMover {

    @Override
    protected void move(int amount, int startStackIndex, int endStackIndex) {
        Stack<Character> temp = new Stack<>();

        for (int i = 0; i < amount; i++) {
            temp.add(crateStacks[startStackIndex - 1].pop());
        }
        for (int i = 0; i < amount; i++) {
            crateStacks[endStackIndex - 1].add(temp.pop());
        }
    }
}
