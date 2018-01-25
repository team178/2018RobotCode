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
    	drivetrain.straightAdj.setSetpoint(0);
    	drivetrain.straightAdj.setOutputRange(-1, 1);
    	drivetrain.straightAdj.enable();
    	
    	drivetrain.drive(robotSpeed, -robotSpeed);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	
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
