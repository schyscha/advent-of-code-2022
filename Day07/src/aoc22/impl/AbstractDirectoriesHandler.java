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
 * Day 07
 * <p>
 * Common functionalities for both solutions.
 *
 * @author Szymon Rozmarynowski
 */
public abstract class AbstractDirectoriesHandler {

    protected final List<Element> directories;
    private final String PATH = System.getProperty("user.dir") + "\\src\\resources\\";
    private final String FILE_NAME = "input.txt";
    private final String DIRECTORY = "dir";
    private final String COMMAND = "$";
    private final String CHANGE_DIRECTORY = "cd";
    private final String DIRECTORY_UPPER = "..";
    private final String DIRECTORY_MAIN = "/";
    private Element currentElement;

    public AbstractDirectoriesHandler() {
        directories = new ArrayList<>();
        readInput();
    }

    protected void readInput() {
        try (Stream<String> stream = Files.lines(Paths.get(PATH + FILE_NAME))) {
            stream.forEach(this::readInput);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void changeDirectory(String directory) {
        if (directory.equals(DIRECTORY_MAIN)) {
            checkoutMainDirectory();
        } else if (directory.equals(DIRECTORY_UPPER)) {
            checkoutUpperDirectory();
        } else {
            checkoutChildDirectory(directory);
        }
    }

    private void checkoutMainDirectory() {
        if (this.directories.isEmpty()) {
            this.directories.add(new Element(null, "ROOT", false));
        }
        this.currentElement = directories.get(0);
    }

    private void checkoutChildDirectory(String name) {
        for (Element child : currentElement.getChildren()) {
            if (name.equals(child.getName())) {
                this.currentElement = child;
                return;
            }
        }
    }

    private void checkoutUpperDirectory() {
        this.currentElement = this.currentElement.getParent();
    }

    private void addChild(String part1, String name) {
        boolean isFile = !part1.equals(DIRECTORY);
        Element child = new Element(currentElement, name, isFile);
        if (isFile) {
            child.setSize(Integer.parseInt(part1));
        } else {
            this.directories.add(child);
        }
        currentElement.addChild(child);
    }

    private void readInput(String line) {
        String[] parts = line.split(" ");
        if (!parts[0].equals(COMMAND)) {
            addChild(parts[0], parts[1]);
        } else {
            if (parts[1].equals(CHANGE_DIRECTORY)) {
                changeDirectory(parts[2]);
            }
        }
    }

    public abstract void getResult();
}
