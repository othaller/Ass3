import a.c.f.a.P;

/**
 * @author Roey Shefi & Oded Thaller
 * @version 1.0
 * @since 01.03.2016
 */

public class Point {

    private double x;
    private double y;

    /**
     * Instantiate point.
     * <p>
     *
     * @param x - point x.
     * @param y - point y.
     */
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * distance -- return the distance of this point to the other point.
     * <p>
     *
     * @param other - the point to be compared to.
     * @return - the distance.
     */
    public double distance(Point other) {
        return Math.sqrt(Math.pow(this.x - other.getX(), 2) + Math.pow(this.y - other.getY(), 2));
    }

    /**
     * equals - returns true is the points are equal, false otherwise.
     * <p>
     *
     * @param other - the point to be compared to
     * @return - if they are the same.
     */
    public boolean equals(Point other) {
        return this.x == other.getX() && this.y == other.getY();
    }

    /**
     *
     * @param
     * @param width e
     * @return e
     */
    public Point getHorizontalPoint(double width) {
        return (new Point(this.getX() + width,
                this.getY()));
    }

    /**
     *
     * @param
     * @param height e
     * @return e
     */
    public Point getVerticalPoint(double height) {
        return (new Point(this.getX(),
                this.getY() - height));
    }

    /**
     * For coding style.
     * <p>
     *
     * @return - 0.
     */
    public int hashCode() {
        return 0;
    }

    /**
     * Return the x and y values of this point.
     * <p>
     *
     * @return - x or y as asked.
     */
    public double getX() {
        return x;
    }

    /**
     * Return the x and y values of this point.
     * <p>
     *
     * @return - x or y as asked.
     */
    public double getY() {
        return y;
    }
}