package org.usfirst.frc.team5026.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;
import org.usfirst.frc.team5026.robot.Constants;

/**
 *
 */
public class ColorSort extends CommandGroup {

    public ColorSort() {
    	//Only checks when constructed for color, so this will not work
    	addSequential(new HitPropers(Constants.SORT_TIME));
    	addSequential(new ReleaseWaitCommand(Constants.RELEASE_TIME));
    	addSequential(new ResetSortCommand());
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
