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
		topServo.set(Constants.sortPower);
	}
	public void sortLeft() {
		bottomServo.set(-Constants.sortPower);
	}
	public void sortRight() {
		bottomServo.set(Constants.sortPower);
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
