package org.usfirst.frc.team5026.robot.subsystems;

import org.usfirst.frc.team5026.robot.ColorSensorI2C;
import org.usfirst.frc.team5026.robot.Constants;
import org.usfirst.frc.team5026.robot.Robot;

import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Sort extends Subsystem{
	//Release Servo
	public Servo topServo;
//	public Encoder topServoEncoder;
	
	//Sort Servo
	public Servo bottomServo;
//	public Encoder bottomServoEncoder;
	public ColorSensorI2C colorSensor;
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
		colorSensor = Robot.hardware.colorSensor;
	}
	public void releaseBean() {
//		topServo.setAngle(Constants.RELEASE_ANGLE);
		topServo.setPosition(Constants.RELEASE_POS);
	}
	public void resetRelease() {
//		topServo.setAngle(topServo.getAngle()-Constants.RELEASE_ANGLE);
		topServo.setPosition(Constants.RELEASE_DEFAULT_POS);
	}
	public void sortLeft() {
//		bottomServo.setAngle(-Constants.SORT_ANGLE);
		bottomServo.setPosition(Constants.SORT_LEFT_POS);
	}
	public void sortRight() {
//		bottomServo.setAngle(Constants.SORT_ANGLE);
		bottomServo.setPosition(Constants.SORT_RIGHT_POS);
	}
	public void resetSort() {
		bottomServo.setPosition(Constants.SORT_DEFAULT_POS);
	}
	public boolean isInWhiteRange(int test) {
		String testString = ""+test+"";
		int testDecimal = Integer.parseInt(testString,16);
		if ((testDecimal>=Constants.RGB_MIN_WHITE) && testDecimal<=Constants.RGB_MAX_WHITE) {
			return true;
		}
		return false;
	}
	public boolean isInBlackRange(int test) {
		String testString = ""+test+"";
		int testDecimal = Integer.parseInt(testString,16);
		if ((testDecimal>=Constants.RGB_MIN_BLACK) && testDecimal<=Constants.RGB_MAX_BLACK) {
			return true;
		}
		return false;
	}
	public boolean isRGBInRange(boolean r, boolean g, boolean b) {
		//If all true, return true
		if (r) {
			if(g) {
				if(b) {
					return true;
				}
			}
		}
		return false;
	}
	public int getColor() {
		//Returns color of jelly bean
		int[] rgb = colorSensor.getRGBC();
		//Test for white
		//If R, G, and B values to decimal
		if (isRGBInRange(isInWhiteRange(rgb[0]),isInWhiteRange(rgb[1]),isInWhiteRange(rgb[2]))) {
			//White
			return 0;
		}
		else if (isRGBInRange(isInBlackRange(rgb[0]),isInBlackRange(rgb[1]),isInBlackRange(rgb[2]))) {
			//Black
			return 16;
		}
		//Other
		return 8;
	}
	public int[] getColorRGB() {
		int[] rgb = colorSensor.getRGBC();
		System.out.println(rgb[0]);
		int[] rgbDecimal = new int[3];
//		for (int i = 0; i<rgb.length; i++) {
//			String hex = ""+rgb[i]+"";
//			//Converts to decimal to add to the int array
//			rgbDecimal[i] = Integer.parseInt(hex,16);
//		}
//		return rgbDecimal;
		int[] test = new int[3];
		test[0] = 255;
		test[1] = 255;
		test[2] = 255;
		return test;
	}
	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		
	}
}
