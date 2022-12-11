package aoc22.exec;


import aoc22.impl.task1.SimpleMonkeyBusinessCalculator;

/**
 * Advent of Code 2022
 * <p>
 * Day 11
 * <p>
 * Execution of the solution for the first task
 *
 * @author Szymon Rozmarynowski
 */
public class Task1 {

    public static void main(String[] args) {
        SimpleMonkeyBusinessCalculator simpleMonkeyBusinessCalculator = new SimpleMonkeyBusinessCalculator();
        simpleMonkeyBusinessCalculator.play(20);
        simpleMonkeyBusinessCalculator.getResult();
    }
}
