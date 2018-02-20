package org.usfirst.frc.team178.robot.commands;

import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.command.Command;


import org.usfirst.frc.team178.robot.OI;
import org.usfirst.frc.team178.robot.Robot;
import org.usfirst.frc.team178.robot.subsystems.Drivetrain;


/**
 *
 */
public class AutoTurnBackup extends Command {
	OI oi;
	Drivetrain drivetrain;
	double lspeed, rspeed, targetAngle, actualAngle;
	
	
    public AutoTurnBackup(double tAngle, double speed) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    requires(Robot.drivetrain);
    targetAngle = tAngle;
    lspeed = speed;
    rspeed = speed;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	oi = Robot.oi;
    	drivetrain = Robot.drivetrain;
    	drivetrain.resetGyro();
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	System.out.println(drivetrain.getAngle());
    	actualAngle = drivetrain.getAngle();
    	double speedChange = ((targetAngle - actualAngle)/ targetAngle);
    	
    	if (Math.abs(actualAngle) >= .8 * Math.abs(targetAngle))
    	{
    		double leftSpeed = lspeed * speedChange;
    		double rightSpeed = rspeed * speedChange;
    		double minSpeed = .1;
    		if (Math.abs(leftSpeed)<= minSpeed && leftSpeed > 0)
    		{
    			leftSpeed = minSpeed;
    		}
    		if (Math.abs(leftSpeed)<= minSpeed && leftSpeed <= 0)
    		{
    			rightSpeed = -minSpeed;
    		}
    	}
    		else
    		{
    			drivetrain.drive(lspeed, rspeed);
    		}
    	}
    

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	if (Math.abs(actualAngle) > Math.abs(targetAngle))
    	{
    		return true;
    	}
    	else
    	{
    		return false;
    	}
    }

    // Called once after isFinished returns true
    protected void end() {
    	drivetrain.drive(0, 0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
