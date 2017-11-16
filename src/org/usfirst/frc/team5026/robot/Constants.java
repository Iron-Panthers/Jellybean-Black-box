package org.usfirst.frc.team5026.robot;

public class Constants {
	//Sort Subsystem Things
	//Sort
	public static final double SORT_POWER = 0.2;
	public static final double SORT_TIME = 0.5; //In seconds
	public static final double SORT_DEFAULT_ANGLE = -90;
	public static final double SORT_ANGLE = SORT_DEFAULT_ANGLE+10;
	//Actual values
	public static final double SORT_DEFAULT_POS = 0.475;
	public static final double SORT_RIGHT_POS = 0.55;
	public static final double SORT_LEFT_POS = 0.4;
	
	
	//Release
	public static final double RELEASE_TIME = 1.5; //In seconds
	public static final double RELEASE_ANGLE = 11;
	//Actual value
	public static final double RELEASE_POS = 0.1;
	public static final double RELEASE_DEFAULT_ANGLE = 90; //May not use, can just move back servo
	//Actual value
	public static final double RELEASE_DEFAULT_POS = 0.25;
	
	//Color Sensor Things
	public static final int RGB_MAX_WHITE = 255;
	public static final int RGB_MIN_WHITE = 200;
	public static final int RGB_MAX_BLACK = 55;
	public static final int RGB_MIN_BLACK = 0;
	
	
	
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
