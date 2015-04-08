package uk.co.tomf.javarovers.command;

import uk.co.tomf.javarovers.rover.Rover;

/**
 * Created by tfawssett on 17/02/15.
 */
public interface CommandInterface {



    public Rover apply(Rover rover);

}
