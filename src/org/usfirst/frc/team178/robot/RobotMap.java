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
	public static int DMTopLeft;
	public static int DMMiddleLeft;
	public static int DMBottomLeft;
	public static int DMTopRight;
	public static int DMMiddleRight;
	public static int DMBottomRight;
	
	public static int DRIVEencoderRA;
	public static int DRIVEencoderRB;
	public static int DRIVEencoderLA;
	public static int DRIVEencoderLB;
	
	public static int INTAKEleft;
	public static int INTAKEright;
}
