package aoc22.impl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Stack;
import java.util.stream.Stream;

/**
 * Advent of Code 2022
 * <p>
 * Day 05
 * <p>
 * Common functionalities for both solutions.
 *
 * @author Szymon Rozmarynowski
 */
public abstract class AbstractCrateMover {
    protected final Stack<Character>[] crateStacks = new Stack[9];
    private final String PATH = System.getProperty("user.dir") + "\\src\\resources\\";
    private final String FILE_NAME = "input.txt";
    private int lineCounter = 0;

    public AbstractCrateMover() {
        for (int i = 0; i < crateStacks.length; i++) {
            crateStacks[i] = new Stack<>();
        }
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
        if (lineCounter < 8) {
            saveCrates(line);
        }
        if (lineCounter > 9) {
            String[] commands = line.split(" ");
            move(Integer.parseInt(commands[1]), Integer.parseInt(commands[3]), Integer.parseInt(commands[5]));
        }
        lineCounter++;
    }

    private void saveCrates(String input) {
        int currentStack = 0;
        for (int i = 1; i < input.length(); i += 4) {
            if (input.charAt(i) != ' ') {
                crateStacks[currentStack].add(0, input.charAt(i));
            }
            currentStack++;
        }
    }

    protected abstract void move(int amount, int startStackIndex, int endStackIndex);

    public void getResult() {
        for (Stack<Character> stack : crateStacks) {
            System.out.print(stack.peek());
        }
    }
}
