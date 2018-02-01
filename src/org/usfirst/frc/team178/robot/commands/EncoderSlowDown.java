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
	double distanceSetpoint, previousDistError, integralDist = 0, dP = 0.001, dI, dD; //Variables for distance PID
  
	
	
	public EncoderSlowDown(double speed, double dist) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
		requires(Robot.drivetrain);
    	robotSpeed = speed;
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
    	drivetrain.drive(stopPID(), -stopPID());
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
    
    
	public double stopPID()
	{
		
		double currentDist = (drivetrain.getRightDistance() + drivetrain.getLeftDistance())/2;		//average distance feedback from two encoders
		//How far the Robot is from it's target distance
		double fromTargetDist = distanceSetpoint - currentDist;  
	//	double angleError = drivetrain.getAngle() - angleSetpoint;
		integralDist += (fromTargetDist * .02);
		double derivative = (fromTargetDist - previousDistError)/.02;
		previousDistError = fromTargetDist;
		double output = (dP * fromTargetDist + dI * integralDist + dD * derivative);
		/*if (drivetrain.getLeftSpeed() > .3 && fromTargetDist < 50)
		{
			
		}
		*/
		return (robotSpeed-output);
	}
	
	public void setDistanceSetpoint(double target)
	{
		this.distanceSetpoint = target;
	}
	
}
