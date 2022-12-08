package aoc22.impl.task1;

import aoc22.impl.AbstractTreeCounter;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Advent of Code 2022
 * <p>
 * Day 08
 * <p>
 * Implementation for the solution for the first task.
 *
 * @author Szymon Rozmarynowski
 */
public class VisibleTreeCounter extends AbstractTreeCounter {

    private int visibleTreeCounter = 4 * SIZE - 4;

    @Override
    public void getResult() {
        setVisibilities();
        System.out.println(visibleTreeCounter);
    }

    private void setVisibilities() {
        for (int y = 1; y < SIZE - 1; y++) {
            for (int x = 1; x < SIZE - 1; x++) {
                checkTreeVisibility(x, y);
            }
        }
    }

    private void checkTreeVisibility(int x, int y) {
        boolean isVisible = false;
        List<Distance> distancesToEdges = getDistancesToEdges(x, y);
        int treeHeight = trees[y][x];
        for (Distance distance : distancesToEdges) {
            if (isVisible) {
                break;
            }
            switch (distance.direction()) {
                case UP -> {
                    for (int i = y - 1; i >= 0; i--) {
                        if (trees[i][x] >= treeHeight) {
                            break;
                        }
                        if (i == 0) {
                            isVisible = true;
                            break;
                        }
                    }
                }
                case RIGHT -> {
                    for (int i = x + 1; i < SIZE; i++) {
                        if (trees[y][i] >= treeHeight) {
                            break;
                        }
                        if (i == SIZE - 1) {
                            isVisible = true;
                            break;
                        }
                    }
                }
                case DOWN -> {
                    for (int i = y + 1; i < SIZE; i++) {
                        if (trees[i][x] >= treeHeight) {
                            break;
                        }
                        if (i == SIZE - 1) {
                            isVisible = true;
                            break;
                        }
                    }
                }
                case LEFT -> {
                    for (int i = x - 1; i >= 0; i--) {
                        if (trees[y][i] >= treeHeight) {
                            break;
                        }
                        if (i == 0) {
                            isVisible = true;
                            break;
                        }
                    }
                }
            }
        }
        if (isVisible) {
            visibleTreeCounter++;
        }
    }

    private List<Distance> getDistancesToEdges(int x, int y) {
        List<Distance> distances = new ArrayList<>();
        distances.add(new Distance(Direction.LEFT, x));
        distances.add(new Distance(Direction.UP, y));
        distances.add(new Distance(Direction.RIGHT, SIZE - 1 - x));
        distances.add(new Distance(Direction.DOWN, SIZE - 1 - y));

        distances.sort(Comparator.comparing(Distance::length));
        return distances;
    }


}
