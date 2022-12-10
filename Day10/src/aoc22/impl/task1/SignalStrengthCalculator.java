package aoc22.impl.task1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

/**
 * Advent of Code 2022
 * <p>
 * Day 10
 * <p>
 * Implementation for the solution for the first task.
 *
 * @author Szymon Rozmarynowski
 */
public class SignalStrengthCalculator {

    private final String PATH = System.getProperty("user.dir") + "\\src\\resources\\";
    private final String FILE_NAME = "input.txt";
    private final String ADDX = "addx";
    private int x = 1;
    private int sum = 0;
    private int cycle = 1;
    private int multiplyFactor = 0;

    public SignalStrengthCalculator() {
        readInput();
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
            updateCyclesAndSum();
            x += Integer.parseInt(parts[1]);
        }
        updateCyclesAndSum();
    }

    private void updateCyclesAndSum() {
        cycle++;
        if (cycle == 20 + 40 * multiplyFactor) {
            multiplyFactor++;
            sum += cycle * x;
        }
    }

    public void getResult() {
        System.out.println(sum);
    }
}
