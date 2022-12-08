package aoc22.impl.task2;

import aoc22.impl.AbstractDirectoriesHandler;
import aoc22.impl.Element;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Advent of Code 2022
 * <p>
 * Day 07
 * <p>
 * Implementation for the solution for the second task.
 *
 * @author Szymon Rozmarynowski
 */
public class DirectoriesDeleteHandler extends AbstractDirectoriesHandler {

    private final int FILESYSTEM_SPACE = 70000000;
    private final int UNUSED_SPACE = 30000000;
    private final List<Element> enoughBigDirectories;

    public DirectoriesDeleteHandler() {
        super();
        this.enoughBigDirectories = new ArrayList<>();
    }

    private void findEnoughBigDirectories() {
        int unusedSize = FILESYSTEM_SPACE - directories.get(0).getSize();
        for (Element directory : directories) {
            if (directory.getSize() + unusedSize >= UNUSED_SPACE) {
                enoughBigDirectories.add(directory);
            }
        }
        enoughBigDirectories.sort(Comparator.comparing(Element::getSize));

    }

    @Override
    public void getResult() {
        findEnoughBigDirectories();
        System.out.println(enoughBigDirectories.get(0).getSize());
    }
}
