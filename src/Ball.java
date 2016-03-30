import biuoop.DrawSurface;
import java.awt.Color;

/**
 * @author Roey Shefi & Oded Thaller
 * @version 1.0
 * @since 01.03.2016  */


public class Ball {

    private Point center;
    private int radius;
    private java.awt.Color color;
    private Velocity velocity;
    private Border border;

    // constructors

    /**
     * Instantiate Ball.
     * <p>
     * @param center center point.
     * @param r radius.
     * @param color color */
    public Ball(Point center, int r, java.awt.Color color) {
        this.center = center;
        this.radius = r;
        this.color = color;
    }

    /**
     * Instantiate Ball.
     * <p>
     * @param x center point x location.
     * @param y center point y location.
     * @param r radius.
     * @param color color */
    public Ball(int x, int y, int r, java.awt.Color color) {
        this.center = new Point(x, y);
        this.radius = r;
        this.color = color;
    }

    // accessors
    /**
     * Get ball's center x location.
     * <p>
     * @return center x location. */
    public double getX() {
        return this.center.getX();
    }

    /**
     * Get ball's center y location.
     * <p>
     * @return center y location. */
    public double getY() {
        return this.center.getY();
    }

    /**
     * Get ball's size.
     * <p>
     * @return radius. */
    public int getSize() {
        return this.radius;
    }

    /**
     * Get ball's color.
     * <p>
     * @return color. */
    public Color getColor() {
        return this.color;
    }

    /**
     * Get ball's Border.
     * <p>
     * @return Border. */
    public Border getBorder() {
        return this.border;
    }

    /**
     * Get ball's Velocity.
     * <p>
     * @return Velocity. */
    public Velocity getVelocity() {
        return this.velocity;
    }

   // methods

    /**
     * Set ball's Velocity.
     * <p>
     * @param v Velocity. */
    public void setVelocity(Velocity v) {
        this.velocity = new Velocity(v.getDx(), v.getDy());
    }

    /**
     * Draw ball on GUI.
     * <p>
     * @param surface draw surface. */
    public void drawOn(DrawSurface surface) {
        surface.fillCircle((int) this.center.getX(), (int) this.center.getY(), this.radius);
        surface.setColor(this.color);
    }

    /**
     * Set ball's Velocity.
     * <p>
     * @param dx Angle.
     * @param dy speed.  */
    public void setVelocity(double dx, double dy) {
        this.velocity = new Velocity(dx, dy);
    }

    /**
     * find Velocity based on ball size.
     * <p>
     * @param size  ball size.
     * @return new Velocity. */
    public Velocity findVelocity(int size) {
        if (size <= 10) {
            return new Velocity(10, 10);
        } else if (size > 10 && size <= 25) {
            return new Velocity(5, 5);
        } else if (size > 25 && size <= 50) {
            return new Velocity(3, 3);
        } else {
            return new Velocity(1, 1);
        }
    }

    /**
     * Set ball's Border.
     * <p>
     * @param left left border.
     * @param right right border.
     * @param top top border.
     * @param bottom bottom border. */
    public void setBorder(int top, int left, int bottom, int right) {
        this.border = new Border(top, left, bottom, right);
    }

    /**
     * Move ball one step on GUI.
     * <p> */
    public void moveOneStep() {
        // apply step according to velocity
        this.center = this.getVelocity().applyToPoint(this.center);
    }

    /**
     * Checks if ball has reached the border
     * <p>
     * if yes, change direction by 180 degrees. */
    public void isHitBorder() {
        // if ball hits left or right border, change angle by 180 degrees
        if (this.getX() <= this.border.getLeft() + this.getSize() || this.getX() >= this.border.getRight()
                - this.getSize()) {
            this.setVelocity(this.velocity.getDx() * -1, this.velocity.getDy());
        }
        // if ball hits top or bottom border, change speed by 180 degrees
        if (this.getY() <= this.border.getTop() + this.getSize() || this.getY() >= this.border
                .getBottom() - this.getSize()) {
            this.setVelocity(this.velocity.getDx(), this.velocity.getDy() * -1);
        }
    }
}