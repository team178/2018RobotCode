package org.usfirst.frc.team178.robot.commands;

import org.usfirst.frc.team178.robot.Robot;
import org.usfirst.frc.team178.robot.subsystems.Climber;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ReverseRotateArm extends Command {
	Climber climber;
    public ReverseRotateArm() {
    	requires(Robot.climber);
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	climber = Robot.climber;
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	climber.retractArm();
    	climber.rotate(0.4);
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
    	climber.extendArm();
    	climber.rotate(0);
    }
}
