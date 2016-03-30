import biuoop.DrawSurface;
import biuoop.GUI;
import biuoop.Sleeper;

/**
 * @author Roey Shefi & Oded Thaller
 * @version 1.0
 * @since 01.03.2016  */
public class BouncingBallAnimation {
    /**
     * Animate a single bouncing ball.
     * <p>
     * @param args null. */
    public static void main(String[] args) {

        GUI gui = new GUI("Bouncing Ball Animation", 200, 200);
        java.util.Random rand = new java.util.Random();
        Sleeper sleeper = new Sleeper();

        // ball instantiation
        Ball ball = new Ball(rand.nextInt(138) + 31, rand.nextInt(138) + 31, 30, java.awt.Color.BLACK);
        ball.setVelocity(ball.findVelocity(ball.getSize()));
        ball.setBorder(0, 0, 200, 200);

        // animation loop
        while (true) {
            ball.isHitBorder();
            ball.moveOneStep();
            DrawSurface d = gui.getDrawSurface();
            ball.drawOn(d);
            gui.show(d);
            sleeper.sleepFor(50);  // wait for 50 milliseconds.
        }
    }
}