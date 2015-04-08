package uk.co.tomf.javarovers.core;

import uk.co.tomf.javarovers.command.CommandList;
import uk.co.tomf.javarovers.command.Commander;
import uk.co.tomf.javarovers.rover.Grid;
import uk.co.tomf.javarovers.rover.Rover;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

/**
 * Created by tfawssett on 10/02/15.
 *
 */
public class NASA {

    private Grid plateau;

    public NASA(File inFile) {
        try {
            List<String> lines = Files.readAllLines(Paths.get(inFile.getPath()));

            int index = 0;
            for (String line: lines) {
                if (index == 0) { // First line is setting maxes
                    String[] maxes = line.split(" ");
                    this.plateau = new Grid(Integer.parseInt(maxes[0]), Integer.parseInt(maxes[1]));

                } else if ((index & 1) != 0) { // Odd line means we have a rover + next line = commands
                    //configure rover
                    String[] roverBits = line.split(" ");
                    Rover rover = new Rover(
                            Integer.parseInt(roverBits[0]),
                            Integer.parseInt(roverBits[1]),
                            roverBits[2].charAt(0)
                    );
                    Commander commander = new Commander(plateau);

                    // build command list
                    CommandList commandList = new CommandList(lines.get(index+1));
                    commander.applyCommands(rover, commandList);
                    System.out.println(rover.getPosition());
                }
                index++;
            }
        } catch (IOException ioException) {
            System.out.println("Could not read input file.");
            System.exit(1);
        }

    }

    public void run() {

    }

    public static void main(String[] args) {
        // load from text file else drop to stdin
        if (args.length > 0) {
            File file = new File(args[0]);
            if (file.exists()) {
                NASA nasa = new NASA(file);
                nasa.run();
                System.exit(0);
            }
        }

        throw new IllegalArgumentException(
            "Program requires a valid command file as first argument"
        );

    }
}
