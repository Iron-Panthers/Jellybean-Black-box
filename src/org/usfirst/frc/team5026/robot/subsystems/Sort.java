package org.usfirst.frc.team5026.robot.subsystems;

import org.usfirst.frc.team5026.robot.Constants;
import org.usfirst.frc.team5026.robot.Robot;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Spark;

public class Sort {
	//Release Servo
	public Spark topServo;
	public Encoder topServoEncoder;
	
	//Sort Servo
	public Spark bottomServo;
	public Encoder bottomServoEncoder;
	
	public Sort() {
		//Release Servo
		topServo = Robot.hardware.topServo;
		topServoEncoder = Robot.hardware.topServoEncoder;
		
		//Sort Servo
		bottomServo = Robot.hardware.bottomServo;
		bottomServoEncoder = Robot.hardware.bottomServoEncoder;
		
		//Encoder Commands
		topServoEncoder.setMaxPeriod(Constants.TOP_SERVO_ENCODER_MAX_PERIOD);
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
