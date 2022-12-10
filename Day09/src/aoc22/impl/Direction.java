package aoc22.impl;

/**
 * Advent of Code 2022
 * <p>
 * Day 09
 * <p>
 * Knot movement direction
 *
 * @author Szymon Rozmarynowski
 */
public enum Direction {
    UP, RIGHT, DOWN, LEFT, LEFT_UPPER, RIGHT_UPPER, LEFT_BOTTOM, RIGHT_BOTTOM;


    public static Direction getDirection(String code) {
        if (code.equals("U")) {
            return UP;
        }
        if (code.equals("R")) {
            return RIGHT;
        }
        if (code.equals("D")) {
            return DOWN;
        }
        if (code.equals("L")) {
            return LEFT;
        }
        if (code.equals("LU")) {
            return LEFT_UPPER;
        }
        if (code.equals("RU")) {
            return RIGHT_UPPER;
        }
        if (code.equals("LD")) {
            return LEFT_BOTTOM;
        }
        if (code.equals("RD")) {
            return RIGHT_BOTTOM;
        }

        return UP;
    }
}
