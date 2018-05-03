package org.usfirst.frc.team178.robot.commands;

import org.usfirst.frc.team178.robot.OI;
import org.usfirst.frc.team178.robot.Robot;
import org.usfirst.frc.team178.robot.subsystems.CubeIntake;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class AutoVaultDrop extends Command {
	OI oi;
	CubeIntake cubeintake;
	double speed;
	
    public AutoVaultDrop(double sp) {
    	requires(Robot.cubeintake);
    	speed = sp;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	oi = Robot.oi;
    	cubeintake = Robot.cubeintake;
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	cubeintake.ejectCube(speed);
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
