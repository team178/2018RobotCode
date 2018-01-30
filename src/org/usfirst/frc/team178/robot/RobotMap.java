/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team178.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	// For example to map the left and right motors, you could define the
	// following variables to use with your drivetrain subsystem.
	// public static int leftMotor = 1;
	// public static int rightMotor = 2;

	// If you are using multiple modules, make sure to define both the port
	// number and the module. For example you with a rangefinder:
	// public static int rangefinderPort = 1;
	// public static int rangefinderModule = 1;
	
	//Drivetrain variables (Will assign values later)
	public static int DMTopLeft = 4;
	public static int DMMiddleLeft = 5;
	public static int DMBottomLeft = 6;
	public static int DMTopRight = 1;
	public static int DMMiddleRight = 2;
	public static int DMBottomRight = 3;
	
	
	public static int DRIVEencoderRA = 1;
	public static int DRIVEencoderRB = 2;
	public static int DRIVEencoderLA = 3;
	public static int DRIVEencoderLB = 4;
	
	public static int DRIVEGyro = 1;
	
	public static int INTAKEleft1 = 1;
	public static int INTAKEleft2 = 2;
	public static int INTAKEright1 = 3;
	public static int INTAKEright2 = 4;
	
	public static int JoystickPort = 0;
	public static int JoystickPortXBOX = 1;
	
	public static int PCM = 7;
	
	public static int INTAKEleftout = 0;
	public static int INTAKEleftin = 1;
	public static int INTAKErightout = 3;
	public static int INTAKErightin = 4;
	
	public static int ClimberPort;
	
	public static int PRESSURETRANSDUCER = 0;

}
