import biuoop.DrawSurface;
import biuoop.GUI;
import biuoop.Sleeper;
import java.awt.Color;

/**
 * @author Roey Shefi & Oded Thaller
 * @version 1.0
 * @since 01.03.2016  */
public class MultipleFramesBouncingBallsAnimation {
    /**
     * Animate multiple bouncing balls in two separate frames.
     * <p>
     * @param args balls sizes. */
    public static void main(String[] args) {
        GUI gui = new GUI("Multiple Frames Bouncing Balls", 650, 650);
        Sleeper sleeper = new Sleeper();
        java.util.Random rand = new java.util.Random();
        int[] sizes = stringToInts(args); // array of balls sizes
        Ball[] balls = new Ball[args.length]; // array of balls to animate

        // fill array with balls, half for the first frame, half for the second
        for (int i = 0; i < sizes.length / 2; i++) {
            balls[i] = new Ball(rand.nextInt(450 - (2 * sizes[i])) + 50 + sizes[i], rand.nextInt(450 - (2 * sizes[i]))
                    + 50 + sizes[i], sizes[i], Color.black);
            balls[i].setVelocity(balls[i].findVelocity(balls[i].getSize()));
            balls[i].setBorder(50, 50, 500, 500);
        }
        for (int i = sizes.length / 2; i < sizes.length; i++) {
            balls[i] = new Ball(rand.nextInt(150 - (2 * sizes[i])) + 450 + sizes[i], rand.nextInt(150 - (2 * sizes[i]))
                    + 450 + sizes[i], sizes[i], Color.black);
            balls[i].setVelocity(balls[i].findVelocity(balls[i].getSize()));
            balls[i].setBorder(450, 450, 600, 600);
        }

        // animation loop
        while (true) {
            DrawSurface d = gui.getDrawSurface();
            // draw first yellow frame
            d.setColor(Color.gray);
            d.drawRectangle(50, 50, 450, 450);
            // draw second gray frame
            d.setColor(Color.yellow);
            d.drawRectangle(450, 450, 150, 150);
            d.setColor(Color.black);
            // move balls
            for (int i = 0; i < sizes.length; i++) {
                balls[i].isHitBorder();
                balls[i].moveOneStep();
                balls[i].drawOn(d);
            }
            gui.show(d);
            sleeper.sleepFor(50);  // wait for 50 milliseconds.
        }
    }

    /**
     * convert array of strings to ints.
     * <p>
     * @param numbers balls sizes.
     * @return array of ints. */
    public static int[] stringToInts(String[] numbers) {
        int[] arr = new int[numbers.length];
        for (int j = 0; j < numbers.length; j++) {
            arr[j] = Integer.parseInt(numbers[j]);
        }
        return arr;
    }
}



