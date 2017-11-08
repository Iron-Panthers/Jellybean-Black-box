package org.usfirst.frc.team5026.robot;

import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj.Spark;

public class Hardware {
	public Spark topServo;
	public Spark bottomServo;
	
	//Color sensor?
	public I2C colorSensor;
	
	//Inverted
	public boolean topServoInverted = false;
	public boolean bottomServoInverted = false;
	public Hardware() {
		topServo = new Spark(RobotMap.TOP_SERVO_PORT);
		topServo.setInverted(topServoInverted);
		bottomServo = new Spark(RobotMap.BOTTOM_SERVO_PORT);
		bottomServo.setInverted(bottomServoInverted);
//		colorSensor = new I2C();
	}
}
