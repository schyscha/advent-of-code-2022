package aoc22.impl.task2;


/**
 * Advent of Code 2022
 * <p>
 * Day 02
 * <p>
 * Enum with wanted result (second column) Rock Paper Scissors in the second task.
 *
 * @author Szymon Rozmarynowski
 */
public enum WantedResult {
    WIN, LOSE, DRAW;

    public static WantedResult getWantedResult(char code) {
        if (code == 'X') {
            return LOSE;
        }
        if (code == 'Y') {
            return DRAW;
        }
        return WIN;
    }
}
