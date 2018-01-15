package org.usfirst.frc.team178.robot.commands;

import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.command.Command;


import org.usfirst.frc.team178.robot.OI;
import org.usfirst.frc.team178.robot.Robot;
import org.usfirst.frc.team178.robot.subsystems.Drivetrain;


/**
 *
 */
public class AutoTurn extends Command {
	OI oi;
	Drivetrain drivetrain;
	AnalogGyro gyro;
	double lspeed, rspeed, targetAngle, actualAngle;
	
	
    public AutoTurn(double tAngle, double speed) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    requires(Robot.drivetrain);
    targetAngle = tAngle;
    lspeed = speed;
    rspeed = speed;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
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
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
