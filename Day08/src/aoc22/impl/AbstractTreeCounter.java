package aoc22.impl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

/**
 * Advent of Code 2022
 * <p>
 * Day 08
 * <p>
 * Common functionalities for both solutions.
 *
 * @author Szymon Rozmarynowski
 */
public abstract class AbstractTreeCounter {

    protected final int SIZE = 99;
    protected final int[][] trees = new int[SIZE][SIZE];
    private final String PATH = System.getProperty("user.dir") + "\\src\\resources\\";
    private final String FILE_NAME = "input.txt";
    private int lineCounter = 0;

    public AbstractTreeCounter() {
        readInput();
    }

    protected void readInput() {
        try (Stream<String> stream = Files.lines(Paths.get(PATH + FILE_NAME))) {
            stream.forEach(this::readInput);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void readInput(String line) {
        for (int x = 0; x < line.length(); x++) {
            trees[lineCounter][x] = Character.getNumericValue(line.charAt(x));
        }
        lineCounter++;
    }

    protected abstract void getResult();
}
