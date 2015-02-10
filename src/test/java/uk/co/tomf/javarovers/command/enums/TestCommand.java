package uk.co.tomf.javarovers.command.enums;

import junit.framework.Assert;
import org.junit.Test;

/**
 * Created by tfawssett on 09/02/15.
 */
public class TestCommand {

    @Test
    public void testCommands() {
        Command mCommand = Command.fromString("m");
        Assert.assertEquals(mCommand, Command.M);

        Command lCommand = Command.fromString("l");
        Assert.assertEquals(lCommand, Command.L);

        Command rCommand = Command.fromString("r");
        Assert.assertEquals(rCommand, Command.R);
    }

    @Test
    public void testToString() {
        Command rCommand = Command.fromString("r");
        Assert.assertTrue(rCommand.toString().equals("r"));
    }

}
