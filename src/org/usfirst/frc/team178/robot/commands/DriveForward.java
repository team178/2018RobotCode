package org.usfirst.frc.team178.robot.commands;

import org.usfirst.frc.team178.robot.OI;
import org.usfirst.frc.team178.robot.Robot;
import org.usfirst.frc.team178.robot.subsystems.Drivetrain;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DriveForward extends Command {
	Drivetrain drivetrain;
	OI oi;
	double distance, robotSpeed, adjustedSpeed;
	

    public DriveForward(double dist, double spd) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.drivetrain);
    	distance = dist;
    	robotSpeed = spd;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	oi = Robot.oi;
    	drivetrain = Robot.drivetrain;
    	adjustedSpeed = -robotSpeed;
    	//right motors are negative value because of how they are oriented on the robot
    	drivetrain.drive(robotSpeed, -robotSpeed);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	//Finds the difference between the speeds of both sides of the robot from the encoders (Ideally want it to be the same so it drives straight)
    	double diff = drivetrain.getLeftSpeed() - drivetrain.getRightSpeed();
    	//threshhold to consider what is a sizeable-enough difference in speeds that it needs to be adjusted
    	if (Math.abs(diff) > 0.01)
    	{
    		//adjusts the speed based on a constant * the difference in speeds
    		adjustedSpeed -= .001 * diff;
    		//Prints the current speed of both sides of the robot in the console
    		System.out.println("Right Speed:" + drivetrain.getRightSpeed());
    		System.out.println("Left Speed:" + drivetrain.getLeftSpeed());
    		double speedChange = .5 * (distance - drivetrain.getRightSpeed());
    		if (drivetrain.getLeftDistance() <= .7 * distance )
    		{
    			double leftSpeed = robotSpeed * speedChange;
    			double rightSpeed = adjustedSpeed * speedChange;
    			double minSpeed = .1;
    			if (Math.abs(leftSpeed) <= minSpeed && rightSpeed > 0)
    			{
    				leftSpeed = minSpeed;
    			}
    			else if (Math.abs(rightSpeed) <= minSpeed && rightSpeed < 0)
    			{
    				rightSpeed = -minSpeed;
    			}
    			drivetrain.drive(leftSpeed, rightSpeed);
    		}
    		else
    		{
    			drivetrain.leftDrive(robotSpeed);
    			drivetrain.rightDrive(adjustedSpeed);
    		}
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	if (drivetrain.getLeftSpeed() >= distance)
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
