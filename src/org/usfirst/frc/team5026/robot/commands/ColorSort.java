package org.usfirst.frc.team5026.robot.commands;

import org.usfirst.frc.team5026.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ColorSort extends Command {
	SortLeftCommand sortLeft;
	SortRightCommand sortRight;
	ReleaseCommand release;
	ResetRelease resetRelease;
	ResetSortCommand resetSort;
    public ColorSort() {
//    	requires(Robot.sort);
    	requires(Robot.colorSensor);
    	sortLeft = new SortLeftCommand();
    	release = new ReleaseCommand();
    	resetSort = new ResetSortCommand();
    	sortRight = new SortRightCommand();
    	resetRelease = new ResetRelease();
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	if (Robot.colorSensor.getColor()==0 || Robot.colorSensor.getColor()==16) {
    		
    		sortLeft.start();
    		
    		release.start();
    		
    		resetSort.start();
    	}
    	else { //Color would be 8
    		sortRight.start();
    		release.start();
    	}
    	resetRelease.start();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return true;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
