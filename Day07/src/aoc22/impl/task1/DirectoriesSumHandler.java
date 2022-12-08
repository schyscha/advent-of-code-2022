package aoc22.impl.task1;

import aoc22.impl.AbstractDirectoriesHandler;
import aoc22.impl.Element;

/**
 * Advent of Code 2022
 * <p>
 * Day 07
 * <p>
 * Implementation for the solution for the first task.
 *
 * @author Szymon Rozmarynowski
 */
public class DirectoriesSumHandler extends AbstractDirectoriesHandler {

    private int sum = 0;
    
    private void sum() {
        for (Element directory : directories) {
            if (directory.getSize() < 100000) {
                sum += directory.getSize();
            }
        }
    }

    @Override
    public void getResult() {
        sum();
        System.out.println(sum);
    }
}
