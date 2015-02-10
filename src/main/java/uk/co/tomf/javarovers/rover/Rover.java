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

    private char orientation;

    public Rover(int maxX, int maxY, int currentX, int currentY, char currentOrientation) {
        this.maxX = maxX;
        this.maxY = maxY;

        this.currentX = currentX;
        this.currentY = currentY;
        this.orientation = currentOrientation;
    }

    public void moveForward() {
        int newCoord;
        switch (orientation) {
            case 'E':
                newCoord = currentX + 1;
                testBounds(newCoord, currentY);
                currentX = newCoord;
                break;
            case 'W':
                newCoord = currentX - 1;
                testBounds(newCoord, currentY);
                currentX = newCoord;
                break;
            case 'N':
                newCoord = currentY + 1;
                testBounds(currentX, newCoord);
                currentY = newCoord;
                break;
            case 'S':
                newCoord = currentY - 1;
                testBounds(currentX, newCoord);
                currentY = newCoord;
                break;
        }
    }

    public void changeDirection(String direction) {
        int key = 0;
        if (direction.toLowerCase().equals("l")) {
            key = -1;
        } else if (direction.toLowerCase().equals("r")) {
            key = 1;
        }

        int newIndex = orientationsList.indexOf(orientation) + key;
        // does key overflow?
        if (newIndex == -1) {
            newIndex = 3;
        } else if (newIndex == 4) {
            newIndex = 0;
        }

        // get new pos
        orientation = orientationsList.get(newIndex);
    }

    public String getPosition() {
        return this.currentX + " " + this.currentY + " " + this.orientation;
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
