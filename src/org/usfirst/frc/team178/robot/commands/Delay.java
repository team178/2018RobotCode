package org.usfirst.frc.team178.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class Delay extends Command {
	double time;
	int counter;
    public Delay(double tm) {
        time = tm;
        counter = (int) time * 50;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	//Delay the start of a command
    	counter--;
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	if(counter <= 0) {
    		return true;
    	}
    	else {
    		return false;
    	}
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
