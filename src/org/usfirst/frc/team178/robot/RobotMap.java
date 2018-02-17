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
	
	public static int DMTopRight = 1; // PWM
	public static int DMMiddleRight = 2; // PWM
	public static int DMBottomRight = 3; // PWM
	public static int DMTopLeft = 4; // PWM
	public static int DMMiddleLeft = 5; // PWM
	public static int DMBottomLeft = 6; // PWM
	
	public static int RAMPleft1 = 7; // PWM
	public static int RAMPleft2 = 8; // PWM
	public static int RAMPright1 = 9; // PWM
	public static int RAMPright2 = 10; // PWM
	
	public static int DRIVEencoderRA = 0; // DIO
	public static int DRIVEencoderRB = 1; // DIO
	public static int DRIVEencoderLA = 2; // DIO
	public static int DRIVEencoderLB = 3; // DIO
	
	public static int DRIVEGyro = 1; // Analog
	
	public static int INTAKEleft = 11; // PWM
	public static int INTAKEright = 12; // PWM
	
	public static int JoystickPort = 0; // computer
	public static int JoystickPortXBOX = 1; // computer
	
	public static int PCM = 7; // CAN
	
	public static int INTAKEleftout = 0; // PCM
	public static int INTAKEleftin = 1; // PCM
	public static int INTAKErightout = 2; // PCM
	public static int INTAKErightin = 3; // PCM

	public static int shootingPistonOUT = 4; // PCM
	public static int shootingPistonIN = 5; // PCM
	
	public static int WINCH1 = 13; // PWM
	public static int WINCH2 = 14; // PWM
	public static int CLIMBER = 15; // PWM
	
	public static int PRESSURETRANSDUCER = 0; // Analog
	public static int ULTRASONICINPUT = 2; // Analog

}
