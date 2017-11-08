package org.usfirst.frc.team5026.robot.commands;

import org.usfirst.frc.team5026.robot.Constants;
import org.usfirst.frc.team5026.robot.Robot;

import edu.wpi.first.wpilibj.command.TimedCommand;

/**
 *
 */
public class ResetRelease extends TimedCommand {
	public double timeout;
    public ResetRelease(double timeout) {
    	super(timeout);
    	this.timeout = timeout;
//    	requires(Robot.sort);
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.sort.resetRelease();
    	timeout+=0.01;
    	if (timeout>=100) {
    		end();
    	}
    	super.setTimeout(timeout);
    }

    // Called once after timeout
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
