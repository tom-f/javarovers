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

    private int maxX;
    private int maxY;

    private int currentX;
    private int currentY;

    private int orientation;

    public Rover(int maxX, int maxY, int currentX, int currentY, char currentOrientation) {
        this.maxX = maxX;
        this.maxY = maxY;

        this.currentX = currentX;
        this.currentY = currentY;

        this.orientation = orientationsList.indexOf(currentOrientation);
    }

    public void moveForward() {
        int newCoord;
        switch (orientation) {
            case 1:
                newCoord = currentX + 1;
                testBounds(newCoord, currentY);
                currentX = newCoord;
                break;
            case 3:
                newCoord = currentX - 1;
                testBounds(newCoord, currentY);
                currentX = newCoord;
                break;
            case 0:
                newCoord = currentY + 1;
                testBounds(currentX, newCoord);
                currentY = newCoord;
                break;
            case 2:
                newCoord = currentY - 1;
                testBounds(currentX, newCoord);
                currentY = newCoord;
                break;
        }
    }

    public void changeDirection(String direction) {
        int key = 0;
        if (direction.toLowerCase().equals("l")) {
            key = 3;
        } else if (direction.toLowerCase().equals("r")) {
            key = 1;
        }

        orientation = (orientation + key) % 4;

    }

    public String getPosition() {
        return this.currentX + " " + this.currentY + " " + orientationsList.get(orientation);
    }

    private void testBounds(int newX, int newY) {
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
