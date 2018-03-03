package org.usfirst.frc.team178.robot.commands;

import org.usfirst.frc.team178.robot.Robot;
import org.usfirst.frc.team178.robot.*;
import org.usfirst.frc.team178.robot.subsystems.*;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class JoystickDrive extends Command {

		OI oi;
		Drivetrain drivetrain;
		double yVal;
		double twistVal;
		
    public JoystickDrive() {
    	requires(Robot.drivetrain);
    }

  //Called just before this Command runs for the first time
    
    protected void initialize() {
    	oi = Robot.oi;
    	drivetrain = Robot.drivetrain;
    
  
    }

  //Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	yVal = oi.getY();
		twistVal = 0.5*(oi.getTwist());
		//System.out.println("Y Val: " + yVal);
		//System.out.println("Twist Val: " + twistVal);
		//System.out.println("X Val: " + oi.getX());

		
		//The if condition implements what's called a dead zone. 
		//Makes it so that the robot will only drive when the driver is touching the joystick. Joysticks sometimes send
		//small numbers when they're not actually touched. This eliminates that. 

		if(Math.abs(yVal)>0.1 || Math.abs(twistVal)>0.1){
			drivetrain.drive(twistVal-yVal, twistVal+yVal);
		}
		else {
			drivetrain.drive(0,0);
		}
	//	System.out.println(oi.getY());
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

  //Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
   //subsystems are scheduled to run
    protected void interrupted() {
    }
}
