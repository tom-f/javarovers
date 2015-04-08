package uk.co.tomf.javarovers.command.enums;

/**
 * Created by tfawssett on 09/02/15.
 */
public enum Command {

    M("m"), L("l"), R("r");
    String value;

    Command(String value) {
        this.value = value;
    }

    public static Command fromString(String value) {
        for (Command command : Command.values()) {
            if (command.value.equals(value)) {
                return command;
            }
        }

        throw new IllegalArgumentException(String.format("%s is not a valid command", value));
    }

    public String toString() {
        return value;
    }

}
