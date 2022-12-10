package aoc22.impl.task2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/**
 * Advent of Code 2022
 * <p>
 * Day 10
 * <p>
 * Implementation for the solution for the second task.
 *
 * @author Szymon Rozmarynowski
 */
public class CRTHandler {

    private final String PATH = System.getProperty("user.dir") + "\\src\\resources\\";
    private final String FILE_NAME = "input.txt";
    private final String ADDX = "addx";
    private final List<Character> line;
    private int x = 1;

    public CRTHandler() {
        line = new ArrayList<>();
    }

    private void readInput() {
        try (Stream<String> stream = Files.lines(Paths.get(PATH + FILE_NAME))) {
            stream.forEach(this::readInput);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void readInput(String line) {
        String[] parts = line.split(" ");
        if (parts[0].equals(ADDX)) {
            cycleStep();
            cycleStep();
            x += Integer.parseInt(parts[1]);
        } else {
            cycleStep();
        }
    }

    private void cycleStep() {
        drawPixel();
        checkLineSize();
    }

    private void drawPixel() {
        line.add((line.size() >= x - 1 && line.size() <= x + 1) ? '#' : '.');
    }

    private void checkLineSize() {
        if (line.size() == 40) {
            System.out.println(line);
            line.clear();
        }
    }

    public void getResult() {
        readInput();
    }
}
