import biuoop.DrawSurface;
import biuoop.GUI;
import biuoop.Sleeper;
/**
 * @author Roey Shefi & Oded Thaller
 * @version 1.0
 * @since 01.03.2016  */
public class MultipleBouncingBallsAnimation {
    /**
     * Animate multiple bouncing balls.
     * <p>
     * @param args balls sizes. */
    public static void main(String[] args) {
        GUI gui = new GUI("Multiple Bouncing Balls", 400, 400);
        Sleeper sleeper = new Sleeper();
        java.util.Random rand = new java.util.Random();
        int[] sizes = stringToInts(args); // array of balls sizes
        Ball[] balls = new Ball[args.length]; // array of balls to animate

        // fill array with balls
        for (int i = 0; i < sizes.length; i++) {
            balls[i] = new Ball(rand.nextInt(400 - (2 * sizes[i])) + sizes[i], rand.nextInt(400 - (2 * sizes[i]))
                    + sizes[i], sizes[i], java.awt.Color.BLACK);
            balls[i].setVelocity(balls[i].findVelocity(balls[i].getSize()));
            balls[i].setBorder(0, 0, 400, 400);
        }

        // animation loop
        while (true) {
            DrawSurface d = gui.getDrawSurface();
            // apply movement to balls
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
