/**
 * @author Roey Shefi & Oded Thaller
 * @version 1.0
 * @since 3/19/2016  */
public class Border {

    private int top;
    private int left;
    private int bottom;
    private int right;

    /**
     * Instantiate Border.
     * <p>
     * @param top top.
     * @param left left.
     * @param bottom bottom.
     * @param right right. */
    public Border(int top, int left, int bottom, int right) {
        this.top = top;
        this.left = left;
        this.bottom = bottom;
        this.right = right;
    }

    /**
     * get top y.
     * <p>
     * @return top y location. */
    public int getTop() {
        return this.top;
    }

    /**
     * get left x.
     * <p>
     * @return Left x location. */
    public int getLeft() {
        return this.left;
    }

    /**
     * get bottom y.
     * <p>
     * @return Bottom y location. */
    public int getBottom() {
        return this.bottom;
    }

    /**
     * get right x.
     * <p>
     * @return right location. */
    public int getRight() {
        return this.right;
    }
}

