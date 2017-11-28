package org.usfirst.frc.team5026.robot.commands;

import org.usfirst.frc.team5026.robot.Robot;

import edu.wpi.first.wpilibj.command.TimedCommand;

/**
 *
 */
public class SortLeftWaitCommand extends TimedCommand {

    public SortLeftWaitCommand(double timeout) {
        super(timeout);
        requires(Robot.sort);
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.sort.sortLeft();
    }

    // Called once after timeout
    protected void end() {
    	System.out.println("Sorting out bad ones");
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
