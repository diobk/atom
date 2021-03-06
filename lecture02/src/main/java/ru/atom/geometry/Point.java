package ru.atom.geometry;

/**
 * Template class for
 */
public class Point implements Collider  /* super class and interfaces here if necessary */ {
    // fields
    // and methods
    private int x;
    private int y;

    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * @param o - other object to check equality with
     * @return true if two points are equal and not null.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        // cast from Object to Point
        Point point = (Point) o;
        return x == point.x && y == point.y;

        // your code here
        //throw new UnsupportedOperationException();
    }

    @Override
    public boolean isColliding(Collider other) {
        if (other instanceof Point)
            return this.equals(other);
        throw new UnsupportedOperationException();
    }
}
