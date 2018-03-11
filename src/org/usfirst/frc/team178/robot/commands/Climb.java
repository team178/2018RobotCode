package org.usfirst.frc.team178.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team178.robot.*;
import org.usfirst.frc.team178.robot.subsystems.Climber;
/**
 *
 */
public class Climb extends Command {

	OI oi;
    Climber climber;
	
	public Climb() {
    	requires(Robot.climber);
    	
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	climber = Robot.climber;
    	oi = Robot.oi;
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if(oi.startButton.get() && oi.backButton.get())
    		climber.climb(-.5);
    	else
    		climber.climb(1);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {	
    	return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    //	climber.climb(0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	climber.climb(0);
    }
}
