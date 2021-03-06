package org.usfirst.frc.team5026.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	//Relese Servo
	public static final int TOP_SERVO_PORT = 9;
	public static final int TOP_SERVO_ENCODER_PORT1 = 0;
	public static final int TOP_SERVO_ENCODER_PORT2 = 1;
	
	//Sort Servo
	public static final int BOTTOM_SERVO_PORT = 4;
	public static final int BOTTOM_SERVO_ENCODER_PORT1 = 0;
	public static final int BOTTOM_SERVO_ENCODER_PORT2 = 1;
	
	public static final int COLOR_SENSOR_ADDRESS_DECIMAL = 0x29;
	public static final int COLOR_SENSOR_ADDRESS_HEX = 0x29; //0x70
	// For example to map the left and right motors, you could define the
	// following variables to use with your drivetrain subsystem.
	// public static int leftMotor = 1;
	// public static int rightMotor = 2;

	// If you are using multiple modules, make sure to define both the port
	// number and the module. For example you with a rangefinder:
	// public static int rangefinderPort = 1;
	// public static int rangefinderModule = 1;
}
