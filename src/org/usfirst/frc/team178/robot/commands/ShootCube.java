package org.usfirst.frc.team178.robot.commands;

import org.usfirst.frc.team178.robot.Robot;
import org.usfirst.frc.team178.robot.subsystems.CubeShooter;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ShootCube extends Command {

	CubeShooter cubeshooter;
	
    public ShootCube() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.cubeshooter);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	cubeshooter = new CubeShooter();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	cubeshooter.shootCube(.75);
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