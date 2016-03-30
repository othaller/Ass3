import com.intellij.openapi.graph.impl.view.YLabelImpl;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Roey Shefi & Oded Thaller
 * @version 1.0
 * @since 28.03.2016
 */
public class Rectangle {
    double width;
    double height;
    private Point leftCorner;
    private Point lowLeft;
    private Point lowRight;
    private Point upperRight;
    private Line horizontalUp;
    private Line horizontalDown;
    private Line verticalLeft;
    private Line verticalRight;

    // Create a new rectangle with location and width/height.
    public Rectangle(Point upperLeft, double width, double height) {
        this.leftCorner = upperLeft;
        this.width = width;
        this.height = height;
        makePoints();
        makeEdges();
    }

    // Return a (possibly empty) List of intersection points
    // with the specified line.
    public java.util.List intersectionPoints(Line line) {
        List intrPoints = new ArrayList();
        intrPoints.add(horizontalDown.intersectionWith(line));
        intrPoints.add(horizontalUp.intersectionWith(line));
        intrPoints.add(verticalRight.intersectionWith(line));
        intrPoints.add(verticalLeft.intersectionWith(line));
        return intrPoints;
    }

    public Point findPoints(Point upperLeft, double x) {
        if (x == width) {
            return upperLeft.getHorizontalPoint(x);
        } else {
            return upperLeft.getVerticalPoint(x);
        }
    }

    public void makePoints() {
        this.lowLeft = findPoints(this.leftCorner, this.height);
        this.lowRight = findPoints(lowLeft, this.width);
        this.upperRight = findPoints(this.leftCorner, this.width);
    }

    public void makeEdges() {
        this.horizontalUp = new Line(this.upperRight, this.leftCorner);
        this.horizontalDown = new Line(this.lowLeft, this.lowRight);
        this.verticalRight = new Line(this.leftCorner, this.lowLeft);
        this.verticalLeft = new Line(this.upperRight, this.lowRight);
    }

    // Return the width and height of the rectangle
    public double getWidth() {
        return this.width;
    }

    public double getHeight() {
        return this.height;
    }

    // Returns the upper-left point of the rectangle.
    public Point getUpperLeft() {
        return this.leftCorner;
    }
}
