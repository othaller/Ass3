import java.util.List;

/**
 * @author Roey Shefi & Oded Thaller
 * @version 1.0
 * @since 01.03.2016
 */

public class Line {

    private Point start;
    private Point end;

    // constructors

    /**
     * Instantiate Line.
     * <p>
     *
     * @param start start point.
     * @param end   end point.
     */
    public Line(Point start, Point end) {
        this.start = start;
        this.end = end;
    }


    /**
     * Instantiate Line.
     * <p>
     *
     * @param x1 start point x location.
     * @param y1 start point y location.
     * @param x2 end point x location.
     * @param y2 end point y location.
     */
    public Line(double x1, double y1, double x2, double y2) {
        this.start = new Point(x1, y1);
        this.end = new Point(x2, y2);
    }

    // accessors

    /**
     * Get line's length.
     * <p>
     *
     * @return The line's length.
     */
    public double length() {
        return start.distance(end);
    }


    /**
     * Get line's middle point.
     * <p>
     *
     * @return middle point.
     */
    public Point middle() {
        return new Point((this.start.getX() + this.end.getX()) / 2, (this.start.getY() + this.end.getY()) / 2);
    }

    /**
     * Get line's start point.
     * <p>
     *
     * @return start point.
     */
    public Point start() {
        return this.start;
    }

    /**
     * Get line's end point.
     * <p>
     *
     * @return end point.
     */
    public Point end() {
        return this.end;
    }

    // methods

    /**
     * Calculate line's slope.
     * <p>
     *
     * @return line's slope.
     */
    public double slope() {
        return (this.start.getY() - this.end.getY()) / (this.start.getX() - this.end.getX());
    }

    /**
     * Checks if line intersects with another line.
     * <p>
     *
     * @param other another line.
     * @return true if lines intersect, false otherwise.
     */
    public boolean isIntersecting(Line other) {
        return this.intersectionWith(other) != null;
    }

    /**
     * finds two lines' intersection point.
     * <p>
     *
     * @param other another line.
     * @return lines' intersection Point, null otherwise.
     */
    public Point intersectionWith(Line other) {
        double m1 = this.slope();
        double m2 = other.slope();

        // if lines are parallel
        if (m1 == m2) {
            return null;
        }

        // find intercepts with y-axis
        double b1 = this.start.getY() - m1 * this.start.getX();
        double b2 = other.start.getY() - m2 * other.start.getX();

        double x = (b2 - b1) / (m1 - m2);
        double y = m1 * x + b1;

        // Makes sure that the point is on both lines.
        if ((x > this.start.getX() && x < this.end.getX()) || (x < this.start.getX() && x > this.end.getX())) {
            if ((x > other.start.getX() && x < other.end.getX()) || (x < other.start.getX() && x > other.end.getX())) {
                return new Point(x, y);
            }
        }
        return null;
    }

    public Point closestIntersectionToStartOfLine(Rectangle rect) {
        List IntrPoints = rect.intersectionPoints(this);
        int j = 0;
        double max = 0;
        for (int i = 0; i < IntrPoints.size(); i++) {
            double temp = this.start.distance((Point) IntrPoints.get(i));
            if (temp > max) {
                max = temp;
                j = i;
            }
        }
        return (Point) IntrPoints.get(j);
    }


    /**
     * Checks if two lines are equal.
     * <p>
     *
     * @param other another line.
     * @return true if lines are equal, false otherwise.
     */
    public boolean equals(Line other) {
        return this.start.equals(other.start) && this.end.equals(other.end);
    }
}