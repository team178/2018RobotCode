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
    	drivetrain.resetEncoders();
    	//right motors are negative value because of how they are oriented on the robot
    	drivetrain.resetEncoders();
    	drivetrain.drive(robotSpeed, -robotSpeed);
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
  //  	System.out.println("Right:" + String.format("%.5g%n", drivetrain.getRightSpeed()) + "Left:" + String.format("%.5g%n", drivetrain.getLeftSpeed()));
    	double error = drivetrain.getLeftSpeed() - drivetrain.getRightSpeed(); // subtracts to find error value
		if (Math.abs(error) > 0.001) { // checks to see if the error value is greater than .001
			// drives only left side
			adjustedSpeed -= 0.0001 * error; // changes adjustedSpeed to adjustedSpeed + a constant*error
			// System.out.println("LeftDistance: " +
			// drivetrain.getLeftDistance());
			// System.out.println("RightDistance: " +
			// drivetrain.getRightDistance());
		//	 System.out.println("RightSpeed: " + drivetrain.getRightSpeed());
		//	 System.out.println("LeftSpeed: " + drivetrain.getLeftSpeed());
			double speedChange = .5 + (distance - drivetrain.getRightDistance()) / distance;
			if (drivetrain.getLeftDistance() <= (distance * .7)) {
				double leftSpd = robotSpeed * speedChange;
				double rightSpd = adjustedSpeed * speedChange;
				double minSpeed = .1;
				if (Math.abs(leftSpd) <= minSpeed && leftSpd > 0) {
					leftSpd = minSpeed;
				} else if (Math.abs(leftSpd) <= minSpeed && leftSpd < 0) {
					leftSpd = -minSpeed;
				} 

				if (Math.abs(rightSpd) <= minSpeed && rightSpd > 0) {
					rightSpd = minSpeed;
				} else if (Math.abs(rightSpd) <= minSpeed && rightSpd < 0) {
					rightSpd = -minSpeed;
				} 
				drivetrain.drive(leftSpd, rightSpd);
				//System.out.println("Left Distance: " + drivetrain.getLeftDistance());
				//System.out.println("Right Distance: " + drivetrain.getRightDistance());
			}
    		else
    		{
    			drivetrain.leftDrive(robotSpeed);
    			drivetrain.rightDrive(adjustedSpeed);
    		}
    	}
//		System.out.println("E:" + drivetrain.getLeftDistance());
    }
    

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	System.out.println(drivetrain.getLeftDistance());
    	if (drivetrain.getLeftDistance() >= distance)

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
