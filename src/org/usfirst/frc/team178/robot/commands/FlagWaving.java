package org.usfirst.frc.team178.robot.commands;

import org.usfirst.frc.team178.robot.Robot;
import org.usfirst.frc.team178.robot.subsystems.Climber;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class FlagWaving extends Command {
	Climber climber;
	int timer;
	boolean forward;
    public FlagWaving() {
    	requires(Robot.climber);
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	climber = Robot.climber;
    	timer = 0;
    	forward = true;
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if(timer == 210) {
    		timer = 0;
    		forward = !forward;
    	}
    	//climber.retractArm();
    	if(forward) {
    		if(timer % 70 <35)
    			climber.rotate(-0.15);
    		else
    			climber.rotate(.15);
    	}
    	else {
    		climber.rotate(.15);
    	}
    		
    	System.out.println(timer);
    	timer++;
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
   // 	climber.extendArm();
    	climber.rotate(0);
    }
}
