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
	double P = .02, I = 0, D = 0;
	double integral = 0;
	double Setpoint, previousError;
	double output;
	
	public void PID()
	{
		double error = Setpoint - drivetrain.getAngle();
		integral += (error * .02);
		double derivative = (error - previousError)/ .02;;
		output = P * error + I * integral +  D * derivative;    //Will add Integral and derivative later
		previousError = error;
	}
	
	public void setSetpoint(int setpoint)
	{
		this.Setpoint = setpoint;
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
    /*	drivetrain.straightAdj.setSetpoint(0);
    	drivetrain.straightAdj.setOutputRange(-1, 1);
    	drivetrain.straightAdj.enable();*/
    	drivetrain.drive(robotSpeed, -robotSpeed);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	PID();
    	drivetrain.drive((robotSpeed * (1-output)), -robotSpeed);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	drivetrain.straightAdj.disable();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	drivetrain.straightAdj.disable();
    }
}
