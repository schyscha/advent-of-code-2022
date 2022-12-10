package aoc22.impl.task1;

import aoc22.impl.Direction;
import aoc22.impl.Knot;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

import static java.lang.Math.abs;

/**
 * Advent of Code 2022
 * <p>
 * Day 09
 * <p>
 * Implementation for the solution for the first task.
 *
 * @author Szymon Rozmarynowski
 */
public class VisitedPointsCounter {

    private final String PATH = System.getProperty("user.dir") + "\\src\\resources\\";
    private final String FILE_NAME = "input.txt";
    private final Knot head;
    private final Knot tail;
    private final Set<Knot> visitedPositions;

    public VisitedPointsCounter() {
        head = new Knot(0, 0);
        tail = new Knot(0, 0);
        visitedPositions = new HashSet<>();
        visitedPositions.add(new Knot(0, 0));
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
        String[] parts = line.split(" ");
        for (int i = 0; i < Integer.parseInt(parts[1]); i++) {
            head.move(Direction.getDirection(parts[0]));
            moveTail();
        }
    }

    private void moveTail() {
        if (abs(tail.getX() - head.getX()) <= 1 && abs(tail.getY() - head.getY()) <= 1) {
            return;
        }
        if (head.getY() - tail.getY() > 0) {
            if (head.getX() < tail.getX()) {
                tail.move(Direction.LEFT_UPPER);
            } else if (head.getX() == tail.getX()) {
                tail.move(Direction.UP);
            } else {
                tail.move(Direction.RIGHT_UPPER);
            }
        } else if (head.getY() - tail.getY() < 0) {
            if (head.getX() < tail.getX()) {
                tail.move(Direction.LEFT_BOTTOM);
            } else if (head.getX() == tail.getX()) {
                tail.move(Direction.DOWN);
            } else {
                tail.move(Direction.RIGHT_BOTTOM);
            }
        } else {
            tail.move(head.getX() < tail.getX() ? Direction.LEFT : Direction.RIGHT);
        }
        visitedPositions.add(new Knot(tail.getX(), tail.getY()));
    }

    public void getResult() {
        System.out.println(visitedPositions.size());
    }
}
