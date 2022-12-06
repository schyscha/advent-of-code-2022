package aoc22.impl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/**
 * Advent of Code 2022
 * <p>
 * Day 06
 * <p>
 * Implementation for the solution for both tasks
 *
 * @author Szymon Rozmarynowski
 */
public class MarkerDetector {

    private final String PATH = System.getProperty("user.dir") + "\\src\\resources\\";
    private final String FILE_NAME = "input.txt";
    private final int size;
    private int counter = 0;

    /**
     * @param size Number of distinct characters in the marker
     */
    public MarkerDetector(int size) {
        this.size = size;
        detectMarker();
    }


    protected void detectMarker() {
        try (Stream<String> stream = Files.lines(Paths.get(PATH + FILE_NAME))) {
            stream.forEach(this::detectMarker);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void detectMarker(String line) {
        List<Character> characters = new ArrayList<>();
        for (char character : line.toCharArray()) {
            if (characters.size() == this.size) {
                return;
            }
            if (characters.contains(character)) {
                characters = characters.subList(characters.indexOf(character) + 1, characters.size());
            }
            characters.add(character);
            counter++;
        }
    }

    public void getResult() {
        System.out.println(counter);
    }


}
