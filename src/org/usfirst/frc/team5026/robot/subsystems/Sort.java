package org.usfirst.frc.team5026.robot.subsystems;

import org.usfirst.frc.team5026.robot.ColorSensorI2C;
import org.usfirst.frc.team5026.robot.Constants;
import org.usfirst.frc.team5026.robot.Robot;
import org.usfirst.frc.team5026.robot.commands.ChooseCommGroup;

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
		int testDecimal = test;
		//65000/256
//		System.out.print("Hex value: "+test+"Decimal value: ");
		System.out.println(testDecimal);
		if ((testDecimal<=Constants.RGB_MAX_WHITE) && testDecimal>=Constants.RGB_MIN_WHITE) {
			return true;
		}
		return false;
	}
	public boolean isInBlackRange(int test) {
		int testDecimal = test;
		//65000/256
//		System.out.print("Hex value: "+test+"Decimal value: ");
		System.out.println(testDecimal);
		if ((testDecimal>=Constants.RGB_MIN_BLACK) && testDecimal<=Constants.RGB_MAX_BLACK) {
			return true;
		}
		return false;
	}
	public boolean isRGBInRange(boolean r, boolean g, boolean b) {
		return r && g && b;
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
	public void getColorTest() {
		int[] rgb = colorSensor.getRGBC();
		//Black, white
		System.out.println("Is White: "+ isRGBInRange(isInWhiteRange(rgb[0]),isInWhiteRange(rgb[1]),isInWhiteRange(rgb[2])));
		System.out.println("Black: "+ isRGBInRange(isInBlackRange(rgb[0]),isInBlackRange(rgb[1]),isInBlackRange(rgb[2])));
		System.out.println("Red"+isInWhiteRange(rgb[0]));
		System.out.println("Green"+isInWhiteRange(rgb[1]));
		System.out.println("Blue"+isInWhiteRange(rgb[2]));
	}
	@Override
	protected void initDefaultCommand() {
		setDefaultCommand(new ChooseCommGroup());
		// TODO Auto-generated method stub
		
	}
}
