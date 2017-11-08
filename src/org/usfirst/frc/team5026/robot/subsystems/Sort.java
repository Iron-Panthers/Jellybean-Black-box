package org.usfirst.frc.team5026.robot.subsystems;

import org.usfirst.frc.team5026.robot.Constants;
import org.usfirst.frc.team5026.robot.Robot;

import edu.wpi.first.wpilibj.Spark;

public class Sort {
	public Spark topServo;
	public Spark bottomServo;
	public Sort() {
		topServo = Robot.hardware.topServo;
		bottomServo = Robot.hardware.bottomServo;
	}
	public void releaseBean() {
		topServo.set(Constants.SORT_POWER);
	}
	public void resetRelease() {
		topServo.set(-Constants.SORT_POWER);
	}
	public void sortLeft() {
		bottomServo.set(-Constants.SORT_POWER);
	}
	public void sortRight() {
		bottomServo.set(Constants.SORT_POWER);
	}
	public void stopTop() {
		topServo.set(0);
	}
	public void stopBottom() {
		topServo.set(0);
	}
	public void stopAll() {
		stopTop();
		stopBottom();
	}
}
