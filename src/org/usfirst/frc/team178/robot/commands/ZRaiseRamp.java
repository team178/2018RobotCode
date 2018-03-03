package org.usfirst.frc.team178.robot.commands;

import org.usfirst.frc.team178.robot.Robot;
import org.usfirst.frc.team178.robot.subsystems.Ramp;

import edu.wpi.first.wpilibj.command.Command;

/**
 *THIS CLASS IS CURRENTLY NOT IN USE, BUT DO NOT DELETE
 */
public class ZRaiseRamp extends Command {
	Ramp ramp;
    public ZRaiseRamp() {
    	requires(Robot.ramp);
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	ramp = Robot.ramp;
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	//ramp.raiseRamp();
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
