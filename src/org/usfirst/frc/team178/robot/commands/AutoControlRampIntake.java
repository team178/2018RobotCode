package org.usfirst.frc.team178.robot.commands;

import org.usfirst.frc.team178.robot.OI;
import org.usfirst.frc.team178.robot.Robot;
import org.usfirst.frc.team178.robot.subsystems.Ramp;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class AutoControlRampIntake extends Command {
	double time;
	int counter;
	OI oi;
	Ramp ramp;
	double speed;
	
    public AutoControlRampIntake(double spe, double t) {
        requires(Robot.ramp);    
        speed = spe;
        time = t;
        counter = (int) time * 50;
        }

    // Called just before this Command runs the first time
    protected void initialize() {
    	oi =  Robot.oi;
    	ramp = Robot.ramp;
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	counter--;
    	ramp.bringCubeIn(-speed);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	if(counter <= 0) {
    		return true;
    	} else {
        return false;
    	}
    }

    // Called once after isFinished returns true
    protected void end() {
    	ramp.bringCubeIn(0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {

    	ramp.bringCubeIn(0);
    }
}
