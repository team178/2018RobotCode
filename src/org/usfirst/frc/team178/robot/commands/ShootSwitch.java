package org.usfirst.frc.team178.robot.commands;

import org.usfirst.frc.team178.robot.Robot;
import org.usfirst.frc.team178.robot.subsystems.Ramp;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ShootSwitch extends Command {
	Ramp ramp;
	double time;
    public ShootSwitch() {
    	time = 100000000;
    	requires (Robot.ramp);
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	ramp = Robot.ramp;
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	ramp.bringCubeIn(.25);
    	ramp.shootCube(.25);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	double passedTime = timeSinceInitialized();
    	if (passedTime >= time) {
    		return true;
    	}
    	else {
    		return false;
    	}
    }

    // Called once after isFinished returns true
    protected void end() {
    	ramp.stopLoading();
    	ramp.stopShooting();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
