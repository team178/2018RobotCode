/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team178.robot;

import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

import org.usfirst.frc.team178.robot.commands.*;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	Joystick joystick1 = new Joystick(RobotMap.JoystickPort);
	public Button button1 = new JoystickButton(joystick1, 1);
	public Button button2 = new JoystickButton(joystick1, 2);
	public Button button3 = new JoystickButton(joystick1, 3);
	public Button button4 = new JoystickButton(joystick1, 4);
	public Button button5 = new JoystickButton(joystick1, 5);
	public Button button6 = new JoystickButton(joystick1, 6);
	public Button button7 = new JoystickButton(joystick1, 7);
	
	static Joystick xbox = new Joystick(RobotMap.JoystickPortXBOX);
	public Button buttonA = new JoystickButton(xbox, 1);
	public Button buttonB = new JoystickButton(xbox, 2);
	public Button buttonX = new JoystickButton(xbox, 3);
	public Button buttonY = new JoystickButton(xbox, 4);
	public Button lBumper = new JoystickButton(xbox, 5);
	public Button rBumper = new JoystickButton(xbox, 6);
	public Button backButton = new JoystickButton(xbox, 7);
	public Button startButton = new JoystickButton(xbox, 8);
	
	static Joystick xboxdrive = new Joystick(2);
	
	
	public OI () { //when pressed is up or down, while held is out or information
	//	 buttonY.whileHeld(new ShootScale()); NOTE: Can't shoot for scale
	//	 buttonA.whenPressed(new RaiseRamp());
	//	 buttonB.whenPressed(new LowerRamp());
		 buttonX.whileHeld(new ShootSwitch(false));
		 lBumper.whileHeld(new CollectCube());
		 rBumper.whileHeld(new ControlRampIntake());
		 button5.whenPressed(new DropIntake(false));
		 button2.whenPressed(new FoldIntake());
		 buttonA.whileHeld(new Climb());
		 buttonY.whileHeld(new RotateArm());
		 buttonB.whileHeld(new ReverseRotateArm());
		 
		 
		 

		//fill in as soon as we know what buttons will do what
	}
	
	/*public double getXboxDriveX() {
		return xboxdrive.getRawAxis()
	}
	
	public double getXboxDriveY() {
		return xboxdrive.getRawAxis()
	}*/
	public double getXboxRightY() {
		return xbox.getRawAxis(5);
	}
	
	public double getXboxLeftY() {
		return xbox.getRawAxis(1);
	}
	
	public double getX () {
		return joystick1.getX();
	}
	
	public double getY () {
		return joystick1.getY();
	}
	
	public double getTwist () {
		return joystick1.getRawAxis(3);
	}
	
	public double getTrigger() {
		return xbox.getRawAxis(3);
	}
	
	
}
