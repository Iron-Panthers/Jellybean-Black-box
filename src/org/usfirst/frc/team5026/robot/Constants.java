package org.usfirst.frc.team5026.robot;

public class Constants {
	//Sort Subsystem Things
	//Sort
	public static final double SORT_POWER = 0.2;
	public static final double SORT_TIME = 0.00000001; //In seconds
	public static final double SORT_ANGLE = 10;
	public static final double SORT_DEFAULT_ANGLE = 20;
	//Release
	public static final double RELEASE_TIME = 0.00000001; //In seconds
	public static final double RELEASE_ANGLE = 10;
	public static final double RELEASE_DEFAULT_ANGLE = 30; //May not use, can just move back servo
	
	
	//Encoder Things
	//Top Encoder
	public static final boolean TOP_SERVO_ENCODER_IS_REVERSE = false;
	public static final double TOP_SERVO_ENCODER_MAX_PERIOD = 0.01;
	public static final double TOP_SERVO_ENCODER_MIN_RATE = 0.5; //RPS
	//Bottom Encoder
	public static final boolean BOTTOM_SERVO_ENCODER_IS_REVERSE = false;
	public static final double BOTTOM_SERVO_ENCODER_MAX_PERIOD = 0.01;
	public static final double BOTTOM_SERVO_ENCODER_MIN_RATE = 0.5; //RPS

}
