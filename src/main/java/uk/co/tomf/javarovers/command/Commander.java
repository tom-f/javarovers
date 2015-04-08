package uk.co.tomf.javarovers.command;

import uk.co.tomf.javarovers.command.enums.Command;
import uk.co.tomf.javarovers.rover.Grid;
import uk.co.tomf.javarovers.rover.Rover;

/**
 * Created by tfawssett on 09/02/15.
 *
 * A rover's brain
 */
public class Commander {

    private Grid plateau;

    public Commander(Grid plateau) {
        this.plateau = plateau;
    }

    public Rover applyCommands(Rover rover, CommandList commandList) {

        for (Command command : commandList) {
            rover = applyCommand(rover, command);
            draw();
        }

        return rover;
    }

    private Rover applyCommand(Rover rover, Command command) {
        switch (command) {
            case M:
                rover = moveForward(rover);
                break;
            case L:
                rover = changeDirection(Command.L.toString(), rover);
                break;
            case R:
                rover = changeDirection(Command.R.toString(), rover);
                break;
            default:
                throw new IllegalArgumentException(String.format("Unrecognized command %s issues", command.toString()));
        }

        return rover;
    }

    private Rover changeDirection(String direction, Rover rover) {
        int key = 0;
        direction = direction.toLowerCase();
        if (direction.equals("l")) {
            key = 3;
        } else if (direction.equals("r")) {
            key = 1;
        }

        rover.setOrientation((rover.getOrientation() + key) % 4);

        return rover;
    }

    private Rover moveForward(Rover rover) {
        int newCoord;
        switch (rover.getOrientation()) {
            case 1:
                newCoord = rover.getCurrentX() + 1;
                plateau.testBounds(newCoord, rover.getCurrentY());
                rover.setCurrentX(newCoord);
                break;
            case 3:
                newCoord = rover.getCurrentX() - 1;
                plateau.testBounds(newCoord, rover.getCurrentY());
                rover.setCurrentX(newCoord);
                break;
            case 0:
                newCoord = rover.getCurrentY() + 1;
                plateau.testBounds(rover.getCurrentX(), newCoord);
                rover.setCurrentY(newCoord);
                break;
            case 2:
                newCoord = rover.getCurrentY() - 1;
                plateau.testBounds(rover.getCurrentX(), newCoord);
                rover.setCurrentY(newCoord);
                break;
        }

        return rover;
    }

    public void draw() {
        // draw grid
        // draw rover.
    }

}
