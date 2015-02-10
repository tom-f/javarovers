package uk.co.tomf.javarovers.command;

import junit.framework.Assert;
import org.junit.Test;
import uk.co.tomf.javarovers.command.enums.Command;

/**
 * Created by tfawssett on 09/02/15.
 *
 */
public class TestCommandList {

    @Test
    public void testCommandListGenerationAndIteration() {
        CommandList commandList = new CommandList("MRML");

        Command[] list = new Command[]{Command.M, Command.R, Command.M, Command.L};

        int iteration = 0;
        for (Command command : commandList) {
            Assert.assertEquals(list[iteration], command);
            iteration++;
        }
    }

}
