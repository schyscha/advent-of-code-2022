package aoc22.impl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

/**
 * Advent of Code 2022
 * <p>
 * Day 02
 * <p>
 * Abstract class with common code for both solutions.
 *
 * @author Szymon Rozmarynowski
 */
public abstract class AbstractRockPaperScissorsSimulator {

    protected final int WIN_POINTS = 6;
    protected final int DRAW_POINTS = 3;
    protected final int LOSE_POINTS = 0;
    private final String PATH = System.getProperty("user.dir") + "\\src\\resources\\";
    private final String FILE_NAME = "input.txt";
    protected int points = 0;

    public AbstractRockPaperScissorsSimulator() {
        readInput();
    }

    protected abstract void readInput(String line);

    protected abstract int getRoundResult(Choice myChoice, Choice opponentChoice);

    private void readInput() {
        try (Stream<String> stream = Files.lines(Paths.get(PATH + FILE_NAME))) {
            stream.forEach(this::readInput);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    protected int getChoicePoints(Choice myChoice) {
        if (myChoice == Choice.ROCK) {
            return 1;
        } else if (myChoice == Choice.PAPER) {
            return 2;
        } else {
            return 3;
        }
    }

    public void getResult() {
        System.out.println(points);
    }
}
