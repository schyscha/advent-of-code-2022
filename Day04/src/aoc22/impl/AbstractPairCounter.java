package aoc22.impl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

/**
 * Advent of Code 2022
 * <p>
 * Day 04
 * <p>
 * Common functionalities for both solutions.
 *
 * @author Szymon Rozmarynowski
 */
public abstract class AbstractPairCounter {

    private final String PATH = System.getProperty("user.dir") + "\\src\\resources\\";
    private final String FILE_NAME = "input.txt";
    protected int counter = 0;

    public AbstractPairCounter() {
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
        String[] sections = line.split(",");
        String[] section1 = sections[0].split("-");
        String[] section2 = sections[1].split("-");
        checkSections(new Section(Integer.parseInt(section1[0]), Integer.parseInt(section1[1])),
                new Section(Integer.parseInt(section2[0]), Integer.parseInt(section2[1])));
    }

    protected abstract void checkSections(Section section1, Section section2);

    public void getResult() {
        System.out.println(counter);
    }
}
