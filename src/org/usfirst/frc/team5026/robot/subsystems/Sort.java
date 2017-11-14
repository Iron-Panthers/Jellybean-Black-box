package org.usfirst.frc.team5026.robot.subsystems;

import org.usfirst.frc.team5026.robot.Constants;
import org.usfirst.frc.team5026.robot.Robot;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Servo;

public class Sort {
	//Release Servo
	public Servo topServo;
//	public Encoder topServoEncoder;
	
	//Sort Servo
	public Servo bottomServo;
//	public Encoder bottomServoEncoder;
	
	public Sort() {
		//Release Servo
		topServo = Robot.hardware.topServo;
//		topServoEncoder = Robot.hardware.topServoEncoder;
		
//		//Sort Servo
		bottomServo = Robot.hardware.bottomServo;
//		bottomServoEncoder = Robot.hardware.bottomServoEncoder;
//		
//		//Encoder Commands
//		topServoEncoder.setMaxPeriod(Constants.TOP_SERVO_ENCODER_MAX_PERIOD);
	}
	public void releaseBean() {
		topServo.setAngle(Constants.RELEASE_ANGLE);
	}
	public void resetRelease() {
		topServo.setAngle(topServo.getAngle()-Constants.RELEASE_ANGLE);
	}
	public void sortLeft() {
		bottomServo.setAngle(-Constants.SORT_ANGLE);
	}
	public void sortRight() {
		bottomServo.setAngle(Constants.SORT_ANGLE);
	}
	public void resetSort() {
		bottomServo.setAngle(Constants.SORT_DEFAULT_ANGLE);
	}
}
