package aoc22.impl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

/**
 * Advent of Code 2022
 * <p>
 * Day 01
 * <p>
 * Implementation for the solutions for both tasks:
 * <ul>
 *     <li>{@link #getOneHighestCalories()} is for the first task</li>
 *     <li>{@link #getSumOfThreeHighestCalories()} is for the second task</li>
 * </ul>
 *
 * @author Szymon Rozmarynowski
 */
public class CaloriesCounter {

    private final String PATH = System.getProperty("user.dir") + "\\src\\resources\\";
    private final String FILE_NAME = "input.txt";

    private final List<Integer> caloriesList = new ArrayList<>();
    private int currentCalories = 0;

    public CaloriesCounter() {
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
        if (line.isEmpty()) {
            caloriesList.add(currentCalories);
            currentCalories = 0;
        } else {
            currentCalories += Integer.parseInt(line);
        }
    }

    public void getOneHighestCalories() {
        System.out.println(Collections.max(caloriesList));
    }

    public void getSumOfThreeHighestCalories() {
        caloriesList.sort(Collections.reverseOrder());
        System.out.println(caloriesList.get(0) + caloriesList.get(1) + caloriesList.get(2));
    }
}
