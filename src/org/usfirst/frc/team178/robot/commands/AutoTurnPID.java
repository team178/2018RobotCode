package org.usfirst.frc.team178.robot.commands;

import org.usfirst.frc.team178.robot.OI;
import org.usfirst.frc.team178.robot.Robot;
import org.usfirst.frc.team178.robot.subsystems.Drivetrain;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class AutoTurnPID extends Command {
	OI oi;
	Drivetrain drivetrain;
	double robotSpeed, targetAngle, actualAngle;
	double angleSetpoint, angleIntegral, previousAngle, angleDerivative, aP= 1, aI= 0.01, aD = 0.01;
	static int counter;
	boolean resetGyro;
	double currentAngle;
	
	
    public AutoTurnPID(double tAngle, double speed, boolean resetG) {
    requires(Robot.drivetrain);
    targetAngle = tAngle;
    robotSpeed = speed;
    resetGyro = resetG;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	oi = Robot.oi;
    	drivetrain = Robot.drivetrain;
    	if(resetGyro)
    		drivetrain.resetGyro();
    	counter = 0;
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	counter++;
    	System.out.println("Counter:" + counter);
    	currentAngle = drivetrain.getAngle();
    	System.out.println("Current Angle: " + currentAngle);	
    	setAngleSetpoint(targetAngle);
    	double valuePID = turnPID(currentAngle);
    	if (currentAngle < targetAngle) {
    		drivetrain.drive(robotSpeed*valuePID, robotSpeed*valuePID);
    	} //else {
    	else if(currentAngle > targetAngle)
    	{
    		drivetrain.drive(-(robotSpeed*valuePID), -(robotSpeed * valuePID));
    	}
    	
    }
    

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	System.out.println("OVer HErE");
    	if ((Math.abs(drivetrain.getAngle() - targetAngle) < 1.5 && Math.abs(angleDerivative) < 0.03) || counter >= 80) {
    		System.out.println("stop turning");
    		return true;
    	} else {
    		return false;
    	}
    }

    protected void end() {
    	drivetrain.drive(0, 0);
    }

    protected void interrupted() {
    	drivetrain.drive(0,0);
    }
    
    public double turnPID(double currentAngle)
	{
    	if(targetAngle > 0)
    	{
    		aP = .3;
    		aI= .01;
    		aD = .01;
    	}
    	else
    		aP = .5;
    		aI= .02;
    		aD = .01;
		//How far the Robot is from it's target distance
		double angleError = Math.abs(angleSetpoint - currentAngle);  //inverse of difference between current distance and target distance 
		angleIntegral += (angleError * .02);
		angleDerivative = (angleError - previousAngle)/.02;
		previousAngle = angleError;
		double output = 1- 1/(aP * angleError + aI * angleIntegral + aD * angleDerivative); //inverse of output	
		return output;
	}
    
    public void setAngleSetpoint(double target)
	{
		this.angleSetpoint = target;
	}
}