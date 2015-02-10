package uk.co.tomf.javarovers.command;

import uk.co.tomf.javarovers.command.enums.Command;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * Created by tfawssett on 09/02/15.
 *
 * Wrapper around some commands
 */
public class CommandList implements Iterable<Command> {

    private LinkedList<Command> commandList = new LinkedList<Command>();

    public CommandList(String commandsString) {
        for (String commandString : commandsString.split("(?!^)")) {
            Command c = Command.fromString(commandString.toLowerCase());
            commandList.add(c);
        }
    }

    public Iterator<Command> iterator() {
        return commandList.listIterator();
    }



}
