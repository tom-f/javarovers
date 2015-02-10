package uk.co.tomf.javarovers.command;

import uk.co.tomf.javarovers.command.enums.Command;
import uk.co.tomf.javarovers.rover.Rover;

/**
 * Created by tfawssett on 09/02/15.
 *
 * A rover's brain
 */
public class Commander {

    public Rover applyCommands(Rover rover, CommandList commandList) {

        for (Command command : commandList) {
            rover = applyCommand(rover, command);
        }

        return rover;
    }

    private Rover applyCommand(Rover rover, Command command) {
        switch (command) {
            case M:
                rover.moveForward();
                break;
            case L:
                rover.changeDirection(Command.L.toString());
                break;
            case R:
                rover.changeDirection(Command.R.toString());
                break;
            default:
                throw new IllegalArgumentException(String.format("Unrecognized command %s issues", command.toString()));
        }

        return rover;
    }
}
