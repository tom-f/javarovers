package uk.co.tomf.javarovers.rover;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by tfawssett on 09/02/15.
 *
 */
public class TestRover {

    @Test
    public void testRoverInstantiation()
    {
        Rover rover = new Rover(4, 4, 1, 2, 'N');
        Assert.assertTrue(rover.getPosition().equals("1 2 N"));
    }

//    @Test
//    public void testMoveForward() {
//
//        Rover rover = new Rover(50, 50, 5, 5, 'N');
//        rover.moveForward();
//        Assert.assertTrue(rover.getPosition().equals("5 6 N"));
//
//        rover = new Rover(50, 50, 5, 5, 'S');
//        rover.moveForward();
//        Assert.assertTrue(rover.getPosition().equals("5 4 S"));
//
//        rover = new Rover(50, 50, 5, 5, 'E');
//        rover.moveForward();
//        Assert.assertTrue(rover.getPosition().equals("6 5 E"));
//
//        rover = new Rover(50, 50, 5, 5, 'W');
//        rover.moveForward();
//        Assert.assertTrue(rover.getPosition().equals("4 5 W"));
//    }
//
//    @Test
//    public void testTurnLeft() {
//        Rover rover = new Rover(50, 50, 5, 5, 'N');
//        rover.changeDirection("L");
//        Assert.assertTrue(rover.getPosition().equals("5 5 W"));
//
//        rover = new Rover(50, 50, 5, 5, 'E');
//        rover.changeDirection("L");
//        Assert.assertTrue(rover.getPosition().equals("5 5 N"));
//
//        rover = new Rover(50, 50, 5, 5, 'S');
//        rover.changeDirection("L");
//        Assert.assertTrue(rover.getPosition().equals("5 5 E"));
//
//        rover = new Rover(50, 50, 5, 5, 'W');
//        rover.changeDirection("L");
//        Assert.assertTrue(rover.getPosition().equals("5 5 S"));
//    }
//
//    @Test
//    public void testTurnRight() {
//        Rover rover = new Rover(50, 50, 5, 5, 'N');
//        rover.changeDirection("R");
//        Assert.assertTrue(rover.getPosition().equals("5 5 E"));
//
//        rover = new Rover(50, 50, 5, 5, 'E');
//        rover.changeDirection("R");
//        Assert.assertTrue(rover.getPosition().equals("5 5 S"));
//
//        rover = new Rover(50, 50, 5, 5, 'S');
//        rover.changeDirection("R");
//        Assert.assertTrue(rover.getPosition().equals("5 5 W"));
//
//        rover = new Rover(50, 50, 5, 5, 'W');
//        rover.changeDirection("R");
//        Assert.assertTrue(rover.getPosition().equals("5 5 N"));
//    }

}
