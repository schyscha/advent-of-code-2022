package aoc22.impl.task2;

import aoc22.impl.AbstractTreeCounter;

/**
 * Advent of Code 2022
 * <p>
 * Day 08
 * <p>
 * Implementation for the solution for the second task.
 *
 * @author Szymon Rozmarynowski
 */
public class ScenicScoreCalculator extends AbstractTreeCounter {

    private int masScenicScore = 0;

    @Override
    public void getResult() {
        findHighestScenicScore();
        System.out.println(masScenicScore);
    }

    private void findHighestScenicScore() {
        int score;
        int treeHeight;
        for (int y = 0; y < SIZE; y++) {
            for (int x = 0; x < SIZE; x++) {
                treeHeight = trees[y][x];
                score = lookUp(x, y, treeHeight) * lookRight(x, y, treeHeight) * lookDown(x, y, treeHeight) * lookLeft(x, y, treeHeight);
                masScenicScore = Math.max(score, masScenicScore);
            }
        }
    }

    private int lookUp(int x, int y, int treeHeight) {
        int counter = 0;
        if (y != 0) {
            for (int i = y - 1; i >= 0; i--) {
                counter++;
                if (trees[i][x] >= treeHeight) {
                    break;
                }
            }
        }
        return counter;
    }

    private int lookRight(int x, int y, int treeHeight) {
        int counter = 0;
        if (x != SIZE - 1) {
            for (int i = x + 1; i < SIZE; i++) {
                counter++;
                if (trees[y][i] >= treeHeight) {
                    break;
                }
            }
        }
        return counter;
    }

    private int lookDown(int x, int y, int treeHeight) {
        int counter = 0;
        if (y != SIZE - 1) {
            for (int i = y + 1; i < SIZE; i++) {
                counter++;
                if (trees[i][x] >= treeHeight) {
                    break;
                }
            }
        }
        return counter;
    }

    private int lookLeft(int x, int y, int treeHeight) {
        int counter = 0;
        if (x != 0) {
            for (int i = x - 1; i >= 0; i--) {
                counter++;
                if (trees[y][i] >= treeHeight) {
                    break;
                }
            }
        }
        return counter;
    }
}
