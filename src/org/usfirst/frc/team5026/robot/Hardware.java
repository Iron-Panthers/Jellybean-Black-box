package org.usfirst.frc.team5026.robot;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj.Servo;

public class Hardware {
	//Release Servo
	public Servo topServo;
	public Encoder topServoEncoder;
	
	//Sort Servo
	public Servo bottomServo;
	public Encoder bottomServoEncoder;
	
	//Color sensor?
	public ColorSensorI2C colorSensor;
	
	//Inverted
	public boolean topServoInverted = false;
	public boolean bottomServoInverted = false;
	public Hardware() {
		//Release Servo
		topServo = new Servo(RobotMap.TOP_SERVO_PORT);
//		topServo.setInverted(topServoInverted);
//		topServoEncoder = new Encoder(RobotMap.TOP_SERVO_ENCODER_PORT1,RobotMap.TOP_SERVO_ENCODER_PORT2,Constants.TOP_SERVO_ENCODER_IS_REVERSE);
		
		//Sort Servo
		bottomServo = new Servo(RobotMap.BOTTOM_SERVO_PORT);
//		double defaultPos = bottomServo.getPosition();
//		System.out.println(defaultPos+"hi");
//		bottomServo.setInverted(bottomServoInverted);
//		bottomServoEncoder = new Encoder(RobotMap.BOTTOM_SERVO_ENCODER_PORT1,RobotMap.BOTTOM_SERVO_ENCODER_PORT2,Constants.BOTTOM_SERVO_ENCODER_IS_REVERSE);

		colorSensor = new ColorSensorI2C(I2C.Port.kOnboard, RobotMap.COLOR_SENSOR_ADDRESS_DECIMAL);
	}
}
