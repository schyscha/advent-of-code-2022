package aoc22.impl;

/**
 * Advent of Code 2022
 * <p>
 * Day 02
 * <p>
 * Enum with choice for the Rock Paper Scissors game
 *
 * @author Szymon Rozmarynowski
 */
public enum Choice {

    PAPER, ROCK, SCISSORS;


    public static Choice getChoice(char code) {
        if (code == 'A' || code == 'X') {
            return ROCK;
        }
        if (code == 'B' || code == 'Y') {
            return PAPER;
        }
        return SCISSORS;
    }
}
