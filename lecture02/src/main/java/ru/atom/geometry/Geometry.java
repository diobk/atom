package ru.atom.geometry;

/**
 *  ^ Y
 *  |
 *  |
 *  |
 *  |          X
 *  .---------->
 */

public final class Geometry implements Collider{

    private int x1;
    private int y1;
    private int x2;
    private int y2;

    public int getX1() {
        return x1;
    }
    public int getY1() {
        return y1;
    }
    public int getX2() {
        return x2;
    }
    public int getY2() {
        return y2;
    }

    public Geometry(int x1, int y1, int x2, int y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }

    /**
     * Bar is a rectangle, which borders are parallel to coordinate axis
     * Like selection bar in desktop, this bar is defined by two opposite corners
     * Bar is not oriented
     * (It is not relevant, which opposite corners you choose to define bar)
     * @return new Bar
     */
    public static Collider createBar(int firstCornerX, int firstCornerY, int secondCornerX, int secondCornerY) {
        return new Geometry(firstCornerX,firstCornerY, secondCornerX, secondCornerY);
        //throw new UnsupportedOperationException();
    }
    /**
     * 2D point
     * @return new Point
     */
    public static Collider createPoint(int x, int y) {
        return new Point(x,y);
        //throw new UnsupportedOperationException();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;

        if (obj instanceof Point)
        {
            Point point = (Point) obj;
            if (point.getX() >= getX1() && point.getX() <= getX2())
                if (point.getY() >= getY1() && point.getY() <= getY2())
                    return true;
        }
        if (obj instanceof Geometry)
        {
            Geometry geometry = (Geometry) obj;
            boolean xIntersect = false;
            boolean yIntersect = false;

            if (!(Math.min(getX1(), getX2()) > Math.max(geometry.getX1(), geometry.getX2()) || Math.max(getX1(), getX2()) < Math.min(geometry.getX1(), geometry.getX2())))
                xIntersect = true;
            if (!(Math.min(getY1(), getY2()) > Math.max(geometry.getY1(), geometry.getY2()) || Math.max(getY1(), getY2()) < Math.min(geometry.getY1(), geometry.getY2())))
                yIntersect = true;
            return xIntersect && yIntersect;
        }
        return false;
    }

    @Override
    public boolean isColliding(Collider other) {
        if (other instanceof Geometry)
            return equals(other);
        else if (other instanceof Point)
            return equals(other);
        throw new UnsupportedOperationException();
    }
}
