package org.usfirst.frc.team5026.robot.commands;

import org.usfirst.frc.team5026.robot.Constants;
import org.usfirst.frc.team5026.robot.Robot;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class RunCommands extends CommandGroup {

    public RunCommands() {
//    	addSequential(new SenseColor);
    	System.out.println("Running commands");
    	int color = Robot.colorSensor.getColor();
    	if (color==0 || color ==16) {
    		addSequential(new SortLeftCommand());
    		addSequential(new ReleaseCommand());
    		addSequential(new ResetSortCommand());
    	}
    	else {
    		addSequential(new SortRightCommand());
    		addSequential(new ReleaseCommand());
    		addSequential(new ResetSortCommand());
    	}
    	addSequential(new ResetRelease());
    	
    	
    	
    	
    	
        // Add Commands here:
        // e.g. addSequential(new Command1());
        //      addSequential(new Command2());
        // these will run in order.

        // To run multiple commands at the same time,
        // use addParallel()
        // e.g. addParallel(new Command1());
        //      addSequential(new Command2());
        // Command1 and Command2 will run in parallel.

        // A command group will require all of the subsystems that each member
        // would require.
        // e.g. if Command1 requires chassis, and Command2 requires arm,
        // a CommandGroup containing them would require both the chassis and the
        // arm.
    }
}
