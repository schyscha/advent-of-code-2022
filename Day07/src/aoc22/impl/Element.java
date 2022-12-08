package aoc22.impl;

import java.util.ArrayList;

/**
 * Advent of Code 2022
 * <p>
 * Day 07
 * <p>
 * Class with the structure for every element of filesystem (for both folder and file)
 *
 * @author Szymon Rozmarynowski
 */
public class Element {

    private final Element parent;
    private final String name;
    private final ArrayList<Element> children;
    private final boolean isFile;
    private int size;

    public Element(Element parent, String name, boolean isFile) {
        this.children = new ArrayList<>();
        this.parent = parent;
        this.name = name;
        this.isFile = isFile;
    }

    public void addChild(Element element) {
        this.children.add(element);
    }

    public Element getParent() {
        return parent;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Element> getChildren() {
        return children;
    }

    public int getSize() {
        if (this.isFile) {
            return size;
        } else {
            int sum = 0;
            for (Element element : children) {
                sum += element.getSize();
            }
            return sum;
        }
    }

    public void setSize(int size) {
        this.size = size;
    }
}
