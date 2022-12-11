package aoc22.exec;

import aoc22.impl.task2.StrongMonkeyBusinessCalculator;

/**
 * Advent of Code 2022
 * <p>
 * Day 11
 * <p>
 * Execution of the solution for the second task
 *
 * @author Szymon Rozmarynowski
 */
public class Task2 {

    public static void main(String[] args) {
        StrongMonkeyBusinessCalculator strongMonkeyBusinessCalculator = new StrongMonkeyBusinessCalculator();
        strongMonkeyBusinessCalculator.play(10000);
        strongMonkeyBusinessCalculator.getResult();
    }
}
