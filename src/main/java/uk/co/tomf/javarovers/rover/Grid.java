package uk.co.tomf.javarovers.rover;

/**
 * Created by tfawssett on 17/02/15.
 */
public class Grid {

    private int maxX;
    private int maxY;

    public Grid(int maxX, int maxY) {
        this.maxX = maxX;
        this.maxY = maxY;
    }

    public void testBounds(int newX, int newY) {
        if (newX < 0 || newX > maxX) {
            throw new IllegalArgumentException(
                    String.format("X Co-ordinate %d out of bounds", newX)
            );
        }
        if (newY < 0 || newY > maxY) {
            throw new IllegalArgumentException(
                    String.format("Y Co-ordinate %d out of bounds", newY)
            );
        }

    }

}
