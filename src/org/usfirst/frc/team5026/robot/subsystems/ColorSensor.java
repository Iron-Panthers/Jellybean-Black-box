package org.usfirst.frc.team5026.robot.subsystems;

import org.usfirst.frc.team5026.robot.ColorSensorI2C;
import org.usfirst.frc.team5026.robot.Constants;
import org.usfirst.frc.team5026.robot.Robot;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class ColorSensor extends Subsystem {
	public ColorSensorI2C colorSensor;
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	public ColorSensor() {
		colorSensor = Robot.hardware.colorSensor;
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
			return 0;
		}
		else if (isRGBInRange(isInBlackRange(rgb[0]),isInBlackRange(rgb[1]),isInBlackRange(rgb[2]))) {
			return 16;
		}
		return 8;
	}
	public int[] getColorRGB() {
		int[] rgb = colorSensor.getRGBC();
		int[] rgbDecimal = new int[3];
		for (int i = 0; i<rgb.length; i++) {
			String hex = ""+rgb[i]+"";
			//Converts to decimal to add to the int array
			rgbDecimal[i]= Integer.parseInt(hex,16);
		}
		return rgbDecimal;
	}
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

