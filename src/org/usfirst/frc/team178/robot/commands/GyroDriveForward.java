package org.usfirst.frc.team178.robot.commands;

import org.usfirst.frc.team178.robot.OI;
import org.usfirst.frc.team178.robot.Robot;
import org.usfirst.frc.team178.robot.subsystems.Drivetrain;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class GyroDriveForward extends Command {
	Drivetrain drivetrain;
	OI oi;
	double robotSpeed, distance; 
	double P = 0.1, I = 0.1, D = 0; //These are all constants that need to be determined through testing and tuned
	//I and D currently set to 0 as I want to implement one part at a time successfully
	double integral = 0;
	double angleSetpoint, previousAngleError;
	double distanceSetpoint, previousDistError, integralDist = 0, dP, dI, dD; //Variables for distance PID

	
	
	public double stopPID()
	{
		//How far the Robot is from it's target distance
		double fromTargetDist = distanceSetpoint - ((drivetrain.getRightDistance() + drivetrain.getLeftDistance())/2);  // Compares target and average encoder feedback
	//	double angleError = drivetrain.getAngle() - angleSetpoint;
		integralDist += (fromTargetDist * .02);
		double derivative = (fromTargetDist - previousDistError)/.02;
		previousDistError = fromTargetDist;
		double output = (dP * fromTargetDist + dI * integralDist + dD * derivative);
		
		/*if (drivetrain.getLeftSpeed() > .3 && fromTargetDist < 50)
		{
			
		}
		*/
		return output;
	}
	
	public void setDistanceSetpoint(double target)
	{
		this.distanceSetpoint = target;
	}
	
	public double straightPID() //Note to self, maybe change this to just straight up return the output and make it a double method
	{
		double error = drivetrain.getAngle() - angleSetpoint; //calculates devation from intended angle
		integral += (error * .02); //Integral is the sum of all the errors while running (* the iteration time which is 20 ms)
		double derivative = (error - previousAngleError)/ .02; //change in error * iteration time (20 ms)
		previousAngleError = error; //sets this last calculated error as the "previousError" for the next time the method is run
		double output = ( P * error + I * integral +  D * derivative);    //Uses the PID equation to get an output
		return output;
	}
	
	public void setAngleSetpoint(int setpoint)
	{
		this.angleSetpoint = setpoint; //sets the target value (which is the orientation of the robot in degrees)
	}
	


    public GyroDriveForward(double dist, double speed) {
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
    	setAngleSetpoint(0);
    /*	drivetrain.straightAdj.setSetpoint(0);
    	drivetrain.straightAdj.setOutputRange(-1, 1);
    	drivetrain.straightAdj.enable();*/
    	drivetrain.drive(robotSpeed, -robotSpeed);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	System.out.println(drivetrain.getAngle());
    	double currentPID = straightPID();
    	if(currentPID < 0)
    	{
    		drivetrain.drive(robotSpeed, -(robotSpeed*(1-Math.abs(currentPID))));
    		//drivetrain.drive(, rightMotors);
    	}
    	else
    	{
    		drivetrain.drive(robotSpeed * (1-currentPID), -robotSpeed);
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	if (drivetrain.getLeftDistance() >= distance)
    	{
    		return true;
    	}
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	//drivetrain.straightAdj.disable();
    	drivetrain.drive(0,0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	//drivetrain.straightAdj.disable();
    	drivetrain.drive(0, 0);
    }
}
