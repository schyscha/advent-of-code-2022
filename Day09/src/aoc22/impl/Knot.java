package aoc22.impl;

import java.util.Objects;

/**
 * Advent of Code 2022
 * <p>
 * Day 09
 * <p>
 * An object representing a knot. Contains its coordinates and allows action (movement).
 *
 * @author Szymon Rozmarynowski
 */
public class Knot {

    private int x;
    private int y;

    public Knot(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void move(Direction direction) {
        switch (direction) {
            case UP -> moveUp();
            case RIGHT -> moveRight();
            case DOWN -> moveDown();
            case LEFT -> moveLeft();
            case LEFT_UPPER -> {
                moveLeft();
                moveUp();
            }
            case RIGHT_UPPER -> {
                moveRight();
                moveUp();
            }
            case LEFT_BOTTOM -> {
                moveLeft();
                moveDown();
            }
            case RIGHT_BOTTOM -> {
                moveRight();
                moveDown();
            }
        }
    }

    private void moveUp() {
        this.y++;
    }

    private void moveDown() {
        this.y--;
    }

    private void moveRight() {
        this.x++;
    }

    private void moveLeft() {
        this.x--;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Knot knot = (Knot) o;
        return x == knot.x && y == knot.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
