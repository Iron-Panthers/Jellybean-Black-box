package org.usfirst.frc.team5026.robot.commands;

import org.usfirst.frc.team5026.robot.Robot;

import edu.wpi.first.wpilibj.command.TimedCommand;

/**
 *
 */
public class SortLeftCommand extends TimedCommand {
//	public double timeout;
    public SortLeftCommand(double timeout) {
        super(timeout);
//        this.timeout=timeout;
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
//    	timeout+=0.01;
    	Robot.sort.sortLeft();
//    	if (timeout>=0.02) {
//    		end();
//    	}
//    	super.setTimeout(timeout);
    }

    // Called once after timeout
    protected void end() {
    	Robot.sort.stopBottom();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	Robot.sort.stopBottom();
    }
}