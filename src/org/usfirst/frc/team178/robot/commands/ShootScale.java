package org.usfirst.frc.team178.robot.commands;

import org.usfirst.frc.team178.robot.Robot;
import org.usfirst.frc.team178.robot.subsystems.Ramp;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ShootScale extends Command {
	Ramp ramp;
	double time;
    public ShootScale() {
    	time = 100000000;
    	requires(Robot.ramp);
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	ramp = Robot.ramp;
//    	ultrasonic = Robot.ultrasonic;
    }
    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	System.out.println(ramp.getDistance());
    	//ramp.bringCubeIn(.75);
  // 	if (ramp.getDistance() <= 1) {
   //		System.out.println("covered");
		//ramp.punchCube();	
   		//ramp.shootCube(1);
    //	}
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
    	ramp.resetPiston();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	ramp.stopLoading();
    	ramp.stopShooting();
    	ramp.resetPiston();
    }
}
