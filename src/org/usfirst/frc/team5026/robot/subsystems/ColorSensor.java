package org.usfirst.frc.team5026.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class ColorSensor extends Subsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	public ColorSensor() {
		
	}
	public int getColor() {
		//Returns color of jelly bean
		return 0;
	}
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

