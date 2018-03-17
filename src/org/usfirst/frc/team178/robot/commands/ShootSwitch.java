package org.usfirst.frc.team178.robot.commands;

import org.usfirst.frc.team178.robot.OI;
import org.usfirst.frc.team178.robot.Robot;
import org.usfirst.frc.team178.robot.subsystems.Ramp;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ShootSwitch extends Command {
	Ramp ramp;
	double yVal;
	boolean isAuto;
    public ShootSwitch(boolean ia) {
    	requires (Robot.ramp);
    //	isAuto = ia;
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	ramp = Robot.ramp;
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	//ramp.extendArm();
    	ramp.shootCube(0.5);
    	ramp.bringCubeIn(0.5);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    //	if(isAuto) {
    	//	return true;
    //	} else {
    		return false;
    //	}
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
 //   	ramp.retractArm();
    	ramp.stopLoading();
    	ramp.stopShooting();
    }
}
