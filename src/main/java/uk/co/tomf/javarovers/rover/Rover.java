package uk.co.tomf.javarovers.rover;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by tfawssett on 09/02/15.
 *
 * NASA Rover that knows how to move itself when told.
 */
public class Rover {

    public static final List<Character> orientationsList =
            Collections.unmodifiableList(Arrays.asList('N', 'E', 'S', 'W'));

    private int currentX;
    private int currentY;

    private int orientation;

    public Rover(int currentX, int currentY, char currentOrientation) {
        this.currentX = currentX;
        this.currentY = currentY;

        this.orientation = orientationsList.indexOf(currentOrientation);
    }

    public String getPosition() {
        return this.currentX + " " + this.currentY + " " + orientationsList.get(orientation);
    }

    public int getCurrentX() {
        return currentX;
    }

    public void setCurrentX(int currentX) {
        this.currentX = currentX;
    }

    public int getOrientation() {
        return orientation;
    }

    public void setOrientation(int orientation) {
        this.orientation = orientation;
    }

    public int getCurrentY() {
        return currentY;
    }

    public void setCurrentY(int currentY) {
        this.currentY = currentY;
    }
}
