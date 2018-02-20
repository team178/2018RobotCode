package org.usfirst.frc.team178.robot.commands;

import org.usfirst.frc.team178.robot.OI;
import org.usfirst.frc.team178.robot.Robot;
import org.usfirst.frc.team178.robot.subsystems.Drivetrain;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DriveBackwards extends Command {
	public final double driveConstant = 22.36;
	Drivetrain drivetrain;
	OI oi;
	double robotSpeed, distance; 
	
	//Variables for angle adjustment
	double aP = 0.1, aI = 0.1, aD = 0, aIntegral = 0; //These are all constants that need to be determined through testing and tuned
	//I and D curren ly set to 0 as I want to implement one part at a time successfully
	double angleSetpoint, previousAngleError;

	//Variables for slowing down
	double  dIntegral = 0, dP = .9, dI = 0.0, dD = 0.0; //Variables for distance PID
	double previousSpeedL,previousSpeedR ,distanceSetpoint, previousDistError;

	public DriveBackwards(double dist, double speed) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.drivetrain);
    	robotSpeed = speed; //units = Factor between -1 and 1
    	distance = dist; //units = inches
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	oi = Robot.oi;
    	drivetrain = Robot.drivetrain;
    	previousSpeedL = robotSpeed;
    	previousSpeedR = robotSpeed;
    	drivetrain.resetGyro();
    	drivetrain.resetEncoders();
    	setAngleSetpoint(0);
    	setDistanceSetpoint(distance);
    	drivetrain.drive(previousSpeedL, -previousSpeedR);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	drivetrain.drive(-.3, .3);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	//.System.out.println((distance - drivetrain.getLeftDistance()));
    	if(drivetrain.getRightDistance() < distance)
    	{
    		System.out.println("Finished driving");
    		return true;
    	} else {
    //		System.out.println("I'm actually finished!");
    		 return false;
    	}
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
	
	
	public double stopPID()
	{
		double currentDist = Math.abs(drivetrain.getRightDistance() + drivetrain.getLeftDistance())/2;		//average distance feedback from two encoders
		//How far the Robot is from it's target distance
		double distError = Math.abs(distanceSetpoint - currentDist);  //inverse of difference between current distance and target distance 
		dIntegral += (distError * .02);
		double derivative = (distError - previousDistError)/.02;
		previousDistError = distError;
		double output = 1-(1/ (dP * distError + dI * dIntegral + dD * derivative)); //inverse of output
		//double newSpeed = previousSpeed * (1-output);
		//previousSpeed = previousSpeed * (1-output);
		return output;
	}
	
	
	public void setDistanceSetpoint(double target)
	{
		this.distanceSetpoint = target;
	}
	
	public double straightPID() //Note to self, maybe change this to just straight up return the output and make it a double method
	{
		double error = drivetrain.getAngle() - angleSetpoint; //calculates devation from intended angle 			//Need to add absolute Vaule? -- Robbie
		aIntegral += (error * .02); //Integral is the sum of all the errors while running (* the iteration time which is 20 ms)
		double derivative = (error - previousAngleError)/ .02; //change in error * iteration time (20 ms)
		previousAngleError = error; //sets this last calculated error as the "previousError" for the next time the method is run
		double output = ( aP * error + aI * aIntegral +  aD * derivative);    //Uses the PID equation to get an output
		return output;
	}
	
	public void setAngleSetpoint(int setpoint)
	{
		this.angleSetpoint = setpoint; //sets the target value (which is the orientation of the robot in degrees)
	}
	


    
}
