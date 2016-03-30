import biuoop.GUI;
import biuoop.DrawSurface;

import java.util.Random;
import java.awt.Color;

/**
 * @author Roey Shefi & Oded Thaller
 * @version 1.0
 * @since 01.03.2016
 */
public class AbstractArtDrawing {
    /**
     * Draw 10 random lines.
     * <p>
     * Circle middle and intersction points
     * <p>
     * @param args null. */
    public static void main(String[] args) {
        AbstractArtDrawing example = new AbstractArtDrawing();
        example.drawRandomLines();
    }

    /**
     * Creates a random line.
     * <p>
     * @return a new random Line.
     */
    public Line generateRandomLine() {
        Random rand = new Random();
        // Making random points.
        int x1 = rand.nextInt(400) + 1;
        int y1 = rand.nextInt(300) + 1;
        int x2 = rand.nextInt(400) + 1;
        int y2 = rand.nextInt(300) + 1;
        return new Line(x1, y1, x2, y2);
    }

    /**
     * Draws the line to the surface in black.
     * <p>
     * @param l line
     * @param d draw surface
     */
    public void drawLines(Line l, DrawSurface d) {
        Point start = l.start();
        Point end = l.end();
        // Getting the values from the line.
        int x1 = (int) start.getX();
        int y1 = (int) start.getY();
        int x2 = (int) end.getX();
        int y2 = (int) end.getY();
        d.setColor(Color.BLACK);
        d.drawLine(x1, y1, x2, y2);
    }

    /**
     * Colors the intersection points of all the lines.
     * <p>
     * @param linesToDraw an array of all the random lines.
     * @param i a counter of the number of random Lines created.
     * @param d The surface to display to.
     */
    public void colorInter(Line[] linesToDraw, int i, DrawSurface d) {
        for (int j = 0; j < i; j++) {
            if (linesToDraw[i].isIntersecting(linesToDraw[j])) {
                // Gets point of intersection.
                Point inter = linesToDraw[i].intersectionWith(linesToDraw[j]);
                d.setColor(Color.RED);
                // Colors.
                d.fillCircle((int) inter.getX(), (int) inter.getY(), 3);
            }
        }
    }

    /**
     * Colors the mid point of a line.
     * <p>
     * @param l A line.
     * @param d The surface to display the point on.
     */
    public void colorMid(Line l, DrawSurface d) {
        Point mid = l.middle();
        d.setColor(Color.BLUE);
        d.fillCircle((int) mid.getX(), (int) mid.getY(), 3);
    }

    /**
     * The working method, calls the methods to complete the task.
     */
    public void drawRandomLines() {
        // Makes the GUI.
        GUI gui = new GUI("Random Lines", 400, 300);
        DrawSurface d = gui.getDrawSurface();
        // Creates list of Lines.
        Line[] linesToDraw = new Line[10];
        for (int i = 0; i < 10; i++) {
            linesToDraw[i] = generateRandomLine();
            drawLines(linesToDraw[i], d);
            colorMid(linesToDraw[i], d);
            colorInter(linesToDraw, i, d);
        }
        gui.show(d);
    }
}