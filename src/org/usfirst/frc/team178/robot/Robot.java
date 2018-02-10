package org.usfirst.frc.team178.robot;

import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc.team178.robot.autocommandgroups.*;
import org.usfirst.frc.team178.robot.subsystems.*;

import org.usfirst.frc.team178.robot.autocommandgroups.Autonomous;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {

	public static OI oi;
	public static Drivetrain drivetrain;
	public static CubeIntake cubeintake;
	public static Climber climber;
	public static Pneumatics pneumatics;
	public static AnalogGyro gyro;
	public static Autonomous autonomous;

	Command autonomousCommand;
	//private Command Autonomous; delete meeee
	
	public static SendableChooser<String> temp = new SendableChooser<>();
	public static SendableChooser<String> switchChooser = new SendableChooser<>();
	public static SendableChooser<String> scaleChooser = new SendableChooser<>();
	public static SendableChooser<String> goForward = new SendableChooser<>();
	public static SendableChooser<String> pickUpSecondBlock = new SendableChooser<>();
	public static SendableChooser<String> vault = new SendableChooser<>();
	
	public static boolean goForwardChoice;
	public static boolean vaultChooser;
	public static boolean switchChoice;
	public static boolean scaleChoice;
	public static boolean secondBlock;
	public static boolean isOnSide;
	
	public static String gameData;
	public static char switchSide;
	public static char scaleSide;
	public static String position;

	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	@Override
	
	
	public void robotInit() {
		drivetrain = new Drivetrain();
		cubeintake = new CubeIntake();
		climber = new Climber();
		pneumatics = new Pneumatics();
		oi = new OI();
		
		temp.addObject("Left", "Left");
		temp.addObject("Middle", "Middle");
		temp.addObject("Right", "Right");
		SmartDashboard.putData("AutoLocation", temp);

		
		switchChooser.addObject("Yes", "Yes");
		switchChooser.addObject("No", "No");

		scaleChooser.addObject("Yes", "Yes");
		scaleChooser.addObject("No", "No");
		
		goForward.addObject("Yes", "Yes");
		goForward.addObject("No", "No");
		SmartDashboard.putData("Drive Forward?", goForward);
		
		pickUpSecondBlock.addObject("Yes", "Yes");
		pickUpSecondBlock.addObject("No", "No");

		vault.addObject("Yes", "Yes");
		vault.addObject("No", "No");

		SmartDashboard.putData("Go for vault?", vault);
		SmartDashboard.putData("Go for switch?", switchChooser);
		SmartDashboard.putData("Go for scale?", scaleChooser);
		SmartDashboard.putData("Second block?", pickUpSecondBlock);
	}	

	public static String returnSelection() {
		return temp.getSelected();
		
	}
	/**
	 * This function is called once each time the robot enters Disabled mode.
	 * You can use it to reset any subsystem information you want to clear when
	 * the robot is disabled.
	 */
	@Override
	public void disabledInit() {
			}

	@Override
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	/**
	 * This autonomous (along with the chooser code above) shows how to select
	 * between different autonomous modes using the dashboard. The sendable
	 * chooser code works with the Java SmartDashboard. If you prefer the
	 * LabVIEW Dashboard, remove all of the chooser code and uncomment the
	 * getString code to get the auto name from the text box below the Gyro
	 *
	 * You can add additional auto modes by adding additional commands to the
	 * chooser code above (like the commented example) or additional comparisons
	 * to the switch structure below with additional strings & commands.
	 */
	@Override
	public void autonomousInit() {
	    //    gameData = DriverStation.getInstance().getGameSpecificMessage();\
			gameData = "RLR"; //for testing purposes
	        switchSide = gameData.charAt(0);
	        scaleSide = gameData.charAt(1);
	    	position = Robot.returnSelection();
	    autonomous = new Autonomous();
    	autonomousCommand = autonomous;
		
		if((goForward.getSelected()).equals("Yes"))
			goForwardChoice = true;
		else
			goForwardChoice = false;
		
		
		if((vault.getSelected()).equals("Yes"))
			vaultChooser = true;
		else
			vaultChooser = false;
		
		
		if((switchChooser.getSelected()).equals("Yes"))
			switchChoice = true;
		else
			switchChoice = false;
		
		
		if((scaleChooser.getSelected()).equals("Yes"))
			scaleChoice = true;
		else
			scaleChoice = false;
		
		
		if((pickUpSecondBlock.getSelected()).equals("Yes"))
			secondBlock = true;
		else
			secondBlock = false;
		
		
		if((temp.getSelected()).equals("Middle"))
			isOnSide = false;
		else
			isOnSide = true;
		
		if(autonomousCommand != null)
			autonomousCommand.start();

		/*
		 * String autoSelected = SmartDashboard.getString("Auto Selector",
		 * "Default"); switch(autoSelected) { case "My Auto": autonomousCommand
		 * = new MyAutoCommand(); break; case "Default Auto": default:
		 * autonomousCommand = new ExampleCommand(); break; }
		 */

		// schedule the autonomous command (example)
		
	}

	/**
	 * This function is called periodically during autonomous
	 */
	@Override
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
	}

	@Override
	public void teleopInit() {
		// This makes sure that the autonomous stops running when
		// teleop starts running. If you want the autonomous to
		// continue until interrupted by another command, remove
		// this line or comment it out.
		if(autonomousCommand != null)
			autonomousCommand.cancel();
		//add something else
		
	}

	/**
	 * This function is called periodically during operator control
	 */
	@Override
	public void teleopPeriodic() {
		//add something
		Scheduler.getInstance().run();
	}

	/**
	 * This function is called periodically during test mode
	 */
	@Override
	public void testPeriodic() {
		LiveWindow.run();
	}
}