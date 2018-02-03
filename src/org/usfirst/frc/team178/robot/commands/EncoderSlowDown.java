package org.usfirst.frc.team178.robot.commands;

import org.usfirst.frc.team178.robot.OI;
import org.usfirst.frc.team178.robot.Robot;
import org.usfirst.frc.team178.robot.subsystems.Drivetrain;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class EncoderSlowDown extends Command {
	Drivetrain drivetrain;
	OI oi;
	double robotSpeed, distance;
	double distanceSetpoint, previousDistError, integralDist = 0, dP = 1.4, dI, dD, previousSpeed; //Variables for distance PID
	//double decRate = robotSpeed/distance;
  
	
	
	public EncoderSlowDown(double dist, double speed) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
		requires(Robot.drivetrain);
    	robotSpeed = speed;
    	previousSpeed = speed;
    	distance = dist;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	oi = Robot.oi;
    	drivetrain = Robot.drivetrain;
    	drivetrain.resetGyro();
    	drivetrain.resetEncoders();
    	setDistanceSetpoint(distance);
    	drivetrain.drive(robotSpeed, -robotSpeed);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	System.out.println(stopPID());
    	drivetrain.drive(stopPID(), -stopPID());
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	if (drivetrain.getLeftDistance()>= distance)
    	{
    		return true;
    	}
        	return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	drivetrain.drive(0, 0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	drivetrain.drive(0, 0);
    }
    
    
	public double stopPID()
	{
		double currentDist = (drivetrain.getRightDistance() + drivetrain.getLeftDistance())/2;		//average distance feedback from two encoders
		//How far the Robot is from it's target distance
		double decError = (distanceSetpoint - currentDist);  //inverse of difference between current distance and target distance 
	//	double angleError = drivetrain.getAngle() - angleSetpoint;
		integralDist += (decError * .02);
		double derivative = (decError - previousDistError)/.02;
		previousDistError = decError;
		double output = 1/ (dP * decError + dI * integralDist + dD * derivative); //inverse of output
		/*if (drivetrain.getLeftSpeed() > .3 && decError < 50)
		{
			
		}
		*/
		double newSpeed = previousSpeed * (1-output);
		previousSpeed = previousSpeed * (1-output);
		return newSpeed;
	}
	
	public void setDistanceSetpoint(double target)
	{
		this.distanceSetpoint = target;
	}
	
}
