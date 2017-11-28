package org.usfirst.frc.team5026.robot;

import org.usfirst.frc.team5026.robot.commands.ColorSensorTest;
import org.usfirst.frc.team5026.robot.commands.ColorSort;
import org.usfirst.frc.team5026.robot.commands.ResetRelease;
import org.usfirst.frc.team5026.robot.commands.SortLeftCommGroup;
import org.usfirst.frc.team5026.robot.commands.SortRightCommGroup;
import org.usfirst.frc.team5026.robot.commands.SortRightWaitCommand;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;


/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	Joystick stick;
	Button stickBtnOne;
	Button stickBtnTwo;
	Button stickBtnThree;
	Button stickBtnFour;
	Button stickBtnFive;
	Button stickBtnSix;
	public OI() {
		stick = new Joystick(1);
		stickBtnOne = new JoystickButton(stick, 1);
		stickBtnTwo = new JoystickButton(stick, 2);
		stickBtnThree = new JoystickButton(stick, 3);
		stickBtnFour = new JoystickButton(stick, 4);
		stickBtnFive = new JoystickButton(stick, 5);
		stickBtnSix = new JoystickButton(stick, 6);
	}
	public void mapButtons() {
//		stickBtnOne.whenPressed(new ColorSort());
		//For testing
		stickBtnTwo.whenPressed(new SortLeftCommGroup());
		stickBtnThree.whenPressed(new SortRightCommGroup());
		stickBtnFour.whenPressed(new ResetRelease());
		stickBtnFive.whenPressed(new SortRightWaitCommand(Constants.SORT_TIME));
		stickBtnSix.whileHeld(new ColorSensorTest());
	}
	//// CREATING BUTTONS
	// One type of button is a joystick button which is any button on a
	//// joystick.
	// You create one by telling it which joystick it's on and which button
	// number it is.
	// Joystick stick = new Joystick(port);
	// Button button = new JoystickButton(stick, buttonNumber);

	// There are a few additional built in buttons you can use. Additionally,
	// by subclassing Button you can create custom triggers and bind those to
	// commands the same as any other Button.

	//// TRIGGERING COMMANDS WITH BUTTONS
	// Once you have a button, it's trivial to bind it to a button in one of
	// three ways:

	// Start the command when the button is pressed and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenPressed(new ExampleCommand());

	// Run the command while the button is being held down and interrupt it once
	// the button is released.
	// button.whileHeld(new ExampleCommand());

	// Start the command when the button is released and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenReleased(new ExampleCommand());
}
