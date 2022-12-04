package aoc22.impl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

/**
 * Advent of Code 2022
 * <p>
 * Day 03
 * <p>
 * Common functionalities for both solutions.
 *
 * @author Szymon Rozmarynowski
 */
public abstract class AbstractPrioritiesCalculator {
    protected final int LOWERCASE_PRIORITY_FACTOR = 1 - 'a';
    protected final int UPPERCASE_PRIORITY_FACTOR = 27 - 'A';
    private final String PATH = System.getProperty("user.dir") + "\\src\\resources\\";
    private final String FILE_NAME = "input.txt";
    protected int sum = 0;

    public void getResult() {
        System.out.println(sum);
    }

    protected void readInput() {
        try (Stream<String> stream = Files.lines(Paths.get(PATH + FILE_NAME))) {
            stream.forEach(this::readInput);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    protected abstract void readInput(String line);

    protected int getPriority(char character) {
        return character + (Character.isUpperCase(character) ? UPPERCASE_PRIORITY_FACTOR : LOWERCASE_PRIORITY_FACTOR);
    }
}
